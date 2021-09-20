package com.learning.kafkaproducerexample.controller;

import com.learning.kafkaproducerexample.controller.model.request.UserRequestModel;
import com.learning.kafkaproducerexample.controller.model.respose.ResponseModel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
@AllArgsConstructor
public class UserController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, UserRequestModel> userRequestModelKafkaTemplate;
    private static final String TOPIC = "UserDataTopic";

    @PostMapping("/publish/message")
    public ResponseEntity<ResponseModel> publishMessage(@RequestParam @NonNull final String message) {
        kafkaTemplate.send(TOPIC, message);
        return ResponseEntity.ok(ResponseModel.builder()
                .message("successfully published message")
                .status("Success").build());
    }

    @PostMapping("/publish/user")
    public ResponseEntity<ResponseModel> publishUserData(
            @RequestBody @Validated final UserRequestModel userRequestModel) {
        userRequestModelKafkaTemplate.send(TOPIC, userRequestModel);
        return ResponseEntity.ok(ResponseModel.builder()
                .message("successfully published user data")
                .status("Success").build());
    }
}
