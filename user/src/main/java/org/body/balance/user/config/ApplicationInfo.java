package org.body.balance.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInfo implements ApplicationRunner {

    @Value("${application.test.host}")
    private String host;

    @Value("${server.port}")
    private String port;

    @Value("${springdoc.swagger-ui.path}")
    private String swaggerPath;

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.printf("\nApplication name: %s\n", applicationName);
        System.out.printf("Application started on host: %s:%s\n", host, port);
        System.out.printf("Swagger: %s:%s%s\n\n", host, port, swaggerPath);
    }
}
