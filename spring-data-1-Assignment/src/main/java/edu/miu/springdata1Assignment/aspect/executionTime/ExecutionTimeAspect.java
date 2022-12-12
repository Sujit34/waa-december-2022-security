package edu.miu.springdata1Assignment.aspect.executionTime;


import edu.miu.springdata1Assignment.entity.ActivityLog;
import edu.miu.springdata1Assignment.repository.ActivityLogRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final HttpServletRequest httpServletRequest;
    private final ActivityLogRepo activityLogRepo;

    @Pointcut("@annotation(edu.miu.springdata1Assignment.aspect.executionTime.ExecutionTime)")
    public void executionTimeAnnotation(){

    }



    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(LocalDate.now());
        activityLog.setDuration(finish - start);
        activityLog.setOperation(proceedingJoinPoint.getSignature().toShortString());
        ActivityLogRepo.save(activityLog);
        return result;
    }
