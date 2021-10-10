package com.course.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SystemApplication {
    private static final Logger log = LoggerFactory.getLogger(SystemApplication.class);

    public static void main(String[] args) {

        SpringApplication sApp = new SpringApplication(SystemApplication.class);
        Environment env = sApp.run(args).getEnvironment();
        log.info("启动成功");
        log.info("Eureka 地址：\t http://127.0.0.1:{}", env.getProperty("server.port"));

    }
}
