package org.body.balance.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInfo implements ApplicationRunner {

    @Value("${app.test.host}")
    private String host;

    @Value("${app.test.port}")
    private String port;

    @Value("${springdoc.swagger-ui.path}")
    private String swaggerPath;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.printf("Application started on host: %s:%s\n", host, port);
        System.out.printf("Swagger: %s:%s%s\n", host, port, swaggerPath);
    }
}
