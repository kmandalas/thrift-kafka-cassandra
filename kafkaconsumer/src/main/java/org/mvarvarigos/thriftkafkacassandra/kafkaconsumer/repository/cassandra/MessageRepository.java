package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.repository.cassandra;

import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.Message;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.MessageKey;
import org.springframework.data.repository.CrudRepository;

/**
 * MessageRepository exposes cassandra DB message table CRUD operations.
 */
public interface MessageRepository extends CrudRepository <Message, MessageKey>{
}
