package org.mvarvarigos.thriftkafkacassandra.server.thrift.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.mvarvarigos.thrift.impl.MessageService;
import org.mvarvarigos.thriftkafkacassandra.server.service.MessageServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceServer {

    private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MessageServiceServer.class);

    private TServer server;

    @Value("${thrift.server.port}")
    private int serverPort;

    @Autowired
    MessageService.Iface messageService;

    public void start() throws TTransportException {
        final TServerTransport serverTransport = new TServerSocket(serverPort);
        final TServer.Args tsArgs = new TServer.Args(serverTransport)
                .processor(new MessageService.Processor<>(messageService));
        server = new TSimpleServer(tsArgs);

        LOGGER.debug("starting the server >>");

        server.serve();
    }

    public void stop() {
        if (server != null && server.isServing()) {
            LOGGER.debug("<< stopping the server");

            server.stop();
        }
    }
}
