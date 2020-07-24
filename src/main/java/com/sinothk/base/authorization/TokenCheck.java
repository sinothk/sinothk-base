package com.sinothk.base.authorization;


import java.lang.annotation.*;

/**
 * Token验证注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenCheck {
}
