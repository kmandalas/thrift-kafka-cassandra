package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.kafka.listener;

import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.Message;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.serivce.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    MessageService messageService;

    @Autowired
    Converter<ThriftMessage, Message> messageConverter;

    @KafkaListener(topics = "${consume.topic}", group = "${consumer.group.id}")
    public void consume(ThriftMessage message) {
        LOGGER.debug(message.toString());
        messageService.save(messageConverter.convert(message));
    }
}
