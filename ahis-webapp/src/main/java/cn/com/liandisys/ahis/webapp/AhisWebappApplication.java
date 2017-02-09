package cn.com.liandisys.ahis.webapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan
@EnableRedisHttpSession
@MapperScan("cn.com.liandisys.ahis.webapp.mapper")
public class AhisWebappApplication {

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return (container -> {
			ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
			ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
			container.addErrorPages(error401Page, error404Page);
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(AhisWebappApplication.class, args);
	}
}
