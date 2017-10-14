package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.kafka.consumer;

import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.Message;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * KafkaConsumer listens to the given 'consume.topic' for {@link ThriftMessage thriftMessages} and persists them via
 * {@link MessageService messageService}.
 */
@Component
public class KafkaConsumer {

    @Autowired
    MessageService messageService;

    @Autowired
    Converter<ThriftMessage, Message> messageConverter;

    @KafkaListener(topics = "${consume.topic}", group = "${consumer.group.id}")
    public void consume(ThriftMessage message) {

        // Convert and save message.
        messageService.save(messageConverter.convert(message));
    }
}
