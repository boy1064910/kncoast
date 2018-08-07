package com.kncoast;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
	
	private static Logger logger = LoggerFactory.getLogger(EurekaApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EurekaApplication.class, args);
		String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
		String env = "default";
		if (!ArrayUtils.isEmpty(activeProfiles)) {
			env = activeProfiles[0];
		}
		logger.info("Current startup environment：" + env);
	}
}
