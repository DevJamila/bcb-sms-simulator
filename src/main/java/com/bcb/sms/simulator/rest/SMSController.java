package com.bcb.sms.simulator.rest;

import com.bcb.sms.simulator.model.Message;
import com.bcb.sms.simulator.model.MessageStatus;
import org.apache.commons.lang3.StringUtils;
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
            return new ResponseEntity<>(new MessageStatus(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    private void validateRequestBody(Message message) {
        String errorMessage = "";

        if (message == null) {
            errorMessage = "Request Body is missing.";
        } else if (checkStringIsMissing(message.senderPhoneNumber())) {
            errorMessage = "Sender Phone Number is missing.";
        } else if (checkStringIsMissing(message.recipientPhoneNumber())) {
            errorMessage = "Recipient Phone Number is missing.";
        } else if (checkStringIsMissing(message.messageText())) {
            errorMessage = "Message Text is missing.";
        }

        if (!errorMessage.isEmpty()) {
            throw new RuntimeException(errorMessage);
        }
    }

    private boolean checkStringIsMissing(String s) {
        return StringUtils.isBlank(s);
    }

}
