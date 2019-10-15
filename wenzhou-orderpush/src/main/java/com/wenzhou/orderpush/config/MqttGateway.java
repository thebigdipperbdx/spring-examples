package com.wenzhou.orderpush.config;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {
	void sendToMqtt(String data);
	void sendToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic);
	// data:发送内容   topic:主题名称  qos:消息处理机制（值为：0,1,2，默认为0）
	void sendToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos);
}