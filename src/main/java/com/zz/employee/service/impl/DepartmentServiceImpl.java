package com.zz.employee.service.impl;

import com.zz.employee.dao.DepartmentDao;
import com.zz.employee.domain.Department;
import com.zz.employee.domain.PageBean;
import com.zz.employee.service.DepartmentService;

import java.util.List;

/**
 * 部门业务实现类
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    //  分页查询部分的方法
    public PageBean<Department> findByPage(int currPage) {
        PageBean<Department> pageBean = new PageBean<Department>();
        //封装当前页数：
        pageBean.setCurrPage(currPage);
        //封装每页显示记录数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        //封装总记录数：
        int totalCount = departmentDao.findCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数：
        double num = Math.ceil((double) totalCount / pageSize);
        pageBean.setTotalPage((int) num);
        //封装每页显示的数据
        int begin = (currPage - 1) * pageSize;
        List<Department> list = departmentDao.findByPage(begin, pageSize);
        if (list.size()<=1)
            System.out.println("查不出数据！！！！！！！！！！！");
        pageBean.setList(list);

        return pageBean;
    }
}
