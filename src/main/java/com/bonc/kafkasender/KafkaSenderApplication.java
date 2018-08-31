package com.bonc.kafkasender;

import com.bonc.kafkasender.core.KafkaScheduleTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class KafkaSenderApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(KafkaSenderApplication.class);

	@Resource
	private KafkaScheduleTask scheduleTask;

	public static void main(String[] args) {
		SpringApplication.run(KafkaSenderApplication.class, args);
	}

	@PostConstruct
	private void  readFile(){
		File file = null;
		try {
			file = ResourceUtils.getFile("classpath:hello.csv");
		} catch (Exception e) {
			LOGGER.error("msg","文件找不到");
		}
		List<String> lines = null;
		try {
			if (file == null){
				lines = Files.readAllLines(Paths.get("../config/hello.csv"));
			}else {
				lines = Files.readAllLines(Paths.get(file.getPath()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		scheduleTask.setLines(lines);
	}
}
