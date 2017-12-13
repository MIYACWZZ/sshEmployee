package com.zz.employee.dao;

import com.zz.employee.domain.Department;

import java.util.List;

/**
 * 部门管理dao
 */
public interface DepartmentDao {
    int findCount();

    List<Department> findByPage(int begin, int pageSize);

    void save(Department department);

    Department findById(int did);

    void update(Department department);

    void delete(Department department);

    List<Department> findAll();
}
