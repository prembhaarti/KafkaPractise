# Produce message on kafka
http://{url}:{port}/produce/{topic-name}/publish?key=hello&value={msg}
ie.
http://localhost:8080/produce/prem/publish?key=hello&value=love

# Consume message on kafka
http://{url}:{port}/consume/{topic-name}/{group-name}/message
ie.
http://localhost:8080/consume/prem/group-1/message

# metrics
http://localhost:8081/metrics

# threads
http://localhost:8081/threads

# healthcheck
http://localhost:8081/healthcheck

# swagger
http://localhost:8080/swagger

# run gradle
./gradlew clean build

# run jar
java -jar build/libs/KafkaDemo-1.0-SNAPSHOT.jar server config.yml

# running docker service
  sudo docker service start

# building docker file
sudo docker build -f Dockerfile -t java .

# running docker
sudo docker run -p 8080:8080 -p 8081:8081 -it --rm java

# tag dockerFile
sudo docker tag <image-id> <dockerhub-username>/<dockerhub-repository-name>:<tag-name>
sudo docker tag 6809f2395220 lovebharti/practise:kafka-practise

# push docker image
sudo docker push <dockerhub-username>/<dockerhub-repository-name>
sudo docker push lovebharti/practise

# pulling docker images from repository
sudo docker pull <dockerhub-username>/<dockerhub-repository-name>:<tag-name>
sudo docker pull lovebharti/practise:kafka-practise


# Some more examples to learn
https://github.com/LearningJournal/ApacheKafkaTutorials/