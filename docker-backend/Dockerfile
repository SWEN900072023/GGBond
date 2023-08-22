FROM maven:3

ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH
RUN mkdir -p "$CATALINA_HOME"
WORKDIR $CATALINA_HOME

COPY apache-tomcat-10.1.12.tar.gz .

RUN set -x \
    && tar -xvf apache-tomcat-10.1.12.tar.gz --strip-components=1 \
    && rm bin/*.bat \
    && rm apache-tomcat-10.1.12.tar.gz*


ENV DEPLOY_DIR /usr/local/tomcat/webapps
ENV WAR_FILE MusicEventSystem-1.0-SNAPSHOT.war

WORKDIR $CATALINA_HOME

EXPOSE 8080

COPY $WAR_FILE $DEPLOY_DIR/

CMD ["catalina.sh", "run"]