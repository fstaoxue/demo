package com.taoge.loc;

import java.io.Serializable;

/**
 * @author taoxuefeng
 * @date 2020/03/09
 * 基础轨迹点
 */
public class BaseLoc implements Serializable {

    private String sno;

    private String lon;

    private String lat;

    private long cp;

    private String rowkey;

    private String geohash;

    private String type;

    private String info;

}
