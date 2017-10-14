package org.mvarvarigos.thriftkafkacassandra.server.app;

import org.mvarvarigos.thriftkafkacassandra.server.thrift.server.MessageServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PreDestroy;

@SpringBootApplication(scanBasePackages = {"org.mvarvarigos.thriftkafkacassandra.server"})
public class ThriftServerApp implements CommandLineRunner {

    @Autowired
    MessageServer messageServer;

    public static void main(String[] args) {
        SpringApplication.run(ThriftServerApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        messageServer.start();
    }

    @PreDestroy
    public void cleanup() {
        messageServer.stop();
    }
}
