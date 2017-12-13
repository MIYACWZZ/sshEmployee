package com.zz.employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zz.employee.domain.Employee;
import com.zz.employee.domain.LeaveLine;
import com.zz.employee.domain.PageBean;
import com.zz.employee.service.EmployeeService;
import com.zz.employee.service.LeaveService;

import java.util.List;

public class CenterAction extends ActionSupport implements ModelDriven<LeaveLine> {
    //模型驱动
    private LeaveLine leaveLine = new LeaveLine();

    public LeaveLine getModel() {
        return leaveLine;
    }

    //注入员工业务层
    private EmployeeService employeeService;
    //注入请假条业务层
    private LeaveService leaveService;

    public void setLeaveService(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    //注入当前页数
    private int currPage = 1;

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // 显示所有员工
    public String findAll() {
        PageBean<Employee> pageBean = employeeService.findByPage(currPage);
        //将pageBean存入值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAllTel";
    }

    //显示请假条
    public String showLeave() {
        Employee existEmployee = (Employee) ActionContext.getContext().getSession().get("existEmployee");
        List<LeaveLine> listLeave = leaveService.showLeave(existEmployee.getEid());
        System.out.println("请假条有几条！！！！！！有没有？？！！" + listLeave.size());
        ActionContext.getContext().getSession().put("listLeave", listLeave);


        return "showLeaveSuccess";
    }

    //进入申请请假条页面
    public String saveUI() {
        return "saveUI";
    }

    //申请请假条
    public String leaveSave() {
        Employee existEmployee = (Employee) ActionContext.getContext().getSession().get("existEmployee");
        leaveLine.setLvalue("未处理");

        leaveService.leaveSave(leaveLine, existEmployee.getEid());
        return showLeave();
    }

    //撤回请假条
    public String delLeave() {
        leaveService.delLeave(leaveLine);
        return showLeave();
    }

    //管理员查看全部请假条
    public String findAllLeave() {
        List<LeaveLine> allLeave = leaveService.findAllLeave();
        ActionContext.getContext().getSession().put("allLeave", allLeave);
        return "findAll";
    }

    //管理员编辑
    public String editLeave() {
        leaveLine = leaveService.findByLid(leaveLine.getLid());
        return "edit";
    }

    //管理员处理假条
    public String updateLeave() {
        leaveService.updateLeave(leaveLine);
        return "updateSuccess";
    }
}
