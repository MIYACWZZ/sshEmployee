package com.zz.employee.dao;

import com.zz.employee.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee findByUsernameAndPassword(Employee employee);

    int findCount();

    List<Employee> findByPage(int begin, int pageSize);

    void save(Employee employee);

    Employee findById(int eid);

    void update(Employee employee);

    void delete(int eid);

    List<Employee> findByDId(int dno);

    List<Employee> findByEname(String ename);
}
