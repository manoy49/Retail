package com.sample.shop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableConfigurationProperties
public class ShopApplication {

    public static void main(String[] args) {
        run(ShopApplication.class);
    }

}
