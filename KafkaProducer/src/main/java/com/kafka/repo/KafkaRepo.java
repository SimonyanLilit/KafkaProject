package com.kafka.repo;

import com.kafka.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaRepo extends JpaRepository<Message,Integer> {
}
