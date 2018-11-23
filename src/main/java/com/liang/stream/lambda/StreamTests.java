package com.liang.stream.lambda;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lianghaiyang
 * @date 2018/09/19
 */
public class StreamTests {
    @Setter
    @Getter
    @ToString
    private class Student {
        private Integer id;
        private Integer classId;
        private String name;

        private Student(Integer id, Integer classId, String name) {
            this.id = id;
            this.classId = classId;
            this.name = name;
        }
    }

    public void testGroupBy() {
        Student p1 = new Student(1, 1, "张三1");
        Student p2 = new Student(2, 1, "张三2");
        Student p3 = new Student(3, 2, "张三3");
        Student p4 = new Student(4, 2, "张三4");
        Student p5 = new Student(5, 3, "张三5");
        Student p6 = new Student(6, 3, "张三6");
        List<Student> studentList = Arrays.asList(p1, p2, p3, p4, p5, p6);
        Map<Integer, List<Student>> classStudentsMap = studentList.stream().collect(Collectors.groupingBy(Student::getClassId));
    }
}
