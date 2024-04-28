# Requisitos para rodar o projeto

* JDK-22 ou superior
* MySQL - Versão 11.3.2 ou superior

Observação: O projeto foi configurado para ser executado no IDE VS Code. No entanto, você pode adaptá-lo para outras IDEs.

# Configurações necessárias

Para executar o projeto, siga estas configurações:

1- Navegue até o seguinte diretório no repositório:

```shell
src/main/resources/
```

2- Dentro deste diretório, crie um arquivo com o seguinte nome e extensão:

```shell
application.properties
```

3- No arquivo criado, cole o seguinte conteúdo:

  ```shell
  spring.application.name=handmade.atelie.backend

  spring.datasource.url=jdbc:mysql://endereco_do_seu_mysql/porta_do_seu_mysql/handmade_atelie?createDatabaseIfNotExist=true
  spring.datasource.username=seu_usuario
  spring.datasource.password=sua_senha
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  
  spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  ```

4- Modifique o arquivo acima com as seguintes configurações do seu MySQL: endereco_do_seu_mysql, porta_do_seu_mysql, seu_usuario, sua_senha.

Feito isso, o projeto estará pronto para ser executado. Para executa-lo, você deve ir até o seguinte arquivo:

```shell
src/main/java/com/handmade/atelie/backend/Application.java
```

em seguida clique em 'run'.






