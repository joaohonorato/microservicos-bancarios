# Microservicos Bancários

Foobar is a Python library for dealing with word pluralization.

## Instalação

#### Docker + Maven:

*OBS: Para rodar localmente, ajuste o HOST e PORT do serviços e banco de dados apropriadamente.*

Dentro de cada serviço existe um README.md contendo um comando docker para subir o banco de dados do mesmo, após rodar o comando, gerar o jar do serviço utilizando mvn. 

###### Exemplo:
Provisionar banco mysql para o serviço gerenciar-conta, gerando a imagem mysql-conta

```bash
docker run --name mysql-conta -p 3307:3306 -e MYSQL_PASSWORD=conta -e MYSQL_USER=gerenciador -e MYSQL_ROOT_PASSWORD=gerenciador -e MYSQL_DATABASE=gerenciar-conta -d mysql/mysql-server:5.7
```
- Opcionalmente pode se adicionar um volume para persistência dos dados com -v /conta:/var/lib/mysql

Gerando fat jar do projeto

```bash
mvn package
```

Um jar será gerado na pastar `target` com as propriedades contidas no pom.xml

Para rodar localmente, em cada serviço, após provisionar o banco, executar
```bash
mvn spring-boot:run
```

Para rodar todos os serviços, gerar todos os jar e rodar
```bash
docker-compose up
```

***BUG:*** 

Atualmente os serviços gerenciar-conta e gerenciar-produto não estão se registrando no Localizador de serviço quando utilizado docker-compose up.

Após realizar docker-compose up, usar docker ps para verificar se os containers referente ao gerenciar-conta e gerenciar-produto estão rodando, caso contrário iniciar individulamente os serviços de acordo com seus README, os containers referente ao banco já devem estar rodando.

***CORRECAO TEMPORARIA BUG***

Iniciar os containers individualmente:
1) Provisionar gerenciar-conta
docker run -e 8082 --env EUREKA_HOST=192.168.99.100 --env EUREKA_PORT=8761 --env DB_HOST=192.168.99.100 --env DB_PORT=3307 conta
2) Provisionar gerenciar-produto
docker run -e 8083 --env EUREKA_HOST=192.168.99.100 --env EUREKA_PORT=8761 --env DB_HOST=192.168.99.100 --env DB_PORT=3308 produto

## Validação
Acessar o container do localizador de serviço e garantir que há 3 seviços registrados:
GERENCIAR_PESSOA
GERENCIAR_CONTA
GERENCIAR_PRODUTO

Possíveis endereços do localizador de serviço:
http://192.168.99.100:8761/
http://eureka:8761/

## License
[MIT](https://choosealicense.com/licenses/mit/)