package com.example.testkafkaproducer.service;

import com.example.testkafkaproducer.pojo.Course;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CourseProducer {
    private static final Logger log = LoggerFactory.getLogger(CourseProducer.class.getSimpleName());
    @Value("${kafka.topic.name.course}")
    public String courseTopicName;

    private final KafkaTemplate<String, Course> kafkaTemplate;

    @SneakyThrows
    public Course sendMessage(final Course course) {
        log.info("Message sent to kafka:" + course);
        CompletableFuture<SendResult<String, Course>> send =
                kafkaTemplate.send(courseTopicName, course);
        return send.get().getProducerRecord().value();
    }
}
