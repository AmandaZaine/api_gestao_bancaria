## API REST Gestão Bancária

Essa aplicação backend permite:
* criar uma nova conta
* buscar uma conta existente
* realização de transações do tipo pix
* realização de transações do tipo crédito
* realização de transações do tipo débito

### Tecnologias usadas:
* Java 21
* Apache Maven
* Spring Boot 3.4.2
* Spring Data JPA
* Spring Web
* PostgreSQL
* Docker
* Junit
* Mockito

### Padrões usados:
* Strategy
* DTO
* MVC
* REST

### Instalação:
Para rodar localmente a aplicação é necessário que você tenha Docker, Docker Compose e o Postman instalados na sua máquina.
Garanta que tenha instalado o necessário e execute os passos a seguir:

1. Clone esse repositório:
```
git clone https://github.com/AmandaZaine/api_gestao_bancaria.git
```

2. Abra um novo terminal e navegue até o diretório raiz do repositório clonado.


3. Execute o comando a seguir para iniciar os containers e executar a aplicação:
```
docker compose -f ./docker-compose.yml up
```

4. Este comando pode levar algum tempo para ser concluído, pois ele precisa baixar todas as dependências necessárias e construir o projeto. 


5. Depois de concluído, você pode acessar a aplicação através do Postman:
   6. Exemplo de como criar uma nova conta: 
   
   ```
   Método HTTP: POST 
   URL: localhost:8080/conta
   BODY:
   {
    "numero_conta": 3333,
    "saldo": 50
    }
   ```
   7. Exemplo de como buscar uma conta:
   ```
   Método HTTP: GET
   URL: localhost:8080/conta?numero_conta=3333
   ```
   8. Exemplo de como fazer uma transação:
   
    As opções para a realização de transações são:
    * P - para transação do tipo pix
    * C - para transação do tipo crédito
    * D - para transação do tipo débito
   ```
   Método HTTP: POST 
   URL: localhost:8080/transacao
   BODY: 
   {
    "forma_pagamento":"C", 
    "numero_conta": 3333, 
    "valor": 10
    }
   ```
   












