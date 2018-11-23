package com.liang.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author lianghaiyang 2018/9/18 11:49
 * 注解@BenchmarkMode : 测试方法平均执行时间
 * 注解@OutputTimeUnit : 输出结果的时间粒度为微秒
 * 注解@State : 每个测试线程一个实例
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class MyBenchMarkFirst {
    private static Logger log = LoggerFactory.getLogger(MyBenchMarkFirst.class);

    @Benchmark
    public String stringConcat() {
//        Arrays.asList("")
        return null;
    }

    @Benchmark
    public StringBuilder stringBuilderConcat() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0");
        stringBuilder.append("1");
        stringBuilder.append("2");
        stringBuilder.append("3");
        stringBuilder.append("4");
        stringBuilder.append("5");
        stringBuilder.append("6");
        stringBuilder.append("7");
        stringBuilder.append("8");
        stringBuilder.append("9");
        return stringBuilder;
    }


    private double x = Math.PI;
    private final double wrongX = Math.PI;
    @Benchmark
    public double baseline() {
        // simply return the value, this is a baseline
        return Math.PI;
    }
    @Benchmark
    public double measureWrong_1() {
        // This is wrong: the source is predictable, and computation is foldable.
        return Math.log(Math.PI);
    }
    @Benchmark
    public double measureWrong_2() {
        // This is wrong: the source is predictable, and computation is foldable.
        return Math.log(wrongX);
    }

    @Benchmark
    public double measureRight_1() {
        return Math.log(Math.PI) +Math.log(Math.PI);
    }
    @Benchmark
    public void measureRight_2(Blackhole bh) {
        bh.consume(Math.PI);
        bh.consume(Math.PI);
    }

    @Benchmark
    public double measureRight() {
        // This is correct: the source is not predictable.
        return Math.log(x);
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MyBenchMarkFirst.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();
        new Runner(opt).run();

    }

    /**
     *  编译器会进行迭代展开
     */
    public void test123(){
        int[] a = new int[100];
        int b = 1;
        int c = 1;
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * b + c;
        }
//        ---------------------------------
//                              ↓
//        ---------------------------------
        for (int i = 0; i < 100; i++) {
            a[i] = a[i] * b + c;
            a[i+1] = a[i+1] * b + c;
            a[i+2] = a[i+2] * b + c;
        }
    }




//    public static void main(String[] args) throws RunnerException {
//        // 使用一个单独进程执行测试，执行5遍warmup，然后执行5遍测试
//        Options opt = new OptionsBuilder().include(MyBenchMarkFirst.class.getSimpleName()).forks(1).warmupIterations(5)
//                .measurementIterations(5).build();
//        new Runner(opt).run();
//    }
}