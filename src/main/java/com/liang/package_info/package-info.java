/*
 *
 */

/**
 * 提供该包的整体注释说明
 * 测试package_info.java的作用
 */
@PkgAnnotation
package com.liang.package_info;

class PkgClass {
    void test() {
        System.out.println("test");
    }
}

interface PkgInterface {
    void test();
}

enum PkgEnum {
    /**
     * 测试
     */
    TEST(1, "sss");
    int code;
    String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    PkgEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

}

/**
 * 包常量，只运行包内访问，适用于分“包”开发
 */
class PkgConst {
    static final String PACAKGE_CONST = "package-info";
}