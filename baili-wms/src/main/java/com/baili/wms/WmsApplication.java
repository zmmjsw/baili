package com.baili.wms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: WmsApplication
 * @Description: TODO(仓库管理系统)
 * @author 袁泉
 * @date 2018年10月25日 下午3:41:58
 */
@SpringBootApplication(scanBasePackages = { "com.baili" })
@MapperScan({ "com.baili.dao.mysql" })
public class WmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(WmsApplication.class, args);
	}
}
