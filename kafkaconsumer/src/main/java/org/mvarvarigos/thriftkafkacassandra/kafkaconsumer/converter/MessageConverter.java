package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.converter;

import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.Message;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class MessageConverter implements Converter<ThriftMessage, Message> {

    @Override
    public Message convert(ThriftMessage source) {
        return Message.builder()
                .id(UUID.randomUUID())
                .version(source.getV())
                .time(new Date(source.getTime()))
                .message(source.getM())
                .build();
    }
}
