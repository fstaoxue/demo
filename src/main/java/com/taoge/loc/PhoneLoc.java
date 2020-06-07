package com.taoge.loc;


/**
 * @author taoxuefeng
 * @date 2020/03/10
 * 手机号数据
 */

public class PhoneLoc extends BaseLoc {

    /** 聊天数据 开始*/
    /**
     * 账号
     */
    private String account;
    /**
     * app类型代码
     */
    private String im_type;
    /**
     * 即时信息发送者标识
     */
    private String from_id;
    /**
     * 即时信息接收者标识
     */
    private String to_id;
    /**
     * 聊天数据 即时信息操作类型
     * 输入法数据 操作类型
     */
    private String action;
    /**
     * 即时信息内容
     */
    private String content;
    /** 聊天数据 结束 */
    /** 搜索数据 开始 */
    /**
     * app类型
     */
    private String engine_type;
    /**
     * 搜索数据 搜索关键字
     * 输入法数据 关键字
     */
    private String keyword;
    /** 搜索数据 结束 */
    /** 输入法数据 开始 */
    /**
     * app类型
     */
    private String input_type;
    /** 输入法数据 结束 */

    /**
     * 设备编号
     * wifi 数据
     * 帧码 数据
     */
    private String ssbh;
}
