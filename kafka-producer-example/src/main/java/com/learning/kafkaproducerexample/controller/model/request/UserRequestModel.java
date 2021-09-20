package com.learning.kafkaproducerexample.controller.model.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequestModel {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private Integer age;
    @NonNull
    private Integer salary;
}
