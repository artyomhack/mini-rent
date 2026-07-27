package org.artyomhack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@ConfigurationPropertiesScan
public class MiniRestApplication {
    public static void main( String[] args ) {
        SpringApplication.run(MiniRestApplication.class, args);
    }
}
