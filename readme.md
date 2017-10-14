# Thrift-Kafka-Cassandra

Inline-style: 
![alt text](https://github.com/adam-p/markdown-here/raw/master/thrift-kafka-cassandra.jpg "diagram")


### Binary Production
Execute from the root folder
`mvn clean package`

### Modules

#### thrift-server
Start: `cd thriftserver && ./run.sh` (or `cd thriftserver && mvn spring-boot:run`)

#### kafka-consumer
Start: `cd kafkaconsumer && ./run.sh` (or `cd kafkaconsumer && mvn spring-boot:run`)

#### thrift-client
Start: `cd thriftclient && ./run.sh` (or `cd thriftclient && mvn spring-boot:run`)

#### thrift-generated
This module is imported via maven dependency injection to the other modules since the generated class (_ThriftMessage_) is the 'glue' between them.
If you have thrift installed (version 0.9.1) you can un-comment the relevant section in the pom.xml and set the thrift executable path, so the thrift related classes are regenerated.

### MISCELLANEOUS
Mostly the configuration used is the default and some configurable properties are set explicity to default values (eg: kafka servers).<br>
For boilerplate code generation the library lombok is used.<br>
List of configurable properties via pom files:
* _log.level_ (loggers level)
* _kafka.server_ (producer consumer kafka connection)
* _consume.topic_ (consumer kafka topic)
* _consumer.group.id_ (consumer group id)
* _produce.topic_ (producer kafka topic)
* _millis.between.messages_ (a new random message is sent)
* _thrift.message.version_ (thrift message version - for now 1)
