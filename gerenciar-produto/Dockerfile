FROM java:openjdk-8u111-alpine
ARG JAR_FILE=target/*.jar
ARG JAVA_OPTS="-XX:PermSize=1024m -XX:MaxPermSize=512m"
RUN apk --no-cache add curl
RUN curl -OL https://raw.githubusercontent.com/mrako/wait-for/master/wait-for && chmod +x wait-for
CMD     ./wait-for -t 300 $EUREKA_HOST:$EUREKA_PORT -- \
        ./wait-for -t 300 $DB_HOST:$DB_PORT -- \
        echo "All dependencies ready. Starting application..." && \
        java ${JAVA_OPTS} -jar gerenciar-produto.jar
COPY ${JAR_FILE} gerenciar-produto.jar