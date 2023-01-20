package com.kbc.kafka.java.standalone.message;

import org.apache.kafka.clients.producer.ProducerRecord;

public class ItemsMessage extends ProducerRecord<String, String> {
    public ItemsMessage(String topic, String value) {
        super(topic, value);
    }
}
