# 🌊 SafeWater API

API RESTful desenvolvida com Spring Boot para a disciplina Java Advanced, como parte da Global Solution 2025/1 da FIAP.

## 🎯 Objetivo

Ajudar a população e os órgãos públicos a monitorar áreas de risco de enchentes, receber alertas em tempo real e acessar rotas seguras. Essa API fornece a base de dados para o app mobile da equipe.

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- Banco Oracle
- Swagger (OpenAPI)
- Maven

## 🧩 Estrutura do Projeto

src
├── main
│ ├── java/com/safewater/safewater_api
│ │ ├── controller
│ │ ├── dto
│ │ ├── model
│ │ ├── repository
│ │ └── service
│ └── resources
│ ├── application.properties
└── test


## ▶️ Como Executar

1. Configure o banco de dados Oracle no `application.properties`:

```properties
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/XEPDB1
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

Execute o projeto:
./mvnw spring-boot:run

Acesse o Swagger em:
http://localhost:8080/swagger-ui/index.html

🔐 Autenticação
A API utiliza autenticação via JWT. Para acessar rotas protegidas:

Primeiro faça login usando POST /api/auth/login

Depois, use o token retornado como Bearer Token nas requisições

📁 Endpoints Principais
Método	Endpoint	Descrição
POST	/api/usuarios	Cadastrar novo usuário
POST	/api/auth/login	Autenticar e gerar token
GET	/api/areas	Listar áreas de risco
POST	/api/areas	Criar área de risco
GET	/api/alertas	Listar alertas
POST	/api/alertas	Criar alerta

👥 Equipe
Lívia de Oliveira Lopes – RM: 556281

Henrique Pecora Vieira de Souza – RM: 556612

Santhiago De Gobbi Barros de Souza – RM: 98420

🎥 Vídeos
📽 Demonstração: https://www.youtube.com/watch?v=1ZdkiGBPpzI
🎤 Pitch: https://www.youtube.com/watch?v=Rwtp96gtpyI
