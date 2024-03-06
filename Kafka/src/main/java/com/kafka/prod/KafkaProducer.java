package com.kafka.prod;


import com.kafka.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {
    public static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, Message> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(Message m){
        LOGGER.info(String.format("message sent-> %s",m.toString()));
        org.springframework.messaging.Message<Message> message= MessageBuilder
                .withPayload(m).setHeader(KafkaHeaders.TOPIC,"topic_j")
                .build();
        kafkaTemplate.send(message);
    }
}
