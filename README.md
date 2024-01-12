# <> Microservices para cadastro de usuários </>

## O que foi implementado:
- Dois microservices: User e Email;
- Salvamento dos dados dos novos Usuários e Emails cadastrados no sistema;
- Utilização de uma comunicação assíncrona, via menssageria;
- Envio de email para usuários cadastrados;

## Fluxo da aplicação:
O cliente fará uma requisição a API para cadastrar um novo usuário. Nesta requisição o microserviço User é chamado e publica uma mensagem em um canal de mensagem/ broker. Enquanto isso, o microserviço Email estará conectado e esperando a chegada de uma mensagem no broker para consumí-la. Ao consumir as mensagens, o microserviço Email salvará o dado (email) do usuário e enviará um email de boas-vindas ao mesmo.

![Full Flow](https://github.com/RickFernandez/Microservices-Java-e-Spring-Boot-Cadastro-de-usuarios-/assets/89798238/7528ea42-9a2a-4c67-805a-9602d1e3e56b)

## Técnologias utilizadas:
| Técnologia | Para que foi usada     | Link                |
| :-------- | :------- | :------------------------- |
| Java 17 | Linguagem de programação | [Java 17](https://www.oracle.com/br/java/technologies/downloads/#java17) |
| Maven | Gerenciador de dependências | Projeto criado com o [Spring Initializer](https://start.spring.io/) então as dependências Spring foram adicionadas na criação do projeto. |
| Spring Boot | Para iniciar os microservices | ´´ |
| Spring Web | Para criar os end-points | ´´ |
| Spring Data JPA | Para realizar a estrutura com o banco de dados | ´´ |
| Spring Validation | Para fazer validações nos dados da requisição | ´´ |
| Spring AMQP | Para trabalhar com o protocolo de menssageria | ´´ |
| Spring Mail | Para realizar o envio dos emails aos usuários | ´´ |
| PostgreeSQL | Como bando de dados | [Download](https://www.postgresql.org/download/) (Eu utilizo ele através do [Laragon](https://laragon.org/download/index.html)) |
| RabbitMQ | Como broker/ canal de mensagem | [RabbitMQ site](https://rabbitmq.com/) |
| CloudAMQP | Plataforma de cloud utilizada para acessar o RabbitMQ | [CloudAMQP](https://www.cloudamqp.com/?_gl=1*18delaz*_gcl_au*MTQxNDA2ODkzMy4xNzA1MDEwNjg1) |
| SMTP Gmail | Para realizar o envio dos emails |  |


## API

#### Cadastrar usuário

```http
  POST /users
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `string` | **Required**. |
| `email` | `string` | **Required**, **Email**. |



### **Made By** [Henrique Fernandez](https://github.com/RickFernandez)

