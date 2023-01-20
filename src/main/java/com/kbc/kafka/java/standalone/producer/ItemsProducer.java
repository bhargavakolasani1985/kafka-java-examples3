package com.kbc.kafka.java.standalone.producer;

import com.kbc.kafka.java.standalone.message.ItemsMessage;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Stream;

public class ItemsProducer {
    public static void main(String[] args) throws IOException {

        System.out.println("Producer Started...");

        // Load producer configuration settings from a local file
        //final Properties props = loadConfig("C:\\Work\\kafka_work\\kafka_proj_1\\src\\main\\resources\\producer.properties");
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9094");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        final String topic = "items"; //Change this topic name as required

        KafkaProducer producer = new KafkaProducer(props);
        Stream.generate(() -> new Random().nextInt()).limit(50).forEach(x -> {
            producer.send(new ItemsMessage(topic, String.valueOf(x)));
            producer.flush();
            try{
                Thread.sleep(1000);
            } catch(Exception exp){
                //Nothing to do
            }
            System.out.println("Message Sent");
        });
        producer.close();
    }

    // We'll reuse this function to load properties from the Consumer as well
    public static Properties loadConfig(final String configFile) throws IOException {
        if (!Files.exists(Paths.get(configFile))) {
            throw new IOException(configFile + " not found.");
        }
        final Properties cfg = new Properties();
        try (InputStream inputStream = new FileInputStream(configFile)) {
            cfg.load(inputStream);
        }
        return cfg;
    }

}