package com.taoge.loc;

/***
 * @author taoxuefeng
 * @date 2020/03/10
 * 车牌数据
 */

public class PlateLoc extends BaseLoc {
    /**
     * 设备编码
     * 卡口数据
     * RFID数据
     */
    private String sbbh;

    /** ETCP数据 开始 */
    /**
     * 停车库名称
     */
    private String tckmc;
    /**
     * 入库图片
     */
    private String rktp;
    /**
     * 出库图片
     */
    private String cktp;
    /**
     * 出库时间
     */
    private String cksj;
    /** ETCP数据 结束 */
}
