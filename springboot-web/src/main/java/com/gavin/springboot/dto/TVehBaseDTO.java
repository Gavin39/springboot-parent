package com.gavin.springboot.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 车辆基本信息表
 * </p>
 *
 * @author Gavin
 * @since 2021-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TVehBasePO对象", description="车辆基本信息表")
public class TVehBaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "车架号")
    private String vin;

    private String keyid;

    @ApiModelProperty(value = "车型编码")
    private String typeCode;

    @ApiModelProperty(value = "车辆公告型号")
    private String vehType;

    @ApiModelProperty(value = "车系")
    private String carLine;

    @ApiModelProperty(value = "车辆生产日期")
    private String vehProductionDate;

    @ApiModelProperty(value = "车辆颜色")
    private String vehColor;

    @ApiModelProperty(value = "tbox序列号")
    private String tboxSerialNum;

    @ApiModelProperty(value = "蓝牙mac地址")
    @TableField("btkey_mac_add")
    private String btkeyMacAdd;

    @ApiModelProperty(value = "tbox零件号")
    private String tboxPartNum;

    @ApiModelProperty(value = "车机序列号")
    private String vehSerialNum;

    @ApiModelProperty(value = "车机零件号")
    private String vehPartNum;

    @ApiModelProperty(value = "仪表盘序列号")
    private String dashboardSerialNum;

    @ApiModelProperty(value = "仪表盘零件号")
    private String dashboardPartNum;

    @ApiModelProperty(value = "IMSI")
    private String imsi;

    @ApiModelProperty(value = "ICCID")
    private String iccid;

    @ApiModelProperty(value = "MDN")
    private String mdn;

    @ApiModelProperty(value = "新车类型： 1：销售车 2：体验车 3：畅享车")
    private String vehicleStyle;

    @ApiModelProperty(value = "车辆用途")
    private String carUsed;

    @ApiModelProperty(value = "终端类型")
    private String terminalType;

    @ApiModelProperty(value = "车载终端编号")
    private String terminalNo;

    @ApiModelProperty(value = "终端厂商")
    private String terminalFirm;

    @ApiModelProperty(value = "驱动电机序号(电机序列号)")
    private String motSerialNum;

    @ApiModelProperty(value = "发动机编号")
    private String engineNumber;

    @ApiModelProperty(value = "储能装置电池包(箱)编码")
    private String tccode;

    @ApiModelProperty(value = "可充电储能系统编码(电池序列号)")
    private String batSerialNum;

    @ApiModelProperty(value = "电池模组生产日期")
    private String batPackageDate;

    @ApiModelProperty(value = "车辆销售状态:已上线，已销售")
    private String carSaleStatus;

    @ApiModelProperty(value = "出库日期")
    private String carOutTime;

    @ApiModelProperty(value = "客户id")
    private String customerId;

    @ApiModelProperty(value = "客户名称（车主）")
    private String customerName;

    @ApiModelProperty(value = "车牌")
    private String carNo;

    @ApiModelProperty(value = "销售省份")
    private String saleProvince;

    @ApiModelProperty(value = "销售城市")
    private String saleCity;

    @ApiModelProperty(value = "销售县区")
    private String saleCounty;

    @ApiModelProperty(value = "销售日期")
    private String saleDate;

    @ApiModelProperty(value = "车辆行驶证号")
    private String driverLicenseNo;

    @ApiModelProperty(value = " 运营单位地址")
    private String companyAddr;

    @ApiModelProperty(value = "运营单位")
    private String motonCompany;

    @ApiModelProperty(value = "存放地点")
    private String storeAddr;

    @ApiModelProperty(value = "联系人")
    private String linkman;

    @ApiModelProperty(value = "联系电话")
    private String linkphone;

    @ApiModelProperty(value = "法人")
    private String legalPerson;

    @ApiModelProperty(value = "法人代表手机号")
    private String legalPsersonPhone;

    @ApiModelProperty(value = "对应车辆充电桩地址")
    private String vehChargeAddr;

    @ApiModelProperty(value = "车企唯一代码")
    private String vecode;

    @ApiModelProperty(value = "车辆状态")
    private String carStatus;

    @ApiModelProperty(value = "是否vip车辆（1-是，0-否）")
    private Integer vvip;

    @ApiModelProperty(value = "当前离线天数（关联reporttime）")
    private Integer outDay;

    @ApiModelProperty(value = "该车辆MES同步时间")
    private String createTime;

    @ApiModelProperty(value = "首次上传报文时间（为空则更新）")
    private String reporttimeFirst;

    @ApiModelProperty(value = "最新上传报文时间（定时更新）")
    private String reporttime;

    @ApiModelProperty(value = "区分国内海外车（1-国内，2-海外）")
    private Integer chinaFlag;

    @ApiModelProperty(value = "tbox版本号")
    private String tboxVersion;

    private LocalDateTime lastTime;


}
