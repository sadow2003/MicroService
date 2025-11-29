package ma.emsi.zougagh.products.externe;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {
    @GetMapping("/users")
    String callMsUser();
}