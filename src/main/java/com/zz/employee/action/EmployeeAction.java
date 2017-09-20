package com.zz.employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zz.employee.domain.Employee;
import com.zz.employee.service.EmployeeService;

/**
 * 员工管理的Action类
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
    /**
     * 登录执行的方法
     *
     * @return
     */
    public String login() {
        System.out.println("login方法执行了.....");
        // 调用业务层的类
        Employee existEmployee = employeeService.login(employee);
        if (existEmployee == null){
            //登录失败
            addActionError("用户名或密码错误");
            return INPUT;
        }else {
            //登录成功
            ActionContext.getContext().getSession().put("existEmployee",existEmployee);
            return SUCCESS;
        }

    }

    //模型驱动使用的对象
    private Employee employee = new Employee();

    public Employee getModel() {
        return employee;
    }

    //注入业务层
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
