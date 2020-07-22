package com.example.aop.aop.aspect;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.aop.LoginActivity;
import com.example.aop.aop.UserInfo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 校验用户是否登录，如果未登录，则跳到登录界面
 */
@Aspect
public class CheckLoginAspect {
    private static final String POINTCUT_METHOD =
            "execution(@com.example.aop.aop.annotation.CheckLogin * *(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithCheckLogin(){}

    @Around("methodAnnotatedWithCheckLogin()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        Context context = null;
        if (UserInfo.username==null) {

            for (Object arg : joinPoint.getArgs()) {
                if (arg instanceof View) {
                  context =  ((View) arg).getContext();
                  break;
                }
            }
            //跳转到登录
            if (context!=null) {
                jumpToLogin(context);
            }
            return null;
        }

        return joinPoint.proceed();
    }
    public  void jumpToLogin(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}
