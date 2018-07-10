package com.qc.itaojin.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * Created by fuqinqin on 2018/7/2.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
@Scope("prototype")
public @interface PrototypeService {
    String value() default "";
}
