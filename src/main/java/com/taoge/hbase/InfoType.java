package com.taoge.hbase;

/**
 * @author taoxuefeng
 * @date 2020/03/09
 */
public enum InfoType {
    /** 手机号 */
    PHONE("0","phone"),
    /** 车牌号 */
    PLATE("1","plate"),
    /** 人 */
    IDCARD("2","idCard"),
    /** 社会数据 */
    SOCIETY("3","society");

    private String value;

    private String type;

    InfoType(String value,String type) {
        this.value = value;
        this.type=type;
    }

    public String getValue() {
        return value;
    }

    public static InfoType indexOf(String type){
        for(InfoType temp:InfoType.values()){
            if(temp.type.equalsIgnoreCase(type)){
                return temp;
            }
        }
        return null;
    }

}
