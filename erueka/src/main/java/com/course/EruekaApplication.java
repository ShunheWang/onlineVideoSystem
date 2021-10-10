package com.course;

import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaServer
public class EruekaApplication {
    private static final Logger log = LoggerFactory.getLogger(EruekaApplication.class);

    public static void main(String[] args) {

//        SpringApplication.run(EruekaApplication.class, args);

        SpringApplication sApp = new SpringApplication(EruekaApplication.class);
        Environment env = sApp.run(args).getEnvironment();
        log.info("启动成功");
        log.info("Eureka 地址：\t http://127.0.0.1:{}", env.getProperty("server.port"));

    }
}
