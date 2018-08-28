FROM tomcat

MAINTAINER German Abramov <german_abramov@epam.com>

RUN apt-get update && apt-get -y upgrade

WORKDIR /usr/local/tomcat


COPY 180813-studentproject-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/app.war

EXPOSE 8080

CMD /usr/local/tomcat/bin/catalina.sh run

