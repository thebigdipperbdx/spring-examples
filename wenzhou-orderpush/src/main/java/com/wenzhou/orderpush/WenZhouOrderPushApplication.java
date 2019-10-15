package com.wenzhou.orderpush;

import com.cxytiandi.elasticjob.annotation.EnableElasticJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication(scanBasePackages={"com.wenzhou.orderpush"})
@EnableElasticJob
public class WenZhouOrderPushApplication {

	private static CountDownLatch latch = new CountDownLatch(1);
	
	public static void main(String[] args) {
		SpringApplication.run(WenZhouOrderPushApplication.class, args);
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
