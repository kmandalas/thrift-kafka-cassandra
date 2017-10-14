package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import javax.annotation.PreDestroy;

@SpringBootApplication(scanBasePackages = {"org.mvarvarigos.thriftkafkacassandra.kafkaconsumer"})
@EnableCassandraRepositories("org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.repository.cassandra")
public class KafkaConsumerApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

    }

}
