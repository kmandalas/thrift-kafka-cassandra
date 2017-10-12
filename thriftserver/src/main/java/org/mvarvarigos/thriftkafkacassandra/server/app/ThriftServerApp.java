package org.mvarvarigos.thriftkafkacassandra.server.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThriftServerApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ThriftServerApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
