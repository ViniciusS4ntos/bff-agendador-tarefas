![Java](https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-brightgreen?style=for-the-badge&logo=springboot)
![JWT](https://img.shields.io/badge/JWT-Authentication-red?style=for-the-badge&logo=jsonwebtokens)
![OpenFeign](https://img.shields.io/badge/OpenFeign-Microservices-green?style=for-the-badge)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Containerization-blue?style=for-the-badge&logo=docker)
![Gradle](https://img.shields.io/badge/Gradle-Build_Tool-black?style=for-the-badge&logo=gradle)
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-CI/CD-blue?style=for-the-badge&logo=githubactions)

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:0F2027,50:203A43,100:2C5364&height=220&section=header&text=BFF%20Agendador&fontSize=42&fontColor=ffffff&animation=fadeIn" />
</p>

<p align="center">
  <b>Backend For Frontend (BFF) responsável pela comunicação entre microsserviços do sistema de agendamento.</b>
</p>

<p align="center">
  <img src="https://img.shields.io/github/stars/ViniciusS4ntos/bff-agendador-tarefas?style=social" />
  <img src="https://img.shields.io/github/forks/ViniciusS4ntos/bff-agendador-tarefas?style=social" />
  <img src="https://img.shields.io/github/issues/ViniciusS4ntos/bff-agendador-tarefas" />
</p>

---

# BFF Agendador de Tarefas

**BFF Agendador de Tarefas** é um Backend For Frontend desenvolvido com **Java + Spring Boot** responsável por centralizar e organizar a comunicação entre os microsserviços do sistema de agendamento.

O projeto atua como camada intermediária entre o frontend e os microsserviços, facilitando autenticação, agregação de dados e integração entre APIs.

A aplicação possui autenticação utilizando **JWT**, comunicação entre serviços utilizando **OpenFeign** e suporte para execução via **Docker**.

---

# Tecnologias Utilizadas

- Java 17  
- Spring Boot 3  
- Spring Security  
- JWT (JSON Web Token)  
- OpenFeign  
- PostgreSQL  
- Docker  
- Gradle  
- GitHub Actions  
- Lombok  

---

# Funcionalidades

- Centralização de requisições do frontend  
- Comunicação entre microsserviços  
- Autenticação via JWT  
- Integração com APIs externas  
- Agregação de respostas  
- Tratamento global de exceções  
- Containerização com Docker  
- Pipeline CI/CD  

---

# Pré-requisitos

- Java 17 instalado  
- Docker instalado  
- PostgreSQL configurado  
- Os seguintes microsserviços ativos e rodando:

| Microsserviço | Repositório |
|---|---|
| User-api | https://github.com/ViniciusS4ntos/user-api |
| agendador-tarefas-api | https://github.com/ViniciusS4ntos/agendador-tarefas-api |
| notificacao-api | https://github.com/ViniciusS4ntos/notificacao-api |

> ⚠️ O BFF não funciona de forma isolada. Todos os microsserviços acima precisam estar em execução antes de iniciar esta aplicação.

---

# Rodando o Projeto

## 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/bff-agendador-tarefas.git
cd bff-agendador-tarefas
```

---

## 2. Configure o `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bff_agendador
spring.datasource.username=postgres
spring.datasource.password=123456

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 3. Execute os containers

```bash
docker-compose up --build
```

---

## 4. Rodar manualmente

### Linux/Mac

```bash
./gradlew bootRun
```

### Windows

```bash
gradlew.bat bootRun
```

---

# Arquitetura BFF

O projeto segue o padrão **Backend For Frontend (BFF)**.

Fluxo:

1. Frontend envia requisição para o BFF  
2. O BFF autentica o usuário utilizando JWT  
3. O BFF comunica-se com os microsserviços necessários  
4. Os dados são agregados e retornados ao frontend  

---

# Endpoints Principais

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/auth/login` | Realiza login |
| GET | `/tarefas` | Lista tarefas |
| POST | `/tarefas` | Cria uma tarefa |
| GET | `/usuarios` | Lista usuários |
| GET | `/notificacoes` | Lista notificações |

---

# Estrutura do Projeto

```text
Directory structure:
└── viniciuss4ntos-bff-agendador-tarefas/
    ├── Dockerfile
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    ├── src/
    │   └── main/
    │       ├── java/
    │       │   └── com/
    │       │       └── vinicius/
    │       │           └── bffagendadortarefas/
    │       │               ├── BffAgendadorTarefasApplication.java
    │       │               ├── business/
    │       │               │   ├── CronService.java
    │       │               │   ├── EmailService.java
    │       │               │   ├── TarefasService.java
    │       │               │   ├── UsuarioService.java
    │       │               │   ├── dto/
    │       │               │   │   └── in/
    │       │               │   │       ├── EnderecoDTORequest.java
    │       │               │   │       ├── LoginDTORequest.java
    │       │               │   │       ├── TarefasDTORequest.java
    │       │               │   │       ├── TelefoneDTORequest.java
    │       │               │   │       └── UsuarioDTORequest.java
    │       │               │   └── enums/
    │       │               │       └── StatusNotificacaoEnum.java
    │       │               ├── controller/
    │       │               │   ├── GlobalExceptionHandler.java
    │       │               │   ├── TarefasController.java
    │       │               │   └── UsuarioController.java
    │       │               └── infrastructure/
    │       │                   ├── client/
    │       │                   │   ├── EmailClient.java
    │       │                   │   ├── TarefasClient.java
    │       │                   │   ├── UsuarioClient.java
    │       │                   │   └── config/
    │       │                   │       ├── FeignConfig.java
    │       │                   │       └── FeignError.java
    │       │                   ├── exception/
    │       │                   │   ├── BusinessException.java
    │       │                   │   ├── ConflictException.java
    │       │                   │   ├── InvalidCepException.java
    │       │                   │   ├── ResourceNotFoundException.java
    │       │                   │   └── UnauthorizedException.java
    │       │                   └── security/
    │       │                       └── SecurityConfig.java
    │       └── resources/
    │           └── application.properties
    ├── .github/
    │   └── workflows/
    │       └── maven.yml
    └── .mvn/
        └── wrapper/
            └── maven-wrapper.properties
```

---

# Segurança

O projeto possui:

- Spring Security  
- JWT Authentication  
- Rotas protegidas  
- Controle de autenticação  
- Tratamento global de exceções  

---

# Docker

## Subir containers

```bash
docker-compose up -d
```

## Derrubar containers

```bash
docker-compose down
```

---

# CI/CD

O projeto possui pipeline automatizada utilizando GitHub Actions.

Funcionalidades:

- Build automático  
- Execução de testes  
- Integração contínua  

---

# Autor

Desenvolvido por Edson Vinicius.
