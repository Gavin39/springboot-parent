package com.gavin.springboot.service.impl;

import com.gavin.springboot.helper.BeanHelper;
import com.gavin.springboot.pojo.po.TVehBasePO;
import com.gavin.springboot.mapper.TVehBaseMapper;
import com.gavin.springboot.pojo.vo.TVehBaseVO;
import com.gavin.springboot.service.TVehBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 车辆基本信息表 服务实现类
 * </p>
 *
 * @author Gavin
 * @since 2021-06-03
 */
@Service
public class TVehBaseServiceImpl extends ServiceImpl<TVehBaseMapper, TVehBasePO> implements TVehBaseService {

    @Autowired
    private TVehBaseMapper tVehBaseMapper;


    public List<TVehBaseVO> selectAll() {
        List<TVehBasePO> tVehBasePOS = tVehBaseMapper.selectList(null);
        return BeanHelper.copyWithCollection(tVehBasePOS, TVehBaseVO.class);
    }

}
