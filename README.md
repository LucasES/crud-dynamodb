# crud-dynamodb

CRUD de pessoas utilizando dynamo db
## Sobre

Este projeto tem como objetivo criar um CRUD utilizando Spring Boot e DynamoDB com localstack.


## Criado com

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[H2](https://www.h2database.com/html/main.html) - Relational Database Management System
* 	[spring-data-dynamodb](https://github.com/derjust/spring-data-dynamodb) - Sring data dynamodb dependency 
* 	[Lombok](https://projectlombok.org/) - Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.
* 	[Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

## Ferramentas externas

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/download) - Java IDEA

### Pré-requisitos

Para instalar e executar a API é preciso instalar:

- [JDK 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org)
- [GIT](https://git-scm.com/downloads)
- [localstack](https://github.com/localstack/localstack)

## Clonando o projeto

Primeiramente, devemos realizar o clone do projeto através do comando:

```sh
git clone https://github.com/LucasES/crud-dynamodb.git
```

Ou acessar a URL: https://github.com/LucasES/crud-dynamodb e realizar o download do projeto no formato zip e realizar a extração do arquivo.

## Configurando o localstack e o DynamoDB
Primeiramente precisamos configurar o localstack em nossa máquina.
Para esse passo, recomendo a leitura desse link: [tutorial de instalação](https://reflectoring.io/aws-localstack/) 

Com o localstack instalado corretamente devemos executar o comando no terminal:

```sh
localstack start
```

### Criando as tabelas no DynamoDB
Por default o localstack realiza a exposição do DynamoDB na URL: http://localhost:4566

Antes de testar o projeto devemos criar a tabela no DynamoDB do LocalStack. Para isso, <b>acesse a raiz do projeto pelo terminal</b> e execute o seguinte código:

```sh
aws dynamodb create-table --cli-input-json file://person_table.json --endpoint-url=http://localhost:4566 
```

O trecho de código acima irá criar a tabela de Person que iremos utilizar no CRUD do projeto.
Para verificar se o comando acima funcionou podemos listar as tabelas do localstack através do seguinte comando:
 
```sh
aws dynamodb list-tables --endpoint-url=http://localhost:4566 
```

## Executando a aplicação local

Existem várias maneiras de executar um aplicativo Spring Boot em sua máquina local. Uma maneira é executar o método `main` na classe `com.cruddynamodb.CrudDynamodbApplication` do IDE.

Como alternativa, você pode usar o [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) e executar o seguinte comando na pasta do projeto onde localiza-se o arquivo pom.xml:

```shell
mvn spring-boot:run
```

### Swagger

A documentação da API poderá ser acessada após a execução do projeto na seguinte URL:

```sh
http://localhost:8085/api/swagger-ui/index.html#/
```
 
 ## Arquivos e diretórios
 
 O projeto `crud-dynamodb` possui uma estrutura de diretórios específica. 
 
 Um projeto representativo é representado abaixo:
 
 ```
 .
 ├── Spring Elements
 ├── src
 │   └── main
 │       └── java
 │           ├── com.cruddynamodb.CrudDynamodbApplication
 │           ├── com.cruddynamodb.config
 │           ├── com.cruddynamodb.controller
 │           ├── com.cruddynamodb.dto
 │           ├── com.cruddynamodb.enums
 │           └── com.cruddynamodb.exception
 │           └── com.cruddynamodb.handler
 │           └── com.cruddynamodb.model
 │           └── com.cruddynamodb.repository
 │           └── com.cruddynamodb.service
 ├── src
 │   └── main
 │       └── resources
 │           ├── application.properties
 ├── src
 │   └── test
 │       └── java
 ├── JRE System Library
 ├── Maven Dependencies
 ├── bin
 ├── src
 ├── target
 │   └──crud-dynamodb-0.0.1-SNAPSHOT.jar
 ├── mvnw
 ├── mvnw.cmd
 ├── pom.xml
 └── README.md
 ```
## Pacotes

- `config` — Pacote responsável em centralizar as configurações do projeto.
- `controller` — Camada responsável em externalizar as API's;
- `dto` — Camada responsável em externalizar as classes de Data Transfer Object.
- `enums` — Camada responsável em externalizar Enums do projeto.
- `exception` — Pacote responsável em centralizar as classes de POJO para mapear objeto de resposta utilizados no Exception Handler.
- `handler` — Pacote responsável em centralizar as classes que manipulam o exception handler do projeto.
- `model` — Camada de modelo responsável em centralizar as entidades do projeto;
- `repository` — Camada responsável para se comunicar com o banco de dados;
- `service` — Camada responsável em centralizar a lógica de negócio do sistema;
- `resources/` - Contém todos os recursos estáticos, modelos e arquivos de propriedades.
- `resources/application.properties` - Ele contém propriedades para todo o aplicativo. O Spring lê as propriedades definidas neste arquivo para configurar seu aplicativo. Você pode definir a porta padrão do servidor, o caminho de contexto do servidor, os URLs do banco de dados etc., neste arquivo.

- `test/` - centraliza os testes unitários do projeto

- `pom.xml` - arquivo responsável em centralizar as dependências do projeto.
## Contribuição

Por favor, leia [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) para obter detalhes sobre nosso código de conduta e o processo de envio de solicitações pull requests.

## Autores

* **Lucas Araújo** - *projeto inicial* - [LucasES](https://github.com/LucasES)

## Licença

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details