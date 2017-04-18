package com.netease.kafka.lesson1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerDemo {
    private static final String KAFKA_TOPIC="kafka-topic";
    public static void main(String[] args) {
        Map<String, Object> configs = new HashMap<String, Object>();
        configs.put("bootstrap.servers", "localhost:9092");
        configs.put("acks", "all");
        configs.put("retries", 0);
        configs.put("batch.size", 16384);
        configs.put("linger.ms", 1);
        configs.put("buffer.memory", 33554432);
        configs.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        configs.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer=new KafkaProducer<String, String>(configs);
        ProducerRecord<String, String> record=null;
        
        for (int i = 0; i <10; i++) {
            record=new ProducerRecord<String, String>(KAFKA_TOPIC, "record-"+i);
            Future<RecordMetadata> future=producer.send(record);
            try {
                RecordMetadata recordMetadata=future.get();
                System.out.format("PARTITION: %d OFFSET: %d\n", recordMetadata.partition(),recordMetadata.offset());
            }
            catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        
        for (int i = 0; i <10; i++) {
            record=new ProducerRecord<String, String>(KAFKA_TOPIC, "CallbackRecord-"+i);
            producer.send(record,new Callback() {  
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    System.out.format("PARTITION: %d OFFSET: %d\n", metadata.partition(),metadata.offset());
                }
            });
        }
        producer.close();
    }
}
