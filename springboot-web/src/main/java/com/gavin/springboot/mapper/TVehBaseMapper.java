package com.gavin.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gavin.springboot.pojo.po.TVehBasePO;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 车辆基本信息表 Mapper 接口
 * </p>
 *
 * @author Gavin
 * @since 2021-06-03
 */
@Repository
public interface TVehBaseMapper extends BaseMapper<TVehBasePO> {

}
