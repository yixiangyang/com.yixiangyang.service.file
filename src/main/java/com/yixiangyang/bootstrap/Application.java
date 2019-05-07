package com.yixiangyang.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
@ComponentScan(basePackages= {"com.yixiangyang.**.service", "com.yixiangyang.**.controller"})
//@Configuration
//@EnableAutoConfiguration
//@EnableAdminServer
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
