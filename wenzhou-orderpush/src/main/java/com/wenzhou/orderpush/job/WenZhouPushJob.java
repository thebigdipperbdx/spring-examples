package com.wenzhou.orderpush.job;

import com.cxytiandi.elasticjob.annotation.ElasticJobConf;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.wenzhou.orderpush.config.MqttGateway;
import com.wenzhou.orderpush.util.AESCoder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * https://blog.csdn.net/thebigdipperbdx/article/details/83548145
 */
@ElasticJobConf(name = "wenZhouPushJob")
public class WenZhouPushJob implements SimpleJob {

	private static final Logger LOGGER = Logger.getLogger(WenZhouPushJob.class);

	@Autowired
	private MqttGateway mqttGateway;

	@Value("${spring.destination.orderpush}")
	private String destinationPath;

	@Value("${spring.aes.key}")
	private String aesKey;

	@Value("${spring.mqtt.theme}")
	private String mqttTheme;


	@Override
	public void execute(ShardingContext shardingContext) {
		LOGGER.info("==============浙江温州订单数据==============推送开始==============");
		String contentLine=null;
		try {
			File[] files = new File(destinationPath).listFiles();
			long startTime = System.currentTimeMillis();
			int num = 0;
			for (int i = 0; i < files.length; i++) {
				InputStreamReader inReader = new InputStreamReader(new FileInputStream(files[i]), "GBK");
				BufferedReader bReader = new BufferedReader(inReader);
				contentLine = bReader.readLine();
				while (contentLine != null) {
					// 日志打印
					LOGGER.info("读取的当前数据==》" + contentLine.trim());
					// AES加密
					String encryptContent = AESCoder.encrypt(aesKey, contentLine.trim());
					// 发送到MQTT
					mqttGateway.sendToMqtt(encryptContent, mqttTheme);
					num++;
					// 读取下一行
					contentLine = bReader.readLine();
				}
				bReader.close();
			}
			long endTime = System.currentTimeMillis();
			LOGGER.info("浙江温州订单数据推送==发送到MQ,耗时:" + (endTime - startTime) + "ms，推送订单总数==》" + num + " 个");

			LOGGER.info("浙江温州订单数据推送==删除文件开始");
			startTime = System.currentTimeMillis();
			int fNum = 0;
			// 内容读完，删除文件
			for (File file : files) {
				if (file.isFile()) {
					String fileName = file.getName();
					boolean flg = file.delete();
					if (!flg) {
						LOGGER.info("文件名==》" + fileName + "==》删除失败");
					} else {
						fNum++;
					}
				}
			}
			endTime = System.currentTimeMillis();
			LOGGER.info("浙江温州订单数据推送==删除文件结束,耗时:" + (endTime - startTime) + "ms，删除文件总数==》" + fNum + " 个");

			LOGGER.info("==============浙江温州订单数据==============推送结束==============");

		} catch (Exception e) {
			LOGGER.error("浙江温州订单数据推送出错，读取的当前数据==》" + contentLine + "，异常原因==》" + e.getMessage(), e);
		}
	}
}
