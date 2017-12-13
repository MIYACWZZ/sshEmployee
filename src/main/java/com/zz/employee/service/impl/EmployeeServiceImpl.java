package com.zz.employee.service.impl;

import com.zz.employee.dao.EmployeeDao;
import com.zz.employee.domain.Department;
import com.zz.employee.domain.Employee;
import com.zz.employee.domain.PageBean;
import com.zz.employee.service.EmployeeService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 员工管理的业务层实现类
 */
/**
 * 开启事务
 */
@Transactional
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

    /**
     * 业务层分页方法
     * @param currPage
     * @return
     */
    public PageBean<Employee> findByPage(int currPage) {
        PageBean<Employee> pageBean = new PageBean<Employee>();
        //封装当前页数：
        pageBean.setCurrPage(currPage);
        //封装每页显示记录数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        //封装总记录数：
        int totalCount = employeeDao.findCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数：
        Double num = Math.ceil((double) totalCount / pageSize);
        pageBean.setTotalPage(num.intValue());
        //封装每页显示的数据
        int begin = (currPage - 1) * pageSize;
        List<Employee> list = employeeDao.findByPage(begin, pageSize);
        if (list.size()<=1)
            System.out.println("查不出数据！！！！！！！！！！！");
        pageBean.setList(list);

        return pageBean;
    }

    /**
     * 业务层保存员工方法
     * @param employee
     */
    public void save(Employee employee) {
        employeeDao.save(employee);

    }

    public Employee findById(int eid) {
        return employeeDao.findById(eid);
    }

    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    public void delete(int eid) {
        employeeDao.delete(eid);

    }


    public List<Employee> findByDid(int dno) {
        return employeeDao.findByDId(dno);
    }

    public List<Employee> findByEname(String ename) {
        return employeeDao.findByEname(ename);
    }
}
