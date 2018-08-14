package cn.jasonren.javalearn.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

/**
 * @author JasonRen
 * @since 2018/8/9 上午11:22
 */
public class Producer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //生产者发送消息
        String topic = "test";
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 11; i++) {
            Scanner scanner = new Scanner(System.in);
            String value = scanner.next();

            ProducerRecord<String, String> msg = new ProducerRecord<>(topic, value);
            producer.send(msg);
        }
        producer.flush();

    }
}
