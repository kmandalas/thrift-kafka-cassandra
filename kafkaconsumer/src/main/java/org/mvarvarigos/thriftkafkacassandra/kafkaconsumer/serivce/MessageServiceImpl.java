package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.serivce;

import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.model.Message;
import org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.repository.cassandra.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }
}
