package org.mvarvarigos.thriftkafkacassandra.server.kafka.sender;

import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class KafkaSender {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

  @Autowired
  private KafkaTemplate<String, ThriftMessage> kafkaTemplate;

  public ListenableFuture<SendResult<String, ThriftMessage>> send(ThriftMessage message) {
    LOGGER.debug("sending payload: [{}]", message);
    return kafkaTemplate.sendDefault(message);
  }
}