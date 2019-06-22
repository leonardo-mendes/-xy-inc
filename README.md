## Point of Interest Project [![Build Status](https://travis-ci.org/leonardo-mendes/-xy-inc.svg?branch=master)](https://travis-ci.org/leonardo-mendes/-xy-inc)

#### Ferramentas necessárias
- Java 8.
- Docker-compose.
- Maven.

#### Instruções para execução do projeto
- Clonar [repositório](https://github.com/leonardo-mendes/-xy-inc).
- Entrar no folder do projeto.
- Executar o script abaixo.

```
sh initChallenge.sh - Obs: Checar se o container zup_xyinc esta executando (docker ps).
```


A aplicação default (*profile application-test.properties*) está configurada para rodar no **database H2** (DBMS), então não é necessário configurar banco de dados.

> H2 is a **relational database** management system written in **Java**. It can be embedded in Java applications or run in the **client-server mode**.


#### EndPoints

A documentação da API está feita no swagger, com o container rodando acessar:

```
http://172.32.0.101:8080/swagger-ui.html
```
