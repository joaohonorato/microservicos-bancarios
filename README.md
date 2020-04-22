# Microservicos Bancários

Foobar is a Python library for dealing with word pluralization.

## Instalção

#### Docker + Maven:

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

## License
[MIT](https://choosealicense.com/licenses/mit/)