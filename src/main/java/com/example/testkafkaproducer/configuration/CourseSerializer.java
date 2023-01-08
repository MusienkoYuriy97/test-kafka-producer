package com.example.testkafkaproducer.configuration;

import com.example.testkafkaproducer.pojo.Course;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class CourseSerializer implements Serializer<Course> {
    @Override
    public byte[] serialize(final String topicName, final Course course) {
        try {
            if (course == null) {
                return null;
            }
            return new ObjectMapper().writeValueAsBytes(course);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing MessageDto to byte[]");
        }
    }
}
