#Gerenciar Pessoa
Para buildar o projeto pode-se provisionar o mysql via docker com o seguinte comando:

1) Inciar mysql com docker:
   ```
   docker run --name mysql-pessoa -p 3306:3306 -e MYSQL_PASSWORD=pessoa -e MYSQL_USER=gerenciador -e MYSQL_ROOT_PASSWORD=gerenciador -e MYSQL_DATABASE=gerenciar-pessoa -d mysql/mysql-server:5.7
   ```
   [OPICIONAL] Mapear volume:  -v /C/data/pessoa:/var/lib/mysql
2) Gerando Jar
   ```
    mvn clean package
    ou
    mvn clean install
   ```
3) Gerando Imagem docker do serviço
    ```
    docker build -t gerenciar-pessoa .
   ```
4) Rodar o container passando variáveis pertinentes
    ```
    docker run -e 8081 --env EUREKA_HOST=192.168.99.100 --env EUREKA_PORT=8761 --env DB_HOST=192.168.99.100 --env DB_PORT=3306 gerenciar-pessoa
   ```
