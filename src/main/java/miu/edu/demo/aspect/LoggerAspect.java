package miu.edu.demo.aspect;

import miu.edu.demo.domain.Loger;
import miu.edu.demo.domain.Userr;
import miu.edu.demo.service.LogerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggerAspect {
    @Autowired
    LogerService logerService;
    @Pointcut("@annotation(miu.edu.demo.aspect.annotation.ExecutionTime)")
    public void logOperation(){

    }
    @Around("logOperation()")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {// C P
        long start = System.currentTimeMillis();
        long executionTime = System.currentTimeMillis() - start;
        Loger loger = new Loger();
        loger.setOperation(joinPoint.getSignature().getName());
        loger.setDatetime(new Date());
        loger.setDuration(executionTime);
        loger.setPrinciple(Userr.getLoggedInUser());
        logerService.save(loger);
        return joinPoint.proceed();


    }





}
