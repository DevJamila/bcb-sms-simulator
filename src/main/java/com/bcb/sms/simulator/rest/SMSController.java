package com.bcb.sms.simulator.rest;

import com.bcb.sms.simulator.model.Message;
import com.bcb.sms.simulator.model.MessageStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SMSController {

    @PostMapping
    public ResponseEntity<MessageStatus> sendMessage(@RequestBody Message message) {
        try {
            validateRequestBody(message);
            return new ResponseEntity<>(new MessageStatus("SUCCESS"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private void validateRequestBody(Message message) {
        if (message.getMessageText().isBlank()
        || message.getRecipientPhoneNumber().isBlank()
        || message.getSenderPhoneNumber().isBlank()) {
            throw new RuntimeException();
        }
    }

}
