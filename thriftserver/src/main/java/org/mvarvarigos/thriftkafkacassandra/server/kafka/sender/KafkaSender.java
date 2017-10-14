package org.mvarvarigos.thriftkafkacassandra.server.kafka.sender;

import lombok.extern.slf4j.Slf4j;
import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
@Slf4j
public class KafkaSender {

  @Autowired
  private KafkaTemplate<String, ThriftMessage> kafkaTemplate;

  public ListenableFuture<SendResult<String, ThriftMessage>> send(ThriftMessage message) {
    log.debug("sending payload: [{}]", message);
    return kafkaTemplate.sendDefault(message);
  }
}