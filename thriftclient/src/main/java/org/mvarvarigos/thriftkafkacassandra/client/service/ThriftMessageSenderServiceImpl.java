package org.mvarvarigos.thriftkafkacassandra.client.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.mvarvarigos.thriftkafkacassandra.client.thrift.client.ThriftMessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

@Service
@Slf4j
public class ThriftMessageSenderServiceImpl implements ThriftMessageSenderService {

    @Value("${thrift.message.version}")
    private short thriftVersion;

    @Autowired
    ThriftMessageClient thriftMessageClient;

    @Scheduled(fixedRateString = "${millis.between.messages}")
    public void sendRandomMessage() {
        final ThriftMessage message = generateRandomMessage();
        try {
            thriftMessageClient.send(message);
        } catch (TException e) {
            log.error(String.format("An error occurred while sending the message: [%s]", message.toString()), e);
        }
    }

    private ThriftMessage generateRandomMessage() {
        final ThriftMessage result = new ThriftMessage();
        result.setV(thriftVersion);
        result.setTime(Calendar.getInstance().getTimeInMillis());
        result.setM(UUID.randomUUID().toString());
        return result;
    }

}
