package org.mvarvarigos.thriftkafkacassandra.server.service;

import org.apache.thrift.TException;
import org.mvarvarigos.thrift.impl.InvalidOperationException;
import org.mvarvarigos.thrift.impl.MessageService;
import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.mvarvarigos.thriftkafkacassandra.server.kafka.sender.Sender;
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
    Sender sender;

    @Override
    public void save(ThriftMessage message) throws InvalidOperationException, TException {

        LOGGER.trace(message.toString());

        ListenableFuture<SendResult<String, ThriftMessage>> future = sender.send(message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, ThriftMessage>>() {
            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("failed: {}", message);
            }

            @Override
            public void onSuccess(SendResult<String, ThriftMessage> result) {
                LOGGER.debug("sent: {}", message);
            }
        });
    }
}
