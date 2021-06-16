package com.gavin.springboot.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("t_veh_base")
@ApiModel(value="TVehBasePO对象", description="车辆基本信息表")
public class TVehBasePO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "车架号")
    @TableId(value = "vin", type = IdType.AUTO)
    private String vin;

    @TableField("keyid")
    private String keyid;

    @ApiModelProperty(value = "车型编码")
    @TableField("type_code")
    private String typeCode;

    @ApiModelProperty(value = "车辆公告型号")
    @TableField("veh_type")
    private String vehType;

    @ApiModelProperty(value = "车系")
    @TableField("car_line")
    private String carLine;

    @ApiModelProperty(value = "车辆生产日期")
    @TableField("veh_production_date")
    private String vehProductionDate;

    @ApiModelProperty(value = "车辆颜色")
    @TableField("veh_color")
    private String vehColor;

    @ApiModelProperty(value = "tbox序列号")
    @TableField("tbox_serial_num")
    private String tboxSerialNum;

    @ApiModelProperty(value = "蓝牙mac地址")
    @TableField("btkey_mac_add")
    private String btkeyMacAdd;

    @ApiModelProperty(value = "tbox零件号")
    @TableField("tbox_part_num")
    private String tboxPartNum;

    @ApiModelProperty(value = "车机序列号")
    @TableField("veh_serial_num")
    private String vehSerialNum;

    @ApiModelProperty(value = "车机零件号")
    @TableField("veh_part_num")
    private String vehPartNum;

    @ApiModelProperty(value = "仪表盘序列号")
    @TableField("dashboard_serial_num")
    private String dashboardSerialNum;

    @ApiModelProperty(value = "仪表盘零件号")
    @TableField("dashboard_part_num")
    private String dashboardPartNum;

    @ApiModelProperty(value = "IMSI")
    @TableField("imsi")
    private String imsi;

    @ApiModelProperty(value = "ICCID")
    @TableField("iccid")
    private String iccid;

    @ApiModelProperty(value = "MDN")
    @TableField("mdn")
    private String mdn;

    @ApiModelProperty(value = "新车类型： 1：销售车 2：体验车 3：畅享车")
    @TableField("vehicle_style")
    private String vehicleStyle;

    @ApiModelProperty(value = "车辆用途")
    @TableField("car_used")
    private String carUsed;

    @ApiModelProperty(value = "终端类型")
    @TableField("terminal_type")
    private String terminalType;

    @ApiModelProperty(value = "车载终端编号")
    @TableField("terminal_no")
    private String terminalNo;

    @ApiModelProperty(value = "终端厂商")
    @TableField("terminal_firm")
    private String terminalFirm;

    @ApiModelProperty(value = "驱动电机序号(电机序列号)")
    @TableField("mot_serial_num")
    private String motSerialNum;

    @ApiModelProperty(value = "发动机编号")
    @TableField("engine_number")
    private String engineNumber;

    @ApiModelProperty(value = "储能装置电池包(箱)编码")
    @TableField("tccode")
    private String tccode;

    @ApiModelProperty(value = "可充电储能系统编码(电池序列号)")
    @TableField("bat_serial_num")
    private String batSerialNum;

    @ApiModelProperty(value = "电池模组生产日期")
    @TableField("bat_package_date")
    private String batPackageDate;

    @ApiModelProperty(value = "车辆销售状态:已上线，已销售")
    @TableField("car_sale_status")
    private String carSaleStatus;

    @ApiModelProperty(value = "出库日期")
    @TableField("car_out_time")
    private String carOutTime;

    @ApiModelProperty(value = "客户id")
    @TableField("customer_id")
    private String customerId;

    @ApiModelProperty(value = "客户名称（车主）")
    @TableField("customer_name")
    private String customerName;

    @ApiModelProperty(value = "车牌")
    @TableField("car_no")
    private String carNo;

    @ApiModelProperty(value = "销售省份")
    @TableField("sale_province")
    private String saleProvince;

    @ApiModelProperty(value = "销售城市")
    @TableField("sale_city")
    private String saleCity;

    @ApiModelProperty(value = "销售县区")
    @TableField("sale_county")
    private String saleCounty;

    @ApiModelProperty(value = "销售日期")
    @TableField("sale_date")
    private String saleDate;

    @ApiModelProperty(value = "车辆行驶证号")
    @TableField("driver_license_no")
    private String driverLicenseNo;

    @ApiModelProperty(value = " 运营单位地址")
    @TableField("company_addr")
    private String companyAddr;

    @ApiModelProperty(value = "运营单位")
    @TableField("moton_company")
    private String motonCompany;

    @ApiModelProperty(value = "存放地点")
    @TableField("store_addr")
    private String storeAddr;

    @ApiModelProperty(value = "联系人")
    @TableField("linkman")
    private String linkman;

    @ApiModelProperty(value = "联系电话")
    @TableField("linkphone")
    private String linkphone;

    @ApiModelProperty(value = "法人")
    @TableField("legal_person")
    private String legalPerson;

    @ApiModelProperty(value = "法人代表手机号")
    @TableField("legal_pserson_phone")
    private String legalPsersonPhone;

    @ApiModelProperty(value = "对应车辆充电桩地址")
    @TableField("veh_charge_addr")
    private String vehChargeAddr;

    @ApiModelProperty(value = "车企唯一代码")
    @TableField("vecode")
    private String vecode;

    @ApiModelProperty(value = "车辆状态")
    @TableField("car_status")
    private String carStatus;

    @ApiModelProperty(value = "是否vip车辆（1-是，0-否）")
    @TableField("vvip")
    private Integer vvip;

    @ApiModelProperty(value = "当前离线天数（关联reporttime）")
    @TableField("out_day")
    private Integer outDay;

    @ApiModelProperty(value = "该车辆MES同步时间")
    @TableField("create_time")
    private String createTime;

    @ApiModelProperty(value = "首次上传报文时间（为空则更新）")
    @TableField("reporttime_first")
    private String reporttimeFirst;

    @ApiModelProperty(value = "最新上传报文时间（定时更新）")
    @TableField("reporttime")
    private String reporttime;

    @ApiModelProperty(value = "区分国内海外车（1-国内，2-海外）")
    @TableField("china_flag")
    private Integer chinaFlag;

    @ApiModelProperty(value = "tbox版本号")
    @TableField("tbox_version")
    private String tboxVersion;

    @TableField("last_time")
    private LocalDateTime lastTime;


}
