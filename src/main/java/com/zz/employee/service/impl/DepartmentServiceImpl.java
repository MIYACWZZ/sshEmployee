package com.zz.employee.service.impl;

import com.zz.employee.dao.DepartmentDao;
import com.zz.employee.domain.Department;
import com.zz.employee.domain.PageBean;
import com.zz.employee.service.DepartmentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门业务实现类
 */
/**
 * 开启事务
 */
@Transactional
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
        if (list.size() <= 1)
            System.out.println("查不出数据！！！！！！！！！！！");
        pageBean.setList(list);

        return pageBean;
    }

    //业务层保存新添加部门
    public void save(Department department) {
        departmentDao.save(department);
    }

    //业务层根据部门ID查询相应部门的方法
    public Department findById(int did) {

        return departmentDao.findById(did);
    }

    //业务层修改部门
    public void update(Department department) {
        departmentDao.update(department);

    }

    //业务层删除部门
    public void delete(Department department) {
        departmentDao.delete(department);
    }

    /**
     * 业务层查找所有的部门
     * @return
     */
    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
