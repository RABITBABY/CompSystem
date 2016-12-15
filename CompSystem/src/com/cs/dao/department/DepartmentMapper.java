package com.cs.dao.department;

import com.cs.pojo.Department;

public interface DepartmentMapper {
    int deleteByDepartmentId(Integer departmentid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByDepartId(Integer departmentid);

    int updateByDepartmentIdSelective(Department record);

    int updateByDepartmentId(Department record);
}
