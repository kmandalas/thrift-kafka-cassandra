package org.mvarvarigos.thriftkafkacassandra.client.service;

import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.mvarvarigos.thriftkafkacassandra.client.thrift.client.ThriftMessageClient;

/**
 * ThriftMessageSenderService sends random generated {@link ThriftMessage thriftMessages} every a configurable amount of
 * milliseconds.
 */
public interface ThriftMessageSenderService {

    /**
     * Scheduled function that sends a random generated {@link ThriftMessage thriftMessage} via a
     * {@link ThriftMessageClient}.
     */
    void sendRandomMessage();
}
