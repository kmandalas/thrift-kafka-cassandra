package org.mvarvarigos.thriftkafkacassandra.server.service;

import org.apache.thrift.TException;
import org.mvarvarigos.thrift.impl.InvalidOperationException;
import org.mvarvarigos.thrift.impl.MessageService;
import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.mvarvarigos.thriftkafkacassandra.server.kafka.sender.KafkaSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class MessageServiceImpl implements MessageService.Iface {

    private static Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    KafkaSender kafkaSender;

    @Override
    public void save(ThriftMessage message) throws InvalidOperationException, TException {

        ListenableFuture<SendResult<String, ThriftMessage>> future = kafkaSender.send(message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, ThriftMessage>>() {
            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("Sending to kafka failed for message: [{}]", message);
            }

            @Override
            public void onSuccess(SendResult<String, ThriftMessage> result) {
                LOGGER.trace("Message sent successfully to kafka: [{}]", message);
            }
        });

    }
}
