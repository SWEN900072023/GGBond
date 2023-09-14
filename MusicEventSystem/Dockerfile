# build stage
FROM maven:3.9-openjdk-20 AS build
WORKDIR /app

COPY . .

RUN mvn clean package -DwarName=MusicEventSystem

# run stage
FROM tomcat:10.1.13-jre17

COPY --from=build /app/target/MusicEventSystem-1.0-SNAPSHOT.war $CATALINA_HOME/webapps/

CMD ["catalina.sh", "run"]
