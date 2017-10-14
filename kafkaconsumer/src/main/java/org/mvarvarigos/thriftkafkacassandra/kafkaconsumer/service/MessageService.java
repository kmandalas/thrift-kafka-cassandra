package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.service;

import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.Message;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.repository.cassandra.MessageRepository;

/**
 * MessageService exposes the supported CRUD operations for {@link Message messages} via
 * {@link MessageRepository messageReposiroty}.
 */
public interface MessageService {

    /**
     * Persists a {@link Message message}.
     *
     * @param message
     */
    void save(Message message);

}
