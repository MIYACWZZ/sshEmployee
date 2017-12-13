package com.zz.employee.service.impl;

import com.zz.employee.dao.LeaveDao;
import com.zz.employee.domain.LeaveLine;
import com.zz.employee.service.LeaveService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class LeaveServiceImpl implements LeaveService {
    private LeaveDao leaveDao;

    public void setLeaveDao(LeaveDao leaveDao) {
        this.leaveDao = leaveDao;
    }

    /**
     * 查看该员工所有的请假条
     * @param eid
     * @return
     */
    public List<LeaveLine> showLeave(int eid) {
        return leaveDao.showLeave(eid);
    }

    public void leaveSave(LeaveLine leaveLine,int eid) {
        leaveDao.leaveSave(leaveLine,eid);
    }

    public void delLeave(LeaveLine leaveLine) {
        leaveDao.delLeave(leaveLine);
    }

    public List<LeaveLine> findAllLeave() {
        return leaveDao.findAllLeave();
    }

    public LeaveLine findByLid(int lid) {
        return leaveDao.findByLid(lid);
    }

    public void updateLeave(LeaveLine leaveLine) {
        leaveDao.updateLeave(leaveLine);
    }
}
