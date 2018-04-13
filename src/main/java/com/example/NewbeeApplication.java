package com.example;

import com.example.common.kafka.KafkaSender;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.example.*.dao")
public class NewbeeApplication extends SpringBootServletInitializer {
	//test develope merge into master
	@Override
	protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(NewbeeApplication.class);
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(NewbeeApplication.class, args);
		KafkaSender sender = context.getBean(KafkaSender.class);

		for (int i = 0; i < 3; i++) {
			//调用消息发送类中的消息发送方法
			sender.send();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
