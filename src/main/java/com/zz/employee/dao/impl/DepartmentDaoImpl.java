package com.zz.employee.dao.impl;

import com.zz.employee.dao.DepartmentDao;
import com.zz.employee.domain.Department;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

import static org.springframework.orm.hibernate5.SessionFactoryUtils.closeSession;

/**
 * 部门管理Dao的实现类
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
    private Session session;
    /**
     * 查询部门总个数
     * @return
     */
    public int findCount() {
        String hql="select count(*) from Department";
        List<?> list = getHibernateTemplate().find(hql);
        Object o = list.get(0);
        if (list.size()>0)
            return ((Long) list.get(0)).intValue();
        return 0;
    }

    /**
     * 分页查询部门
     * @param begin
     * @param pageSize
     * @return
     */
    public List<Department> findByPage(int begin, int pageSize) {
        String hql = "from Department";
        session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        //按参数位置绑定查询条件
        query.setFirstResult(begin);
        query.setMaxResults(pageSize);
        List<Department> list = query.list();
        session.close();
        return list;
    }

    //DAO中保存部门的方法
    public void save(Department department) {
        getHibernateTemplate().save(department);
    }

    //DAO中根据部门id查询部门的方法
    public Department findById(int did) {
        return this.getHibernateTemplate().get(Department.class,did);
    }

    //DAO中修改部门的方法
    public void update(Department department) {
        this.getHibernateTemplate().update(department);
    }

    //DAO中删除部门的方法
    public void delete(Department department) {
        this.getHibernateTemplate().delete(department);
    }

    /**
     * DAO层查找所有的部门
     *
     * @return
     */
    public List<Department> findAll() {
        String hql = "from Department";
        session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Department> list = query.list();
        session.close();
        return list;
    }
}
