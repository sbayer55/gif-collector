package com.tesseractus.gifcollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties
@EnableAuthorizationServer
@EnableResourceServer
public class GifCollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GifCollectorApplication.class, args);
	}

}
