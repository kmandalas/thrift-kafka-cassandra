package org.mvarvarigos.thriftkafkacassandra.server.thrift.service;

import org.apache.thrift.TException;
import org.mvarvarigos.thrift.impl.InvalidOperationException;
import org.mvarvarigos.thrift.impl.MessageService;
import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService.Iface {

    private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MessageServiceImpl.class);

    @Override
    public void save(ThriftMessage message) throws InvalidOperationException, TException {
        // TODO: send to kafka topic.
        LOGGER.debug(message.toString());
    }
}
