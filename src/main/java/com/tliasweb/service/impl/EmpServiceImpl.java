package com.tliasweb.service.impl;

import com.tliasweb.mapper.EmpMapper;
import com.tliasweb.pojo.Emp;
import com.tliasweb.pojo.PageBean;
import com.tliasweb.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        /*
          获取总记录数
         */
        Long count = empMapper.count();

        /*
          获取分页查询结果列表
         */
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);

        /*
          封装PageBean对象
         */
        return new PageBean(count, empList);
    }
}
