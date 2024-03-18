package com.rp.videocall;

import com.rp.videocall.model.User;
import com.rp.videocall.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideocallApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideocallApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            UserService service
    ) {
        return args -> {
            service.register(User.builder()
                    .userName("Ali")
                    .email("ali@mail.com")
                   .password("aaa")
                    .build());

            service.register(User.builder()
                    .userName("John")
                    .email("john@mail.com")
                    .password("aaa")
                    .build());

            service.register(User.builder()
                    .userName("Anny")
                    .email("anna@mail.com")
                    .password("aaa")
                    .build());
        };
    }
}
