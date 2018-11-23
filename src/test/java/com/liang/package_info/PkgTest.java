package com.liang.package_info;

import org.junit.Test;

import java.lang.annotation.Annotation;

/**
 * @author lianghaiyang
 * @date 2018/09/20
 */
public class PkgTest {

    @Test
    public void test1(){
        String packageName = "com.liang.package_info";
        Package pkg = Package.getPackage(packageName);
        Annotation[] annotations = pkg.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof PkgAnnotation){
                // 输出结果@com.liang.package_info.PkgAnnotation()
                System.out.println(annotation.toString());
            }
        }
    }
}
