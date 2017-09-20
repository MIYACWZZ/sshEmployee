package com.zz.employee.domain;

import java.util.Date;

/**
 * 员工的实体
 */
public class Employee {
   //员工id
   private int eid;
   //姓名
   private String ename;
   //性别
   private String sex;
   //生日
   private Date birthday;
   //入职日期
   private Date joinday;
   //员工编号
   private String eno;
   //所属部门
   private Department department;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getJoinday() {
        return joinday;
    }

    public void setJoinday(Date joinday) {
        this.joinday = joinday;
    }

    public String getEno() {
        return eno;
    }

    public void setEno(String eno) {
        this.eno = eno;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 用于登录
     */
   //用户名
   private String username;
   //密码
   private String password;
}
