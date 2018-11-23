package com.liang.kafka.core;

import com.liang.config.AlarmConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author lianghaiyang
 * @date 2018/08/15
 */
@Component
public class KafkaScheduleTask {
    private static Logger LOGGER = LoggerFactory.getLogger(KafkaScheduleTask.class);
    @Autowired
    private Producer producer;

    @Resource
    private AlarmConfig alarmConfig;

    /**
     * 报警数组分布
     */
    private List<Integer> alarmArrays;


    /**
     * 文件行
     */
    private List<String> lines;

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    @Scheduled(fixedRate = 1000 * 60)
    public void sendDataInTime() {
        if (alarmArrays == null) {
            alarmArrays = new ArrayList<>();
            Integer alarmPercentage = alarmConfig.getAlarmPercentage();
            for (int i = 0; i < alarmPercentage; i++) {
                Integer alarmSite1 = alarmPercentage % 2;
                Integer alarmSite2;
                if (alarmSite1 != 0) {
                    alarmSite2 = (alarmPercentage + 1) / 2;
                } else {
                    alarmSite2 = alarmPercentage / 2;
                }
                if (0 == alarmSite1 && alarmSite2 == i) {
                    alarmArrays.add(1);
                } else {
                    alarmArrays.add(0);
                }
            }
        }
        LocalDateTime now = LocalDateTime.now();
        try {
            if (lines != null) {
                lines.parallelStream().forEach(this::processFile);
            } else {
                LOGGER.error("msg", "没有读取到信息, 请更正!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LocalDateTime after = LocalDateTime.now();
        System.err.println("开始发送" + now + "-------------------->" + after + "发送完毕");
    }

    private void processFile(String line) {
        if (StringUtils.isEmpty(line)) {
            return;
        }
        String[] split = line.split(",");
        if (split.length != 3) {
            return;
        }
        String id = split[0];
        String topic = split[2];
        String result = id + "," +
                split[1] + "," +
                System.currentTimeMillis() + "," +
                generateRandomValue();
        // 丢kafka
        producer.send(topic, result);
    }

    public int generateRandomValue() {
        Integer alarmPercentage = alarmConfig.getAlarmPercentage();
        return alarmArrays.get(new Random().nextInt(alarmPercentage));
    }
}
