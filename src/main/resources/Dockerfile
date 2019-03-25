FROM docker-registry-default.apps.appcanvas.net/dev-secops-br-staging/experian-centos7-java11:latest

LABEL MANTAINER="Serasa Experian IT Team"

# Environment variable 
ENV SPRING_LOGGING_LEVEL INFO
ENV SPRING_PROFILE deploy
ENV PORT 8080
ENV JVM_XMS 512m
ENV JVM_XMX 1024m

# Add file to image on build
ADD target/*.jar /app/app.jar
ADD app.sh /

RUN chmod 0755 /app.sh

CMD /app.sh

EXPOSE ${PORT}