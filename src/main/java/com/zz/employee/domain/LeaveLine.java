package com.zz.employee.domain;
public class LeaveLine {
    private int lid;
    private String ldesc;
/*    private Employee employee;*/
    private String lvalue;

    private int leid;

    public int getLeid() {
        return leid;
    }

    public void setLeid(int leid) {
        this.leid = leid;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLdesc() {
        return ldesc;
    }

    public void setLdesc(String ldesc) {
        this.ldesc = ldesc;
    }

/*    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }*/

    public String getLvalue() {
        return lvalue;
    }

    public void setLvalue(String lvalue) {
        this.lvalue = lvalue;
    }
}
