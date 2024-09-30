package com.bcb.sms.simulator.model;

public class Message {

    private String senderPhoneNumber;
    private String recipientPhoneNumber;
    private String messageText;

    public Message(String senderPhoneNumber, String recipientPhoneNumber, String messageText) {
        this.senderPhoneNumber = senderPhoneNumber;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.messageText = messageText;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    public String getMessageText() {
        return messageText;
    }
}
