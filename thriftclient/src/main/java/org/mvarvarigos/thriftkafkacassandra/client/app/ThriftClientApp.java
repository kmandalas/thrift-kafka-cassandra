package org.mvarvarigos.thriftkafkacassandra.client.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resources;

@SpringBootApplication(scanBasePackages = {"org.mvarvarigos.thriftkafkacassandra.client"})
@EnableScheduling
public class ThriftClientApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ThriftClientApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
