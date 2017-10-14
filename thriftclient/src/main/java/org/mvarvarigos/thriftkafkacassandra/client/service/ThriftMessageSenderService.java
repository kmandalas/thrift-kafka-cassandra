package org.mvarvarigos.thriftkafkacassandra.client.service;

import org.springframework.scheduling.annotation.Scheduled;

public interface ThriftMessageSenderService {

    void sendRandomMessage();
}
