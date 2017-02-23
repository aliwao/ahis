package cn.com.liandisys.ahis.server.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AhisEurekaServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AhisEurekaServerApplication.class).web(true).run(args);
	}
}
