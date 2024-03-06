package com.kafka.consumer;

import com.kafka.model.Message;
import com.kafka.repo.KafkaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service

public class KafkaConsumer {
   // public static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    private KafkaRepo kafkaRepo;
    @KafkaListener(topics = "topic_j", groupId="myGroup")
public void consume(Message message){
       // LOGGER.info(String.format(message.toString()));
        kafkaRepo.save(message);

}
}
