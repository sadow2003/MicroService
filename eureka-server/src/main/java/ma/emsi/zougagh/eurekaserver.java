package ma.emsi.zougagh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
@EnableEurekaServer
public class eurekaserver {
    public static void main(String[] args) {
        SpringApplication.run(eurekaserver.class);
    }
}