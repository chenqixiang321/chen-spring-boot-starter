package com.chen.api;

import com.chen.api.plugin.annotation.EnableChenServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableChenServer
public class SpringbootStartApplication {
    public SpringbootStartApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStartApplication.class, args);
    }
}
