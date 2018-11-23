package com.liang.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author lianghaiyang
 * @date 2018/08/15
 */
@Component
@Configuration
@Setter
@Getter
@ToString
public class AlarmConfig {
    @Value("${percent}")
    private Integer alarmPercentage = 20;
}
