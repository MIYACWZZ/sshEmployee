package com.zz.employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zz.employee.domain.Department;
import com.zz.employee.domain.Employee;
import com.zz.employee.domain.PageBean;
import com.zz.employee.service.DepartmentService;
import com.zz.employee.service.EmployeeService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 员工管理的Action类
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
    /**
     * 初始化部门列表
     */
    private List<Department> list = null;

    public EmployeeAction() {
        super();
        list = new ArrayList<Department>();
    }

    public List<Department> getList() {
        return list;
    }

    public void setList(List<Department> list) {
        this.list = list;
    }

    //模型驱动使用的对象
    private Employee employee = new Employee();

    public Employee getModel() {
        return employee;
    }

/*    private Department department;

    public void setDepartment(Department department) {
        this.department = department;
    }*/

    /**
     * 登录执行的方法
     *
     * @return
     */
    public String login() {
        System.out.println("login方法执行了.....");
        // 调用业务层的类
        Employee existEmployee = employeeService.login(employee);
        if (existEmployee == null) {
            //登录失败
            addActionError("用户名或密码错误");
            return INPUT;
        } else {
            //登录成功
            ActionContext.getContext().getSession().put("existEmployee", existEmployee);
            if (existEmployee.getEvalue()==1)
                return SUCCESS;
            else
                return "userSuccess";


        }

    }



    //注入员工业务层
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //注入当前页数
    private int currPage = 1;

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    //注入部门业务层
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // 显示所有员工
    public String findAll() {
        PageBean<Employee> pageBean = employeeService.findByPage(currPage);
        //将pageBean存入值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }


    // 跳转到添加员工页面
    public String saveUI() {
        //添加员工页面的部门列表放入之值栈中
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list", list);
        return "saveUI";
    }

    // 添加员工的执行方法
    public String save() {
        employeeService.save(employee);
        this.findAll();

        return "saveSuccess";
    }

    //编辑部门的执行方法：
    public String edit() {
        //使当前模型对象是通过id传递的
        employee = employeeService.findById(employee.getEid());

        list = departmentService.findAll();
        return "editSuccess";
    }

    //更新员工
    public String update() {
        System.out.println("提交更新员工信息");
        employeeService.update(employee);
        return "updateSuccess";
    }

    //删除员工
    public String delete() {
        employeeService.delete(employee.getEid());
        return "deleteSuccess";
    }

    //查询某个部门所有员工
    public String findEmployeeByDid(){
        List<Employee> findListByDid = employeeService.findByDid(employee.getDepartment().getDid());
        if (findListByDid.size()!=0)
        {
            ActionContext.getContext().getValueStack().set("findList", findListByDid);
            return "findSuccess";
        }
        else return "findFail";
    }

    //查询某个员工
    public String findEmployeeByEname(){
        List<Employee> findList = employeeService.findByEname(employee.getEname());
        if (findList.size()!=0)
        {
            ActionContext.getContext().getValueStack().set("findList", findList);
            return "findSuccess";
        }
        else return "findFail";

    }

    //退出登录
    public String exit(){
        ActionContext.getContext().getSession().clear();
        return INPUT;
    }
}
