# build stage
FROM maven:3.9-amazoncorretto-17 AS build
WORKDIR /app

COPY . .

RUN mvn clean package -DwarName=MusicEventSystem

# run stage
FROM tomcat:10.1.12-jdk21-openjdk

COPY --from=build /app/target/MusicEventSystem-1.0-SNAPSHOT.war $CATALINA_HOME/webapps/
