package com.taoge.loc;

/**
 * @author taoxuefeng
 * @date 2020/03/10
 * 身份证数据
 */

public class IdentityLoc extends BaseLoc {
    /** 酒店数据 开始 */
    /**
     * 旅馆代码
     */
    private String lgdm;
    /**
     * 酒店数据 姓名
     * 火车安检数据 姓名
     * 飞机安检数据 姓名
     */
    private String xm;
    /**
     * 离开时间
     */
    private String lzsj;
    /**
     * 旅馆名称
     */
    private String lgmc;
    /** 酒店数据 结束 */

    /** 网吧数据 开始 */
    /**
     * 下线时间
     */
    private String offlinetime;
    /**
     * 上网场所ID
     */
    private String siteid;
    /**
     * 上网者姓名
     */
    private String customername;
    /**
     * 网吧名称
     */
    private String wbmc;
    /** 网吧数据 结束 */
    /** 火车安检数据 开始 */
    /**
     * 证件号码
     */
    private String info;
    /**
     * 通过卡口代码
     */
    private String passLevelCode;
    /**
     * 火车站名称
     */
    private String stationName;
    /** 火车安检数据 结束 */
    /** 飞机安检数据 开始 */
    /**
     * 目的地
     */
    private String toAddr;
    /**
     * 始发地
     */
    private String fromAddr;
    /**
     * 航班日期
     */
    private String flightDate;
    /**
     * 航班号
     */
    private String flightNo;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 座位号
     */
    private String seatNo;
    /**
     * 登机口
     */
    private String gate;
    /** 飞机安检数据 结束 */

}
