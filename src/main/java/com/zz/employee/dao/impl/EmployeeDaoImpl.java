package com.zz.employee.dao.impl;

import com.zz.employee.dao.EmployeeDao;
import com.zz.employee.domain.Employee;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * dao的实现类
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
    public Employee findByUsernameAndPassword(Employee employee) {
        String hql = "from Employee where username = ? and password = ?";
        List<?> list = getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
        if (list.size() > 0)
            return (Employee) list.get(0);
        return null;
    }
}
