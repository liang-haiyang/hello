package com.bonc.kafkasender.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author lianghaiyang
 * @date 2018/08/15
 */
@Component
public class Producer {
    private static Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate template;

    public void send(String topic, String value) {
        template.send(topic, value);
        String lastChar = value.substring(value.length() - 1);
        if (lastChar.equals("1")) {
            LOGGER.info("发生报警: " + value);
        }
    }
}
