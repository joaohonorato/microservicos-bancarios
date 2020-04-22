Para buildar o projeto pode-se instanciar o mysql via docker com o seguinte comando:

docker run --name mysql-pessoa -p 3306:3306 -e MYSQL_PASSWORD=pessoa -e MYSQL_USER=gerenciador -e MYSQL_ROOT_PASSWORD=gerenciador -e MYSQL_DATABASE=gerenciar-pessoa -d mysql/mysql-server:5.7


Mapear volume: -v /C/data/pessoa:/var/lib/mysql
