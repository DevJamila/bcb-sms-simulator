package com.bcb.sms.simulator.model;

public record Message(String senderPhoneNumber, String recipientPhoneNumber, String messageText) {

}
