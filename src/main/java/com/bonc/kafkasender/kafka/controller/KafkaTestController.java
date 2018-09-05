package com.bonc.kafkasender.kafka.controller;

import com.bonc.kafkasender.kafka.core.KafkaScheduleTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lianghaiyang
 * @date 2018/08/28
 */
@RestController
public class KafkaTestController {

    @Resource
    private KafkaScheduleTask scheduleTask;

    @GetMapping("/hello")
    public String printTheResult() {
        return scheduleTask.generateRandomValue() + "";
    }
}
