package com.gavin.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gavin.springboot.pojo.po.TVehBasePO;
import com.gavin.springboot.pojo.vo.TVehBaseVO;

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

    List<TVehBaseVO> selectAll();

}
