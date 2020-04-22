#Gerenciar Conta
Para buildar o projeto pode-se provisionar o mysql via docker com o seguinte comando:

1) Inciar mysql com docker:
   ```
   docker run --name mysql-conta -p 3307:3306 -e MYSQL_PASSWORD=conta -e MYSQL_USER=gerenciador -e MYSQL_ROOT_PASSWORD=gerenciador -e MYSQL_DATABASE=gerenciar-conta -d mysql/mysql-server:5.7
   ```
   [OPICIONAL] Mapear volume:  -v /C/data/conta:/var/lib/mysql
2) Gerando Jar
   ```
    mvn clean package
    ou
    mvn clean install
   ```
3) Gerando Imagem docker do serviço
    ```
    docker build -t gerenciar-conta .
   ```
4) Rodar o container passando variáveis pertinentes
    ```
    docker run -e 8082 --env EUREKA_HOST=192.168.99.100 --env EUREKA_PORT=8761 --env DB_HOST=192.168.99.100 --env DB_PORT=3307 gerenciar-conta
   ```
