package com.wenzhou.orderreceive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication(scanBasePackages={"com.wenzhou.orderreceive"})
public class WenZhouOrderReceiveApplication {

	private static CountDownLatch latch = new CountDownLatch(1);
	
	public static void main(String[] args) {
		SpringApplication.run(WenZhouOrderReceiveApplication.class, args);
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
