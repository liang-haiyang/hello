package com.liang.package_info;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lianghaiyang
 * @date 2018/09/20
 *
 * 定义只能标注在package上的注解
 */
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PkgAnnotation {
}
