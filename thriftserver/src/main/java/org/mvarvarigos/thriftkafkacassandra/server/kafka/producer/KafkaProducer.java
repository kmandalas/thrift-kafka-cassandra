package org.mvarvarigos.thriftkafkacassandra.server.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * KafkaProducer sends {@link ThriftMessage thriftMessages} to a configurable kafka topic for further processing.
 */
@Component
@Slf4j
public class KafkaProducer {

  @Autowired
  private KafkaTemplate<String, ThriftMessage> kafkaTemplate;

  /**
   * Sends the given {@link ThriftMessage thriftMessage} to a configurable kafka topic.
   *
   * @param message
   * @return
   */
  public ListenableFuture<SendResult<String, ThriftMessage>> send(ThriftMessage message) {
    log.trace("sending payload: [{}]", message);
    return kafkaTemplate.sendDefault(message);
  }
}