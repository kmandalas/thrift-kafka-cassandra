package org.mvarvarigos.thriftkafkacassandra.client.service;

import org.apache.thrift.TException;
import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.mvarvarigos.thriftkafkacassandra.client.thrift.client.ThriftMessageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

@Service
public class ThriftMessageSenderServiceImpl implements ThriftMessageSenderService {

    public static Logger LOGGER = LoggerFactory.getLogger(ThriftMessageSenderServiceImpl.class);

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
            LOGGER.error(String.format("An error occurred while sending the message: [%s]", message.toString()), e);
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
