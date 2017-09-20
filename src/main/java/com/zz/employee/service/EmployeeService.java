package com.zz.employee.service;

import com.zz.employee.domain.Employee;

/**
 * 员工管理业务层接口
 */
public interface EmployeeService {
    Employee login(Employee employee);
}
