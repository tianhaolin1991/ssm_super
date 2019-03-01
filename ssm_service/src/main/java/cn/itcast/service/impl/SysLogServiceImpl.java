package cn.itcast.service.impl;

import cn.itcast.dao.SysLogDao;
import cn.itcast.domain.SysLog;
import cn.itcast.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    SysLogDao sysLogDao;
    @Override
    public void saveLog(SysLog sysLog) {
        sysLogDao.savaLog(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
         return sysLogDao.findAll();
    }
}
