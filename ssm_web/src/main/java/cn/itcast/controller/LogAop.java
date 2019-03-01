package cn.itcast.controller;

import cn.itcast.domain.SysLog;
import cn.itcast.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
@Scope("request")
public class LogAop {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogService sysLogService;

    private Date visitTime;
    private Method method;
    private Class clazz;

    @Pointcut("execution(* cn.itcast.controller.*.*(..))")
    private void pc() {
    }

    @Before("pc()")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();
        clazz = jp.getSignature().getDeclaringType();
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        if (clazz != null && methodName != null && clazz != LogAop.class) {
            if (args != null && args.length != 0) {

                Class[] argsClass = new Class[args.length];

                for (int i = 0; i < argsClass.length; i++) {
                    argsClass[i] = args[i].getClass();
                }
                method = clazz.getMethod(methodName, argsClass);
            } else {
                method = clazz.getMethod(methodName);
            }
        }
    }

    @After("pc()")
    public void doAfter(JoinPoint jp){
        //1.获取操作时间
        long executeTime = new Date().getTime() - visitTime.getTime();
        //2.获取url
        String url = "";
        String executeMethod = "";
        if(clazz !=null && method!=null && clazz!=LogAop.class){
            RequestMapping classMapping = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
            if(classMapping != null){
                String classUrl = classMapping.value()[0];
                RequestMapping methodMapping = (RequestMapping)method.getAnnotation(RequestMapping.class);
                if(methodMapping != null){
                    String methodUrl = methodMapping.value()[0];
                    url = classUrl + methodUrl;
                }
            }
            //3.获取方法名称
             executeMethod = "[类名]:" + clazz.getName() + "[方法名]:" + method.getName();
        }
        //4.获取ip
        String ip = request.getRemoteAddr();
        //5.获取操作用户

        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();

        //6.封装
        SysLog log = new SysLog();
        log.setVisitTime(visitTime);
        log.setUsername(username);
        log.setMethod(executeMethod);
        log.setUrl(url);
        log.setExecutionTime(executeTime);
        log.setIp(ip);

        //7.保存
        sysLogService.saveLog(log);
    }

}