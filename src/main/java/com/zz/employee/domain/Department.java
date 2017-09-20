package com.zz.employee.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门的实体类
 *
 */
public class Department {
    //部门id
    private int did;
    //部门名称
    private String dname;
    //部门描述
    private String ddesc;
    //员工集合
    private Set<Employee> employees = new HashSet<Employee>();

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDdesc() {
        return ddesc;
    }

    public void setDdesc(String ddesc) {
        this.ddesc = ddesc;
    }
}
