package com.zz.employee.dao;

import com.zz.employee.domain.LeaveLine;

import java.util.List;

public interface LeaveDao {
    List<LeaveLine> showLeave(int eid);

    void leaveSave(LeaveLine leaveLine,int eid);

    void delLeave(LeaveLine leaveLine);

    List<LeaveLine> findAllLeave();

    LeaveLine findByLid(int lid);

    void updateLeave(LeaveLine leaveLine);
}
