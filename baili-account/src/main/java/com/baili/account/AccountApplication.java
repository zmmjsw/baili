package com.baili.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;




/**
 * 
* @ClassName: AccountApplication 
* @Description: TODO(用户管理启动类) 
* @author zhumingming 
* @date 2018年11月22日 上午10:32:41 
*
 */
@SpringBootApplication(scanBasePackages={"com.baili.account","com.baili.core"})
@EnableEurekaClient
public class AccountApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

}