# Requisitos para rodar o projeto

* JDK-22 ou superior
* MySQL - Versão 11.3.2 ou superior

Observação: O projeto foi configurado para ser executado no IDE VS Code. No entanto, você pode adaptá-lo para outras IDEs.

# Configurações necessárias

Para executar o projeto, siga estas configurações:

1- Navegue até o seguinte diretório no repositório:

```shell
src/main/
```

2- Dentro deste diretório, crie uma pasta chamada 'resources', e em seguida, crie um arquivo com o seguinte nome e extensão:

```shell
application.properties
```

3- No arquivo criado, cole o seguinte conteúdo:

  ```shell
  # Nome da aplicação Spring Boot
spring.application.name=handmade.atelie.backend

# Configuração do banco de dados MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/handmade_atelie?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=America/Sao_Paulo
spring.datasource.username=root
spring.datasource.password=1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuração do Hibernate/JPA
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.jdbc.time_zone=America/Sao_Paulo

# Configuração do segredo para segurança (exemplo)
atelie.security.secret=handmade.atelie

  ```

Feito isso, o projeto estará pronto para ser executado. Para executa-lo, você deve ir até o seguinte arquivo:

```shell
src/main/java/com/handmade/atelie/backend/Application.java
```

em seguida clique em 'run'.






