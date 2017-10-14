package org.mvarvarigos.thriftkafkacassandra.server.thrift.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.mvarvarigos.thrift.impl.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageServer {

    @Value("${thrift.server.port}")
    private int serverPort;

    @Autowired
    MessageService.Iface messageService;

    private TServer server;

    public void start() throws TTransportException {
        final TServerTransport serverTransport = new TServerSocket(serverPort);
        final TServer.Args tsArgs = new TServer.Args(serverTransport)
                .processor(new MessageService.Processor<>(messageService));
        server = new TSimpleServer(tsArgs);

        log.debug("starting the server >>");

        server.serve();
    }

    public void stop() {
        if (server != null && server.isServing()) {
            log.debug("<< stopping the server");

            server.stop();
        }
    }
}
