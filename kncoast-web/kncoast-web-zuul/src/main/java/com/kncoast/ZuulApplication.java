package com.kncoast;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

	private static Logger logger = LoggerFactory.getLogger(ZuulApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ZuulApplication.class, args);
		String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
		String env = "default";
		if (!ArrayUtils.isEmpty(activeProfiles)) {
			env = activeProfiles[0];
		}
		logger.info("Current startup environment：" + env);
	}
}
