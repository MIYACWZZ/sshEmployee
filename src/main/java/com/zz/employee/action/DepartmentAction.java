package com.zz.employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zz.employee.domain.Department;
import com.zz.employee.domain.PageBean;
import com.zz.employee.service.DepartmentService;

/**
 * 部门管理Action类
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
    // 模型驱动使用的对象
    private Department department = new Department();
    // 默认页：1
    private int currPage = 1;

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    //注入部门管理Service
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public Department getModel() {
        return department;
    }


    //提供一个查询的方法：
    public String findAll(){
        PageBean<Department> pageBean = departmentService.findByPage(currPage);
        //将pageBean存入值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }
}
