package com.zz.employee.service;

import com.zz.employee.dao.DepartmentDao;
import com.zz.employee.domain.Department;
import com.zz.employee.domain.PageBean;

/**
 * 部门服务类
 */
public interface DepartmentService {

    PageBean<Department> findByPage(int currPage);

}
