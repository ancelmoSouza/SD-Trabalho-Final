package com.Entitys;

public class Message {
    private int messageTyppe;
    private int requestId;
    private String objectreference;
    private String methodId;
    private byte[] arguments;

    public Message(int messageTyppe, int requestId, String objectreference, String methodId, byte[] arguments) {
        this.messageTyppe = messageTyppe;
        this.requestId = requestId;
        this.objectreference = objectreference;
        this.methodId = methodId;
        this.arguments = arguments;
    }

    public Message () {
        this.arguments = new byte[1000];
    }

    public int getMessageTyppe() {
        return messageTyppe;
    }

    public void setMessageTyppe(int messageTyppe) {
        this.messageTyppe = messageTyppe;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getObjectreference() {
        return objectreference;
    }

    public void setObjectreference(String objectreference) {
        this.objectreference = objectreference;
    }

    public String getMethodId() {
        return methodId;
    }

    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    public byte[] getArguments() {
        return arguments;
    }

    public void setArguments(byte[] arguments) {
        this.arguments = arguments;
    }
}
