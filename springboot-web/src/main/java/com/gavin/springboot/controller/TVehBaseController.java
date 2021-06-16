package com.gavin.springboot.controller;


import com.gavin.springboot.pojo.vo.TVehBaseVO;
import com.gavin.springboot.service.TVehBaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 车辆基本信息表 前端控制器
 * </p>
 *
 * @author Gavin
 * @since 2021-06-03
 */
@RestController
@RequestMapping("/tVehBasePO")
public class TVehBaseController {


    @Autowired
    private TVehBaseService tVehBaseService;

    @ApiOperation("查询所有列表")
    @GetMapping("/selectAll")
    public List<TVehBaseVO> selectAll() {
        return tVehBaseService.selectAll();
    }

}
