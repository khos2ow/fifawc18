# Running FIFA World Cup 2018 Prediction Game using docker-compose

There are two options to choose to run `fifawc18` components and services.

- **Base services**
    - nginx
    - app
    - mysql

>```
$: docker-compose -f compose-app.yml up -d
```

- **All services** (base + ELK stack)

    - nginx
    - app
    - mysql
    - elasticsearch
    - logstash
    - kibana

>```
$: docker-compose -f compose-app.yml -f compose-logging.yml up -d
```
