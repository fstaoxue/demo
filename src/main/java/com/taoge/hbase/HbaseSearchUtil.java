package com.taoge.hbase;


import org.apache.poi.ss.formula.functions.T;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author taoxuefeng
 * @date 2020/03/09
 */
public class HbaseSearchUtil {

    /**
     * 根据类型、时间段、主副表获取hbase表名
     *
     * @param infoType  主类型
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param tableType 主父表
     * @return
     */
    public static Set<String> findCollHbase(InfoType infoType, long startTime, long endTime, TableType tableType) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate startDate = Instant.ofEpochSecond(startTime).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        LocalDate endDate = Instant.ofEpochSecond(endTime).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        Set<String> tables = new HashSet<>();
        tables.add(time2Coll(infoType, startDate.format(formatter), tableType));
        tables.add(time2Coll(infoType, endDate.format(formatter), tableType));
        while (startDate.isBefore(endDate)) {
            startDate = startDate.plusDays(1);
            tables.add(time2Coll(infoType, startDate.format(formatter), tableType));
        }

        return tables;
    }

    /**
     * 根据类型、日期、主副表拼接hbase表名
     *
     * @param infoType  主类型
     * @param date      日期
     * @param tableType 主副表
     * @return
     */
    public static String time2Coll(InfoType infoType, String date, TableType tableType) {
        String result = "he";
        if (infoType == InfoType.SOCIETY) {
            result = "eh";
        }
        switch (infoType) {
            //社会数据、人数据hbase按周存储
            case SOCIETY:
            case IDCARD:
                result += infoType.getValue() + "_" + getWeek(date);
                break;
            //手机号、车牌号数据hbase按天存储
            case PLATE:
            case PHONE:
                result += infoType.getValue() + "_" + date;
                break;
            default:
                result += infoType.getValue() + "_" + date;
        }
        //副表加后缀rep
        if (tableType == TableType.REPLICA) {
            result += "_" + "eh";
        }
        return result;
    }

    private static String getWeek(String date) {
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return localDate.getYear() + "" + localDate.get(weekFields.weekOfYear());
    }

    public static String[] getRowkey(String acc, String type, long startTime, long endTime) {
        String prefix = "he";
        String sufix = "pre";
        List<T> onlyHbaseResult = new ArrayList<>();
        String[] startEndKey = new String[2];
        String info = acc;


        startEndKey[0] = info + "_" + type + "_" + startTime;
        startEndKey[1] = info + "_" + type + "_" + endTime;
        return startEndKey;

    }

    public static void main(String[] args) {
        long startTime = getStamp("2019-01-01 12:00:00");
        long endTime = getStamp("2019-01-10 13:09:09");
        Set<String> collHbase = findCollHbase(InfoType.PHONE, startTime, endTime, TableType.REPLICA);
        Set<String> collHbase1 = findCollHbase(InfoType.PLATE, startTime, endTime, TableType.REPLICA);
        Set<String> collHbase2 = findCollHbase(InfoType.IDCARD, startTime, endTime, TableType.REPLICA);
        Set<String> collHbase3 = findCollHbase(InfoType.SOCIETY, startTime, endTime, TableType.REPLICA);
        System.out.println(collHbase);
        System.out.println(collHbase1);
        System.out.println(collHbase2);
        System.out.println(collHbase3);
    }


    public static long getStamp(String day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(day).getTime() / 1000L;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
