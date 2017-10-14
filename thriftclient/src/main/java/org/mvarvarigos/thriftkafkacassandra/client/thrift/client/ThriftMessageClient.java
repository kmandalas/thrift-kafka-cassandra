package org.mvarvarigos.thriftkafkacassandra.client.thrift.client;


import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.mvarvarigos.thrift.impl.MessageService;
import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ThriftMessageClient exposes functionality to a remote server via a thrift generated
 * {@link MessageService.Client client}.
 */
@Component
@Slf4j
public class ThriftMessageClient {

    @Value("${thrift.server.address}")
    private String serverAddress;

    @Value("${thrift.server.port}")
    private int serverPort;

    /**
     * Calls {@link MessageService.Client#save(ThriftMessage)} to the remote server.
     *
     * @param thriftMessage the remote call argument
     * @throws TException when the remote server is unreachable
     */
    public void send(final ThriftMessage thriftMessage) throws TException {
        TTransport transport;

        transport = new TSocket(serverAddress, serverPort);
        transport.open();

        TProtocol protocol = new TBinaryProtocol(transport);
        MessageService.Client client = new MessageService.Client(protocol);

        log.debug("calling remote method save >>");

        client.save(thriftMessage);

        log.debug("<< remote method save done");

        transport.close();

    }
}
