package org.body.balance.auth.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties implements ApplicationRunner {

    private String name;
    private String host;

    @Value("${server.port}")
    private String port;

    @Value("${springdoc.swagger-ui.path}")
    private String swaggerPath;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.printf("\nApplication name: %s\n", name);
        System.out.printf("Application started on host: %s:%s\n", host, port);
        System.out.printf("Swagger: %s:%s%s\n\n", host, port, swaggerPath);
    }
}