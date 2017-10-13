package org.mvarvarigos.thriftkafkacassandra.client.thrift.client;


import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.mvarvarigos.thrift.impl.MessageService;
import org.mvarvarigos.thrift.impl.ThriftMessage;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ThriftMessageClient {

    private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ThriftMessageClient.class);

    @Value("${thrift.server.address}")
    private String serverAddress;

    @Value("${thrift.server.port}")
    private int serverPort;

    public void send(final ThriftMessage thriftMessage) {
        try {
            TTransport transport;

            transport = new TSocket(serverAddress, serverPort);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            MessageService.Client client = new MessageService.Client(protocol);

            LOGGER.debug("calling remote method save >>");

            client.save(thriftMessage);

            LOGGER.debug("<< remote method save done");

            transport.close();

        } catch (TException e) {
            e.printStackTrace();
        }

    }
}
