package com.tliasweb.service.impl;

import com.tliasweb.mapper.DeptMapper;
import com.tliasweb.mapper.EmpMapper;
import com.tliasweb.pojo.Dept;
import com.tliasweb.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        //根据ID删除部门数据
        deptMapper.deleteById(id);

        //根据部门ID删除该部门下的员工
        empMapper.deleteByDeptId(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);

    }


}
