### redis 설치

**docker-compose.yml**

```
version: '3.7'
services:
    redis:
      container_name: redis
      hostname: redis6379
      network_mode: "host"
      image: redis:latest
      command: redis-server
      volumes:
        - "/hdd/apps/redis/data:/data"
      labels:
        - "name=redis"
        - "mode=standalone"
      ports:
        - 6379:6379

```


<br><br>


jdk17,  gradle 8.x

본인 redis 환경에 맞게 **application.yml** 설정

```
server:
  port: 8081

spring:
  data:
    redis:
      host: 192.168.0.190
      port: 6379
```



**build**

```
./gradlew clean build
```
<br>
**실행**

```
java -jar redis-demo.jar
```
<br>


```
POST http://localhost:8081/notice


body
{
 value test
}
```

```
GET http://localhost:8081/notice
```





