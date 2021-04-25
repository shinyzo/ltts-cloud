package com.lming.ltts.common.log.aspect;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.lming.ltts.common.core.enums.ResultEnum;
import com.lming.ltts.common.log.annotation.LttsLog;
import com.lming.ltts.common.log.entity.LogEntity;
import com.lming.ltts.common.log.service.AsyncLogService;
import com.lming.ltts.common.log.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;


import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.ServiceLoader;


/**
 * Author: liangming.zhang
 * Date : 2021/4/22 - 10:04
 * Description:
 */
@Aspect
@Slf4j
@ConditionalOnProperty(name = "ltts.log.enabled", havingValue ="true",matchIfMissing = false)
public class LttsControllerLogAspect {

    @Autowired
    private AsyncLogService asyncLogService;

    //切点
    @Pointcut("@annotation(com.lming.ltts.common.log.annotation.LttsLog)")
    public void logPointcut() {
    }


    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointcut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult)
    {
        handleLog(joinPoint, null, jsonResult);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e 异常
     */
    @AfterThrowing(value = "logPointcut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e)
    {
        handleLog(joinPoint, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult)
    {
        try {
            // 获得注解
            LttsLog controllerLog = getAnnotationLog(joinPoint);
            if (controllerLog == null) {
                return;
            }

            LogEntity logEntity = LogUtil.buildLogEntity();
            // 返回参数
            logEntity.setResponseData(JSONUtil.toJsonStr(jsonResult));
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            logEntity.setClassName(className);
            logEntity.setMethodName(methodName);

            if (e != null) {
                logEntity.setResponseCode(ResultEnum.ERROR.getCode());
                logEntity.setErrorMsg(StrUtil.subSufByLength(e.getMessage(), 2000));
            }

            // 处理设置注解上的参数
            getControllerMethodDescription(joinPoint, controllerLog, logEntity);
            // 保存数据库
            asyncLogService.saveLog(logEntity);
        } catch (Exception exp) {
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     *
     * @param joinPoint
     * @param log
     * @param logEntity
     * @throws Exception
     */
    public void getControllerMethodDescription(JoinPoint joinPoint, LttsLog log, LogEntity logEntity) throws Exception
    {

        logEntity.setLogName(StrUtil.isEmpty(log.title()) ? log.name() : log.title());
        logEntity.setModule(log.module());
    }



    /**
     * 是否存在注解，如果存在就获取
     */
    private LttsLog getAnnotationLog(JoinPoint joinPoint) throws Exception
    {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null)
        {
            return method.getAnnotation(LttsLog.class);
        }
        return null;
    }

}
