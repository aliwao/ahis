package cn.com.liandisys.ahis.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("cn.com.liandisys.ahis.payment.mapper")
public class AhisPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AhisPaymentApplication.class, args);
	}
}
