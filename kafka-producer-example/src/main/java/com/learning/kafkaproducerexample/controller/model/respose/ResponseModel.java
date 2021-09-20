package com.learning.kafkaproducerexample.controller.model.respose;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {
    private String status;
    private String message;
    private Object payload;
}
