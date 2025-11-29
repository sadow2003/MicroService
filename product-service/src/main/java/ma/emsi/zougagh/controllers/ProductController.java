package ma.emsi.zougagh.controllers;


import ma.emsi.zougagh.products.externe.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/synch/rest-template")
    public String callWithRestTemplateSynch() {
        System.out.println("Starting call MS users ..." + Thread.currentThread());
        String reponseMsUsers = restTemplate.getForObject("http://USER-SERVICE/users", String.class);
        System.out.println("End call MS users ..." + Thread.currentThread());
        return "la reponse MS users via RestTemplate: " + reponseMsUsers;
    }

    @Autowired
    private UserClient userClient;
    @GetMapping("/synch/open-feign")
    public String callWithOpenFeignSynch() {
        System.out.println("Start calling MS users via OpenFeign ..." + Thread.currentThread());
        String reponseMsUsers = userClient.callMsUser();
        System.out.println("End call MS users ..." + Thread.currentThread());
        return "la reponse MS users via openFeign : " + reponseMsUsers;
    }
    // II - WebClient (synchrone/ asunchrone starter web flux)
    @Autowired
    private WebClient.Builder webClient;
    @GetMapping("/asynch/web-client")
    public Mono<String> callWithWebClientASynch() {
        System.out.println("AVANT → thread MVC " +
                Thread.currentThread());
        Mono<String> mono = webClient.build()
                .get()
                .uri("http://USER-SERVICE/users")
                .retrieve()
                .bodyToMono(String.class)
                .doOnSubscribe(s -> System.out.println("la demande est faite par : " + Thread.currentThread()))
                .doOnNext(s -> System.out.println("la réponse est traitée par : " + Thread.currentThread()));
        System.out.println("APRES → thread MVC " + Thread.currentThread());
        return mono;
    }
}