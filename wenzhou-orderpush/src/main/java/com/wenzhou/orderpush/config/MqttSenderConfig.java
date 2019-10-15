package com.wenzhou.orderpush.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
@IntegrationComponentScan
public class MqttSenderConfig {
	@Value("${spring.mqtt.username}")
	private String username;

	@Value("${spring.mqtt.password}")
	private String password;

	@Value("${spring.mqtt.url}")
	private String hostUrl;

	@Value("${spring.mqtt.client.id}")
	private String clientId;

	@Value("${spring.mqtt.default.topic}")
	private String defaultTopic;

	@Value("${spring.mqtt.connectionTimeout}")
	private int connectionTimeout;

	@Value("${spring.mqtt.keepAliveInterval}")
	private int keepAliveInterval;

	@Bean
	public MqttPahoClientFactory mqttClientFactory() {
		DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
		factory.setUserName(username);
		factory.setPassword(password);
		factory.setServerURIs(new String[] { hostUrl });
		// 设置超时时间
		factory.setConnectionTimeout(connectionTimeout);
		// 设置会话心跳时间
		factory.setKeepAliveInterval(keepAliveInterval);
		return factory;
	}

	@Bean
	@ServiceActivator(inputChannel = "mqttOutboundChannel")
	public MessageHandler mqttOutbound() {
		MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(clientId, mqttClientFactory());
		messageHandler.setAsync(true);
		messageHandler.setDefaultTopic(defaultTopic);
		return messageHandler;
	}

	@Bean
	public MessageChannel mqttOutboundChannel() {
		return new DirectChannel();
	}
}
