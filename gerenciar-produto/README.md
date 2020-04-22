Para buildar o projeto pode-se instanciar o mysql via docker com o seguinte comando:

docker run --name mysql-produto -p 3308:3306 -e MYSQL_PASSWORD=produto -e MYSQL_USER=gerenciador -e MYSQL_ROOT_PASSWORD=gerenciador -e MYSQL_DATABASE=gerenciar-produto -d mysql/mysql-server:5.7


Mapear volume:  -v /C/data/produto:/var/lib/mysql
