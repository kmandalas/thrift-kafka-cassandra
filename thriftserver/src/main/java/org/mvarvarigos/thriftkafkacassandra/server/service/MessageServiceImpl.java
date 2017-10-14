package org.mvarvarigos.thriftkafkacassandra.server.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.mvarvarigos.thrift.impl.InvalidOperationException;
import org.mvarvarigos.thrift.impl.MessageService;
import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.mvarvarigos.thriftkafkacassandra.server.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * MessageServiceImpl implements the {@link MessageService.Iface remoteInterface} exposed to the clients.
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService.Iface {

    @Autowired
    KafkaProducer kafkaProducer;

    /**
     * Sends the received {@link ThriftMessage thriftMessage} via the {@link KafkaProducer}.
     *
     * @param message the received {@link ThriftMessage thriftMessage}
     * @throws TException when communication errors occur
     */
    @Override
    public void save(ThriftMessage message) throws InvalidOperationException, TException {

        ListenableFuture<SendResult<String, ThriftMessage>> future = kafkaProducer.send(message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, ThriftMessage>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Sending to kafka failed for message: [{}]", message);
            }

            @Override
            public void onSuccess(SendResult<String, ThriftMessage> result) {
                log.trace("Message sent successfully to kafka: [{}]", message);
            }
        });

    }
}
