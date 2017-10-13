package org.mvarvarigos.thriftkafkacassandra.client.service;

import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.mvarvarigos.thriftkafkacassandra.client.thrift.client.ThriftMessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

@Service
public class MessageSenderService {

    @Autowired
    ThriftMessageClient thriftMessageClient;

    @Value("${thrift.message.version}")
    private short thriftVersion;

    @Scheduled(fixedRateString = "${millis.between.messages}")
    public void sendRandomMessage() {
        thriftMessageClient.send(generateRandomMessage());
    }

    private ThriftMessage generateRandomMessage() {
        final ThriftMessage result = new ThriftMessage();
        result.setV(thriftVersion);
        result.setTime(Calendar.getInstance().getTimeInMillis());
        result.setM(UUID.randomUUID().toString());
        return result;
    }

}
