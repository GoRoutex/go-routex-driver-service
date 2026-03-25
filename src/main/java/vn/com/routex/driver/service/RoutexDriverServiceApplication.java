package vn.com.routex.driver.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import vn.com.go.routex.identity.security.annotation.EnableIdentitySecurity;

@SpringBootApplication
@EnableJpaAuditing
@EnableIdentitySecurity
public class RoutexDriverServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoutexDriverServiceApplication.class, args);
    }
}
