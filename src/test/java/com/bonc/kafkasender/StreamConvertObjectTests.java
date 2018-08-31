package com.bonc.kafkasender;

import com.bonc.kafkasender.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.bonc.kafkasender.utils.ConvertObjectUtil.personToList;

/**
 * @author lianghaiyang
 * @date 2018/08/30
 */
public class StreamConvertObjectTests {
    @Test
    public void test123(){
        Person person0 = new Person();
        person0.setName("中华小子");
        person0.setAge(17);
        person0.setIdCardNum("rrrrrrrrrrrrrrrrrrrrrrr");
        Person person1 = new Person();
        person1.setName("中华小子");
        person1.setAge(18);
        person1.setIdCardNum("12312312312312313");
        Person person2 = new Person();
        person2.setName("中华小子");
        person2.setAge(19);
        person2.setIdCardNum("xxxxxxxxxxx");
        List<Person> personList = new ArrayList<>();
        personList.add(person0);
        personList.add(person1);
        personList.add(person2);

        List<List<Object>> collect = personList.stream().map(personToList).collect(Collectors.toList());
        System.out.println(collect);
    }
}
