docker-compose up -d

docker ps -a

docker exec -it kafka bash

/opt/kafka/bin/kafka-topics.sh --delete --zookeeper zookeeper --topic dean

/opt/kafka/bin/kafka-topics.sh --create --zookeeper zookeeper --replication-factor 1 --partitions 4 --topic dean
