package com.coderqian.dubbocore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.coderqian.dubbocore.mapper")
public class DubboCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboCoreApplication.class, args);
	}

}

