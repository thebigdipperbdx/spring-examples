package com.wenzhou.orderreceive.config;

import com.wenzhou.orderreceive.util.AESCoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;

@Configuration
@IntegrationComponentScan
public class MqttReceiveConfig {

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
	@Value("${spring.mqtt.theme}")
	private String mqttTheme;
	@Value("${spring.aes.key}")
	private String aesKey;

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

	// 接收通道
	@Bean
	public MessageChannel mqttInputChannel() {
		return new DirectChannel();
	}

	// 配置client,监听的topic
	@Bean
	public MessageProducer inbound() {
		MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(clientId + "_inbound",
				mqttClientFactory(), mqttTheme);
		adapter.setCompletionTimeout(connectionTimeout);
		adapter.setConverter(new DefaultPahoMessageConverter());
		adapter.setQos(1);
		adapter.setOutputChannel(mqttInputChannel());
		return adapter;
	}

	// 通过通道获取数据
	@Bean
	@ServiceActivator(inputChannel = "mqttInputChannel")
	public MessageHandler handler() {
		return new MessageHandler() {
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				MessageHeaders headers = message.getHeaders();
				String topic = headers.get("mqtt_topic").toString();
				if (mqttTheme.equalsIgnoreCase(topic)) {
					try {
						String msg = message.getPayload().toString();
						// 解密
						String resultMsg = AESCoder.decrypt(aesKey, msg);
						System.out.println("解密后的内容=========" + resultMsg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
	}

}
