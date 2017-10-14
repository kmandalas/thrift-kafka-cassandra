package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.serivce;

import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.Message;

public interface MessageService {

    public void save(Message message);

}
