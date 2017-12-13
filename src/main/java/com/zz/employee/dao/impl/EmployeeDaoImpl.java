package com.zz.employee.dao.impl;

import com.zz.employee.dao.EmployeeDao;
import com.zz.employee.domain.Employee;
import com.zz.employee.service.DepartmentService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * dao的实现类
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
    //spring注入业务
    private DepartmentService departmentService;


    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * 用户登录
     * @param employee
     * @return
     */
    public Employee findByUsernameAndPassword(Employee employee) {
        String hql = "from Employee where username = ? and password = ?";
        List<?> list = getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
        if (list.size() > 0)
            return (Employee) list.get(0);
        return null;
    }

    /**
     * 查询员工总人数
     * @return
     */
    public int findCount() {
        String hql = "select count(*) from Employee";
        List<?> list = getHibernateTemplate().find(hql);
        Object o = list.get(0);
        if (list.size()>0)
            return ((Long) list.get(0)).intValue();
        return 0;
    }

    /**
     * 分页查询
     * @param begin
     * @param pageSize
     * @return
     */
    public List<Employee> findByPage(int begin, int pageSize) {
        Session session;
        String hql = "from Employee";
        session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
//        //按参数位置绑定查询条件
//        System.out.println(begin);
//        System.out.println(pageSize);
        query.setFirstResult(begin);
        query.setMaxResults(pageSize);
        List<Employee> list = query.list();


        session.close();
        return list;
    }

    /**
     * DAO层保存员工
     * @param employee
     */
    public void save(Employee employee) {

        getHibernateTemplate().save(employee);

    }

    /**
     * Dao层根据id查找出员工
     * @param eid
     * @return
     */
    public Employee findById(int eid) {
        return this.getHibernateTemplate().get(Employee.class,eid);
    }

    /**
     * Dao层更新员工
     * @param employee
     */
    public void update(Employee employee) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update(employee);
        transaction.commit();
        session.close();
    }

    /**
     * Dao层删除员工
     * @param eid
     */
    public void delete(int eid) {
        System.out.println("执行删除语句");
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        String hql = "  delete from Employee as e where e.eid = ?";

        Query query = session.createQuery(hql);

        query.setParameter(0, eid);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    /**
     * 根据部门号查询员工
     * @param dno
     * @return
     */
    public List<Employee> findByDId(int dno) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        String hql = "from Employee as e where e.department.did = " +dno;

        Query query = session.createQuery(hql);
        List<Employee> list = query.list();
        transaction.commit();
        session.close();

        return list;
    }

    /**
     * 模糊查询员工
     * @param ename
     * @return
     */
    public List<Employee> findByEname(String ename) {
        String hql = "from Employee as e where e.ename like '%"+ename+"%'";
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query query = session.createQuery(hql);
        List<Employee> list = query.list();
        transaction.commit();
        session.close();

        return list;
    }
}
