package com.zz.employee.service;

import com.zz.employee.dao.DepartmentDao;
import com.zz.employee.domain.Department;
import com.zz.employee.domain.PageBean;

import java.util.List;

/**
 * 部门服务类
 */
public interface DepartmentService {

    PageBean<Department> findByPage(int currPage);

    void save(Department department);

    Department findById(int did);

    void update(Department department);

    void delete(Department department);

    List<Department> findAll();
}
