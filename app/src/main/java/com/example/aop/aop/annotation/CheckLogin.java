package com.example.aop.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 目前支持如下格式（参数不为空，且是View系列）
 * @CheckLogin
 *     public void seeMovie(View view) {
 *         Toast.makeText(this, "已登录，看电影", Toast.LENGTH_SHORT).show();
 *     }
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
public  @interface CheckLogin {
}
