package org.mvarvarigos.thriftkafkacassandra.server.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.mvarvarigos.thrift.impl.InvalidOperationException;
import org.mvarvarigos.thrift.impl.MessageService;
import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.mvarvarigos.thriftkafkacassandra.server.kafka.sender.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService.Iface {

    @Autowired
    KafkaSender kafkaSender;

    @Override
    public void save(ThriftMessage message) throws InvalidOperationException, TException {

        ListenableFuture<SendResult<String, ThriftMessage>> future = kafkaSender.send(message);
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
