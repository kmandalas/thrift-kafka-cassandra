package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.service;

import lombok.extern.slf4j.Slf4j;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.Message;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.repository.cassandra.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * {@inheritDoc}
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Message message) {
        log.trace("Persisting message: [{}]", message);
        try {
            messageRepository.save(message);
        } catch (RuntimeException e) {
            log.error(String.format("An error occurred while persisting message: [%s]", message.toString()), e);
        }

    }
}
