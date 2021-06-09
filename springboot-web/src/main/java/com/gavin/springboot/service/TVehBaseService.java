package com.gavin.springboot.service;

import com.gavin.springboot.po.TVehBasePO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 车辆基本信息表 服务类
 * </p>
 *
 * @author Gavin
 * @since 2021-06-03
 */
public interface TVehBaseService extends IService<TVehBasePO> {

    List<TVehBasePO> selectAll();

}
