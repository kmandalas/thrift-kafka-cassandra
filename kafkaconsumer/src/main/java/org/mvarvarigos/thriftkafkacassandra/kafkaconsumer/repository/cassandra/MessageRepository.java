package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.repository.cassandra;

import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository <Message, Long>{
}
