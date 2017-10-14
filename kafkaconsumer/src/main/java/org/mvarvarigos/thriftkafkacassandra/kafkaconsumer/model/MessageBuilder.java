package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model;

import java.util.Date;
import java.util.UUID;

public class MessageBuilder {
    private UUID id;
    private short version;
    private String message;
    private Date time;

    public MessageBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public MessageBuilder setVersion(short version) {
        this.version = version;
        return this;
    }

    public MessageBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public MessageBuilder setTime(Date time) {
        this.time = time;
        return this;
    }

    public Message createMessage() {
        return new Message(id, version, message, time);
    }
}