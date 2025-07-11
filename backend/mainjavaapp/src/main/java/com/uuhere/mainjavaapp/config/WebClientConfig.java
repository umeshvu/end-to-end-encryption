package com.uuhere.mainjavaapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${SIDECAR_URL}")
    private String sidecarUrl;

    @Bean
    public WebClient sidecarWebClient() {
        return WebClient.builder()
                .baseUrl(sidecarUrl)
                .build();
    }
}
