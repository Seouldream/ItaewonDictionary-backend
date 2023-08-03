FROM eclipse-temurin:17

WORKDIR /u/myapp

COPY ./*.jar .

CMD java -Dserver.port=8000 -Dspring.profiles.active=production -jar *.jar