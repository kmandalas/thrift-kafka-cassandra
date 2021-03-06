package org.mvarvarigos.thriftkafkacassandra.kafkaconsumer.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


/**
 * KafkaConsumerApp is the entry point of kafka-consumer application.
 */
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
