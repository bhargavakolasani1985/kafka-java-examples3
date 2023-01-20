# kafka-java-examples
This repository contains some examples on how to manage kafka from java programs

Before running these programs, we need to start Kafka Zookeeper and Broker nodes using following commands in the same order.
Please note that starting zoo keeper first is mandatory with version 2.4.0.

Download apache-kafka2.4.0 and intall(copy) it under C:\Work\kafka_2.12-2.4.0

--Move to C:\Work\kafka_2.12-2.4.0\bin\windows  folder and execute these below commands

--Start Zoo keeper
zookeeper-server-start.bat C:\Work\kafka_2.12-2.4.0\config\zookeeper.properties

--Start as many nodes(brokers) as you want.
kafka-server-start.bat C:\Work\kafka_2.12-2.4.0\config\server1.properties
kafka-server-start.bat C:\Work\kafka_2.12-2.4.0\config\server2.properties

--Create topic
kafka-topics.bat --create --topic items --partitions 1 --bootstrap-server localhost:9094