package com.zz.employee.service;

import com.zz.employee.domain.Employee;
import com.zz.employee.domain.PageBean;

import java.util.List;

/**
 * 员工管理业务层接口
 */
public interface EmployeeService {
    Employee login(Employee employee);

    PageBean<Employee> findByPage(int currPage);

    void save(Employee employee);

    Employee findById(int eid);

    void update(Employee employee);

    void delete(int eid);

    List<Employee> findByDid(int dno);

    List<Employee> findByEname(String ename);
}
