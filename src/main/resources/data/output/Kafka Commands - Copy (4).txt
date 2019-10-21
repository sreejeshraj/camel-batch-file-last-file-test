cd /cygdrive/d/Sreejesh/Installers/kafka_2.12-2.1.0
./bin/windows/zookeeper-server-start.bat config/zookeeper.properties





cd /cygdrive/d/Sreejesh/Installers/kafka_2.12-2.1.0
./bin/windows/kafka-server-start.bat config/server.properties


cd /cygdrive/d/Sreejesh/Installers/kafka_2.12-2.1.0
./bin/windows/kafka-server-start.bat config/server1.properties
cd /cygdrive/d/Sreejesh/Installers/kafka_2.12-2.1.0
./bin/windows/kafka-server-start.bat config/server2.properties
cd /cygdrive/d/Sreejesh/Installers/kafka_2.12-2.1.0
./bin/windows/kafka-server-start.bat config/server3.properties

cd /cygdrive/d/Sreejesh/Installers/kafka_2.12-2.1.0
./bin/windows/kafka-server-stop.bat
kafka-server-stop.bat

./bin/windows/zookeeper-server-stop.bat
zookeeper-server-stop.bat


cd /cygdrive/d/Sreejesh/Installers/kafka_2.12-2.1.0

bin/windows/kafka-topics.bat  --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test-topic

#bin/windows/kafka-console-producer.bat --broker-list localhost:9093,localhost:9094,localhost:9095 --topic my-kafka-topic




bin/windows/kafka-console-producer.bat --broker-list localhost:9092 --topic test-topic
kafka-console-producer.bat --broker-list localhost:9092 --topic test-topic



cd /cygdrive/d/Sreejesh/Installers/kafka_2.12-2.1.0
bin/windows/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic --from-beginning
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic --from-beginning




D:/Sreejesh/Code/Kafdrop-master

cd /cygdrive/d/Sreejesh/Code/Kafdrop-master

java -jar kafdrop-2.0.6.jar --zookeeper.connect=localhost:2181

http://localhost:9000/


https://github.com/skylerto/apache-camel-kafka


ssh controller@192.168.56.107

HPS Virtual MAchine 


HE connectivity
iSOlve request

CamelWorkspace
EnrollmentWorkspace

camel.springboot.main-run-controller=true



cd /cygdrive/d/Sreejesh/Installers/Kafdrop-master
java --add-opens=java.base/sun.nio.ch=ALL-UNNAMED -jar target/kafdrop-3.12.0-SNAPSHOT.jar --kafka.brokerConnect=localhost:9092
https://github.com/obsidiandynamics/kafdrop

mvn spring-boot:run

