package com.kbc.kafka.java.standalone.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ItemsConsumer {

    public static void main(String[] args) throws IOException {
        System.out.println("Consumer Started...");
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9094");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "test-group");
        //properties.put("from-beginning", "true");
        KafkaConsumer consumer = new KafkaConsumer(properties);
        List topics = new ArrayList();
        topics.add("items");
        consumer.subscribe(topics);
        while (true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord record: records){
                System.out.println(record.value());
            }
        }
    }
}
