# Requisitos para rodar o projeto

1- JDK-22
2- Mysql - 11.3.2 ou superior

Observação: O projeto foi configurado para ser executado na IDE VsCode, porém você pode adapta-lo para outras IDEs.

# Configurações necessárias

Para executar o projeto, primeiramente você precisa fazer a seguinte configuração:

1- Navegue no repositório até o segunte diretório: src/main/resources/

2- Dentro deste diretório você deve criar um arquivo com o seguinte nome e exetensão: application.properties

3- No arquivo que você criou, você deve colar o seguinte conteúdo

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


Observação: Lembre de alterar o conteudo do arquivo dependendo da configuração do seu Mysql.
