package com.bonc.kafkasender.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author lianghaiyang
 * @date 2018/08/30
 */
@Setter
@Getter
@ToString
public class Person {
    private String name;
    private Integer age;
    private String idCardNum;
}
