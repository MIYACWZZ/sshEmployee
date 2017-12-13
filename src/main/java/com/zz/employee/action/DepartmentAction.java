package com.zz.employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zz.employee.domain.Department;
import com.zz.employee.domain.Employee;
import com.zz.employee.domain.PageBean;
import com.zz.employee.service.DepartmentService;

import java.util.List;

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

    //跳转到添加部门页面
    public String saveUI(){
        return "saveUI";
    }

    //添加部门的执行方法
    public String save(){
        departmentService.save(department);
        return "saveSuccess";
    }

    //编辑部门的执行方法：
    public String edit(){
        //使当前模型对象是通过id传递的
        department = departmentService.findById(department.getDid());

        return "editSuccess";
    }

    //修改部门的执行方法：
    public String update(){
        departmentService.update(department);
        return "updateSuccess";
    }

    //删除部门的执行方法：
    public String delete(){
        department = departmentService.findById(department.getDid());
        departmentService.delete(department);
        return "deleteSuccess";
    }

    //显示searchUI
    public String searchUI(){
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list", list);
        return "searchUI";
    }


}
