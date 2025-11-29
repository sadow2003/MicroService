package ma.emsi.zougagh.config.swagger;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class InterCallMs {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        System.out.println("Creation bean RestTemplate start project");
        return new RestTemplate();
    }
    @Bean
    @LoadBalanced
    WebClient.Builder getWebClient(){
        return WebClient.builder();
    }
}
