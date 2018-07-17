package com.raymon;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//(scanBasePackages = {"com.raymon.dao", "com.raymon.service", "com.raymon.service.impl","com.raymon.mapper"})
//
//@MapperScan("com.raymon.dao")
@SpringBootApplication
@EnableDubboConfiguration
public class DubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboProviderApplication.class, args);
	}
}
