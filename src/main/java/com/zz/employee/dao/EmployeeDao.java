package com.zz.employee.dao;

import com.zz.employee.domain.Employee;

public interface EmployeeDao {
    Employee findByUsernameAndPassword(Employee employee);
}
