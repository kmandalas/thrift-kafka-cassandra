package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table
@Getter
@Builder
@ToString
public class Message {

    @PrimaryKey
    private UUID id;

    @Column("v")
    private short version;

    @Column("m")
    private String message;

    @Column("d")
    private Date time;

}