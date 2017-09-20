package com.zz.employee.service.impl;

import com.zz.employee.dao.EmployeeDao;
import com.zz.employee.domain.Employee;
import com.zz.employee.service.EmployeeService;

/**
 * 员工管理的业务层实现类
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * 业务层登录方法
     * @param employee
     * @return
     */
    public Employee login(Employee employee) {
        Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
        return existEmployee;
    }
}
