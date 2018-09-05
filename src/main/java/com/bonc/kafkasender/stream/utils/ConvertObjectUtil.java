package com.bonc.kafkasender.stream.utils;

import com.bonc.kafkasender.kafka.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author lianghaiyang
 * @date 2018/08/30
 */
public class ConvertObjectUtil {
    /**
     *  将对象属性转换成列表
     */
    public static Function<Person, List<Object>> personToList = (person) -> {
        List<List<Object>> rows = new ArrayList<>();
        List<Object> cells = new ArrayList<>();
        cells.add(person.getName());
        cells.add(person.getAge());
        cells.add(person.getIdCardNum());
        rows.add(cells);
        return cells;
    };
}
