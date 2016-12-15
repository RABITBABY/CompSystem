package com.cs.dao.department;

import com.cs.pojo.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer departmentid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByDepartId(Integer departmentid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}