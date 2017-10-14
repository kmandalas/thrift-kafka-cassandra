package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table
public class Message {

    @PrimaryKey
    private UUID id;

    @Column("v")
    private short version;

    @Column("m")
    private String message;

    @Column("d")
    private Date time;

    public Message() {
    }

    public Message(UUID id, short version, String message, Date time) {
        this.id = id;
        this.version = version;
        this.message = message;
        this.time = time;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public short getVersion() {
        return version;
    }

    public void setVersion(short version) {
        this.version = version;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}