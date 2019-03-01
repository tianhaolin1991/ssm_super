package cn.itcast.dao;

import cn.itcast.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogDao {
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void savaLog(SysLog sysLog);

    @Select("SELECT * FROM syslog ORDER BY visitTime DESC")
    List<SysLog> findAll();
}
