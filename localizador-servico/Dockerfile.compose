FROM java:openjdk-8u111-alpine
RUN apk --no-cache add curl
ARG JAR_FILE=localizador-servico/target/*.jar
COPY ${JAR_FILE} eureka.jar
EXPOSE 8761
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /eureka.jar" ]