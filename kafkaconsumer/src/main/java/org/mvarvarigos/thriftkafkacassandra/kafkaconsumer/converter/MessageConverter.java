package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.converter;

import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.Message;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.MessageKey;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * MessageConverter converts a {@link ThriftMessage thriftMessage} to a {@link Message message}.
 */
@Component
public class MessageConverter implements Converter<ThriftMessage, Message> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Message convert(ThriftMessage source) {
        return Message.builder()
                .messageId(
                        MessageKey.builder()
                        .id(UUID.randomUUID())
                        .eventTime(new Date(source.getTime()))
                        .build()
                )
                .version(source.getV())
                .message(source.getM())
                .build();
    }
}
