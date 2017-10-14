package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.serivce;

import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.Message;

public interface MessageService {

    void save(Message message);

}
