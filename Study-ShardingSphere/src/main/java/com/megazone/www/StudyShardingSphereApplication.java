package com.megazone.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class StudyShardingSphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyShardingSphereApplication.class, args);
	}

}
