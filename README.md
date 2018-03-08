## Point of Interest Project
Repositório do projeto: -> [https://github.com/leonardo-mendes/xy-inc.git](https://github.com/leonardo-mendes/xy-inc.git)

### Instruções para execução do projeto
- Clonar repositório.
- Importar o repositório no SpringBoot.
- Aguardar o build do projeto.
- Run As > Spring Boot App
- Testar Endpoints.

A aplicação default (*profile application-test.properties*) está configurada para rodar no **database H2** (DBMS), então não é necessário configurar banco de dados.

> H2 is a **relational database** management system written in **Java**. It can be embedded in Java applications or run in the **client-server mode**.

A aplicação também foi implementada no database MySQL porem é necessário a **criação do database** e as configurações abaixo no arquivo *application-dev.properties*:

```
spring.datasource.url=jdbc:mysql://localhost:{seu_ip}/{nome_do_seu_banco}
```

Para continuar a execução no *profile dev* deve-se executar **mvn install** e rodar aplicação.


#### EndPoints

Serviço para listar todos os POI's cadastrados.
```
GET - http://localhost:8080/points
```

Serviço para listar os POI's por proximidade.
```
GET - http://localhost:8080/points/findByCoordenates?x=20&y=10&distance=10
```

Serviço para cadastrar um POI com 3 atributos.
```
POST - http://localhost:8080/points
```

```
Exemplo JSON: {"name": "PointTest", "x": 30, "y": 30}
```

### Instruções para as execuções de testes

Os testes foram implementados e segregados em duas categorias: **features** e **units**.

>Features: São os testes dos recursos utilizados nos "controllers" da aplicação (testes dos endpoints implementados).

Executar a classe *PointOfInterestFeaturesTests* via **JUnit** ou executar comando mvn install/package(mvn test) 


>Units: São os testes dos serviços utilizados na aplicação (testes das classes de serviço).

Executar a classe *PointOfInterestUnitsTests* via **JUnit** ou executar comando mvn install/package(mvn test) 
