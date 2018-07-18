package com.raymon.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//(scanBasePackages = {"com.raymon.provider.dao", "com.raymon.provider.service.impl","com.raymon.provider.mapper"})
//@MapperScan("com.raymon.provider.dao")
@SpringBootApplication
public class DubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboProviderApplication.class, args);
	}
}
