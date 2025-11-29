package ma.emsi.zougagh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
@Slf4j
@SpringBootApplication
@EnableFeignClients
public class ProductService {
    public static void main(String[] args) {
        SpringApplication.run(ProductService.class);
    }
}
