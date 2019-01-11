package com.baili.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 
* @ClassName: SmsApplication 
* @Description: TODO(店鋪管理服務) 
* @author zhumingming 
* @date 2018年12月10日 下午2:40:25 
*
 */
@SpringBootApplication(scanBasePackages={"com.baili.sms","com.baili.core"})
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
public class SmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}

}