package com.tliasweb.mapper;

import com.tliasweb.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门数据的
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();
}
