package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.serivce;

import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.Message;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.repository.cassandra.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private static Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    MessageRepository messageRepository;

    @Override
    public void save(Message message) {
        LOGGER.trace("Persisting message: [{}]", message);
        try {
            messageRepository.save(message);
        } catch (RuntimeException e) {
            LOGGER.error(String.format("An error occurred while persisting message: [%s]", message.toString()), e);
        }

    }
}
