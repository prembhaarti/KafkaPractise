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