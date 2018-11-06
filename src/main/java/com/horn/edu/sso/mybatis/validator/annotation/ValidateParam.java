package com.horn.edu.sso.mybatis.validator.annotation;

import com.horn.edu.sso.mybatis.validator.Validator;

import java.lang.annotation.*;

/**
 * 自定义请求参数注解
 *
 * Created by misterxu on 2018/11/6.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateParam {
    /**
     * 验证器
     * @return
     */
    Validator[] value() default {};

    /**
     * 参数的描述名称
     * @return
     */
    String name() default "";
}
