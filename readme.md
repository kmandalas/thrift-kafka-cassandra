Thrift-Kafka-Cassandra

GitHub repo

Binary Production
Execute from the root folder
mvn clean package

Modules

thrift-server
Start: cd thriftserver && ./run.sh (or cd thriftserver && mvn spring-boot:run)

kafka-consumer
Start: cd kafkaconsumer && ./run.sh (or cd kafkaconsumer && mvn spring-boot:run)

thrift-client
Start: cd thriftclient && ./run.sh (or cd thriftclient && mvn spring-boot:run)

thrift-generated
This module is imported via maven dependency injection to the other modules since the generated class (ThriftMessage) is the 'glue' between them.
If you have thrift installed (version 0.9.1) you can un-comment the relevant section in the pom.xml and set the thrift executable path, so the thrift related classes are regenerated.

Additional information:
Kafka (kafka.txt)
I have included kafka and zookeeper startup (folder scripts) as long as the communication topic creation. Keep in mind that I run kafka directly from the binaries with the included zookeeper server.

Cassandra (cassandra.txt)
Included you will find namespace and message table creation queries (folder scripts).

MISCELLANEOUS
Mostly the configuration used is the default and some configurable properties are set explicity to default values (eg: kafka servers).
For boilerplate code generation the library lombok is used.
List of configurable properties via pom files:
log.level (loggers level)
kafka.server (producer consumer kafka connection)
consume.topic (consumer kafka topic)
consumer.group.id (consumer group id)
produce.topic (producer kafka topic)
millis.between.messages (a new random message is sent)
thrift.message.version (thrift message version - for now 1)

VERSIONS
java: 8
thrift: 0.9.1
kafka: 2.11-0.11.0.1
cassandra: 3.11.1

TOOLS:
OS: ubuntu 16.04 (virtual machine)
IDE: intellij community edition
Maven: 3.3.9

