package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;
import java.util.UUID;

/**
 * Message represents the cassandra DB message table.
 */
@Table
@Getter
@Builder
@ToString
public class Message {

    @PrimaryKey
    private MessageKey messageId;

    @Column("v")
    private short version;

    @Column("m")
    private String message;

}