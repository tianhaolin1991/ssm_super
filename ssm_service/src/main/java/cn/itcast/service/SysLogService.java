package cn.itcast.service;

import cn.itcast.domain.SysLog;

import java.util.List;

public interface SysLogService {

    void saveLog(SysLog sysLog);

    List<SysLog> findAll();
}
