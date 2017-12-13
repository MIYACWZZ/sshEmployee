package com.zz.employee.dao.impl;

import com.zz.employee.dao.LeaveDao;
import com.zz.employee.domain.Department;
import com.zz.employee.domain.LeaveLine;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;
import java.util.Queue;

public class LeaveDaoImpl extends HibernateDaoSupport implements LeaveDao {
    /**
     * 显示所有请假条
     *
     * @param eid
     * @return
     */
    public List<LeaveLine> showLeave(int eid) {
        Session session;
        String hql = "from LeaveLine where leid = ?";
        session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, eid);
        List<LeaveLine> list = query.list();
        session.close();
        return list;

    }

    /**
     * 保存请假条
     *
     * @param leaveLine
     * @param eid
     */
    public void leaveSave(LeaveLine leaveLine, int eid) {
        leaveLine.setLeid(eid);
        System.out.println("状态是什么？？？？？！！！！"+leaveLine.getLvalue());
        getHibernateTemplate().save(leaveLine);
    }

    /**
     * 撤回请假条
     *
     * @param leaveLine
     */
    public void delLeave(LeaveLine leaveLine) {
        Session session = getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        try {
            String hql = "delete from LeaveLine where lid = ?";
            session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(0, leaveLine.getLid());
            query.executeUpdate();
            tx.commit();

        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 查找所有请假条
     * @return
     */
    public List<LeaveLine> findAllLeave() {
        String hql = "from LeaveLine";
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<LeaveLine> list = query.list();
        session.close();
        return list;
    }

    /**
     * 根据id查找请假条
     * @param lid
     * @return
     */
    public LeaveLine findByLid(int lid) {
        String hql = "from LeaveLine where lid = ?";
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, lid);
        List<LeaveLine> list = query.list();
        session.close();
        return list.get(0);
    }

    /**
     * 更新请假条
     * @param leaveLine
     */
    public void updateLeave(LeaveLine leaveLine) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update(leaveLine);
        transaction.commit();
        session.close();
    }
}
