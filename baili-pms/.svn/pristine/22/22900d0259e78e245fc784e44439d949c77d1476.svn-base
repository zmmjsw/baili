package com.baili.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 
 * @ClassName: PmsApplication
 * @Description: TODO(启动类)
 * @author zhumingming
 * @date 2017年12月7日 下午6:24:28
 *
 */
@SpringBootApplication(scanBasePackages={"com.baili.pms","com.baili.core"})
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
public class PmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(PmsApplication.class, args);
	}

}