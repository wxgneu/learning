package com.netease.kafka.lesson1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ComsumerDemo {
    public static void main(String[] args) {
        Map<String, Object> configs = new HashMap<String, Object>();
        configs.put("bootstrap.servers", "localhost:9092");
        configs.put("group.id", "test");
        configs.put("enable.auto.commit", "true");
        configs.put("auto.commit.interval.ms", "1000");
        configs.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        configs.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(configs);
        consumer.subscribe(Arrays.asList("kafka-topic"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            records.partitions();
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }    
        }
    }
}
