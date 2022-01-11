package com.breakingbadspringboot.breakingbad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); safer

        return NoOpPasswordEncoder.getInstance(); //NoOpPasswordEncoder is for demo purposes only
    }

}


