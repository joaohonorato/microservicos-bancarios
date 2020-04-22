Para buildar o projeto pode-se instanciar o mysql via docker com o seguinte comando:

docker run --name mysql-conta -p 3307:3306 -e MYSQL_PASSWORD=conta -e MYSQL_USER=gerenciador -e MYSQL_ROOT_PASSWORD=gerenciador -e MYSQL_DATABASE=gerenciar-conta -d mysql/mysql-server:5.7


Mapear volume: -v /C/data/conta:/var/lib/mysql
