Um projeto feito no mergulho SpringBoot da AlgaWorks
Se consiste em um sistema de entrega de pedidos à clientes.
Foi usados o MySQL, as injeção de dependência, padrões MVC e SOLID, faltando apenas testar a API construída.

PARA INICAR, DEVE-SE CRIAR E CONFIGURAR O ARQUIVO "application.properties", DENTRO DA PASTA "resources", da seguinte maneira:
spring.datasource.url=jdbc:mysql://localhost:3306/{nome_do_db)?createDatabaseIfNotExists=true&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.user={usuario_mysql}
spring.datasource.password={senha}
