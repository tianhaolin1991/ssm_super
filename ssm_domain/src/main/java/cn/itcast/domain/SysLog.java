package cn.itcast.domain;

import cn.itcast.utils.ConverterUtils;
import com.sun.tools.javac.util.Convert;

import java.util.Date;

public class SysLog {
    private String id;
    private String username;
    private String method;
    private String url;
    private Date visitTime;
    private String visitTimeStr;
    private long executionTime;
    private String ip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitTimeStr() {
        visitTimeStr = ConverterUtils.dateToStrSS(visitTime);
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executeTime) {
        this.executionTime = executeTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
