package com.example.testkafkaproducer.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Price {
    private String id;
    private String currency;
    private BigDecimal amount;
}
