# hello 本项目用于各种测试demo
## 一. 项目工具
###1. assembly使用
    (1). 项目中引入assembly.xml,并配置输入和输出文件夹
    (2). maven pom.xml中配置插件
## 二. java大数据
###1. kafka
    使用到技术点: kafka生产者, spring定时器
    (1). 从配置文件中读取需要发送消息的基本信息
    (2). 产生一个可配置概率的随机数, 用于向kafka发送消息\
    (3). 使用spring @Scheduled 定时向kafka发送消息
## 三. java8 lambda
###1. java8 stream
    (1). java8利用流将一个对象的集合转换为另一个对象的集合;
         使用到的函数
         ```Function<SourceObject,TargetObject> functionName = (sourceObject) -> {
                    // do something
                    return targetObject;
            }```
## 四. others
###1. Google Guava(很多语法已经集成到java8中)
    -- 首先引入guava maven依赖(见pom.xml)
    (1). 集合工具类
    (2). 字符与字符串工具类
    (3). guava缓存