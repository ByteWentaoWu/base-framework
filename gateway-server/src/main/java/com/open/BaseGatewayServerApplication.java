package com.open;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaClient
public class BaseGatewayServerApplication {

	private static final Logger log = LoggerFactory.getLogger(BaseGatewayServerApplication.class);

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext application = SpringApplication.run(BaseGatewayServerApplication.class, args);
		Environment env = application.getEnvironment();
		log.info(
				"\n----------------------------------------------------------\n\t" + "应用 '{}' 运行成功! 访问连接:\n\t"
						+ "Swagger文档: \t\thttp://{}:{}{}{}/doc.html\n\t"
						+ "----------------------------------------------------------",
				env.getProperty("spring.application.name"), InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"), env.getProperty("server.servlet.context-path", ""),
				env.getProperty("spring.mvc.servlet.path", ""));
	}

}
