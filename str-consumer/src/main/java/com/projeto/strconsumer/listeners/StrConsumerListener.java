package com.projeto.strconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.projeto.strconsumer.custom.StrConsumerCustomListener;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {

    @SneakyThrows
    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message) {
        log.info("Create ::: Receive message {} " + message);
        throw  new IllegalAccessException("Exception...");
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {
        log.info("Log ::: Receive message {} " + message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic",containerFactory = "validMessageContainerFactory")
    public void history(String message) {
        log.info("History ::: Receive message {} " + message);
    }
//    @StrConsumerCustomListener(groupId = "group-2")
//    public void history(String message) {
//        log.info("History ::: Receive message {} " + message);
//    }

//    @KafkaListener(groupId = "group-1",
//            topicPartitions = {
//                    @TopicPartition(topic = "str-topic", partitions = {"0"})
//            }
//            , containerFactory = "strContainerFactory")
//    public void create(String message) {
//        log.info("Create ::: Receive message {} " + message);
//    }
//
//    @KafkaListener(groupId = "group-1", topicPartitions = {
//            @TopicPartition(topic = "str-topic", partitions = {"1"})
//    }, containerFactory = "strContainerFactory")
//    public void log(String message) {
//        log.info("Log ::: Receive message {} " + message);
//    }
//
//    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainerFactory")
//    public void history(String message) {
//        log.info("History ::: Receive message {} " + message);
//    }

//    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainerFactory")
//    public void history(String message) {
//        log.info("History ::: Receive message {} " + message);
//    }


}
