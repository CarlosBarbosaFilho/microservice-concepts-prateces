package br.com.cbgomes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class MsCardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCardsApplication.class, args);
    }

}
