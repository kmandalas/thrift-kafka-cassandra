package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.converter;

import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.Message;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.MessageBuilder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class MessageConverter implements Converter<ThriftMessage, Message> {

    @Override
    public Message convert(ThriftMessage source) {
        return new MessageBuilder()
                .setId(UUID.randomUUID())
                .setMessage(source.getM())
                .setVersion(source.getV())
                .setTime(new Date(source.getTime()))
                .createMessage();
    }
}
