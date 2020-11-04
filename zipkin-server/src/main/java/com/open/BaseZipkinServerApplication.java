package com.open;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class BaseZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseZipkinServerApplication.class, args);
	}

}
