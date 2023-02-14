package br.com.cbgomes.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/cards/resilience")
public class ResilienceController {

    private static final Logger logger = LoggerFactory.getLogger(ResilienceController.class);

    @GetMapping
    //@Retry(name = "get-cards", fallbackMethod = "cacheCards")
    //@CircuitBreaker (name = "default", fallbackMethod = "cacheCards")
    @RateLimiter (name = "default")
    public String testResilience() {
        logger.info("Request to feign-service is received");
       // final ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:3333/feign-service", String.class);
       // return response.getBody();
        return "calling feign service";
    }

    public String cacheCards(Exception e) {
        logger.info("Calling fallback method");
        return "calling the method to fallback in 5 request finished";
    }
}

//while true; do sleep 1; curl http://localhost:9080/api/v1/cards/resilience; echo -e '\n\n\n\n'$(date);done