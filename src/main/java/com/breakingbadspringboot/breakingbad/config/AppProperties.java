package com.breakingbadspringboot.breakingbad.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class AppProperties {

    private String clientUrl;

    public String getClientUrl() {
        return clientUrl;
    }

}
