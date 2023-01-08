package com.example.testkafkaproducer.controller;

import com.example.testkafkaproducer.pojo.Course;
import com.example.testkafkaproducer.service.CourseProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course/producer")
@RequiredArgsConstructor
public class CourseProducerController {
    private final CourseProducer courseProducer;

    @PostMapping
    public Course publish(@RequestBody Course course) {
       return courseProducer.sendMessage(course);
    }
}
