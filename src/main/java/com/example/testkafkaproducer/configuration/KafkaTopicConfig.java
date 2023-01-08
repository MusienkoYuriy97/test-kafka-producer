package com.example.testkafkaproducer.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${kafka.topic.name.course}")
    public String courseTopicName;

    @Bean
    public NewTopic courseTopic() {
        return TopicBuilder.name(courseTopicName)
                .partitions(3)
                .build();
    }
}
