# ⚽ Football Manager

**Football Manager is a project designed to manage football teams, players, and transfers**

## ⚙️ Getting Started
### Prerequisites
* Docker installed

### Installation
* Clone the Repository:
  
`git clone https://github.com/syrovyivitalii/footballmanager.git`

`cd .\footballmanager\footballManager\`

### Run the Application

`docker-compose up --build`

## 📄 Usage

### Swagger
* Access the REST API documentation using [Swagger](http://localhost:8080/swagger-ui/index.html#/)

### Postman
* Access the REST API documentation using [Postman](https://www.postman.com/universal-comet-25665/workspace/football-manager-public/collection/20580598-abde953b-a3bd-4161-94be-eb2020316b91?action=share&creator=20580598)

Example endpoints:
- Transfers

  - **GET:** `api/v1/transfers`: fetch all transfers, pageable, with specification
  - **POST:** `api/v1/transfers`: make a transfer
- Teams
  - **GET:** `api/v1/teams/pageable`: fetch all teams, pageable
  - **GET:** `api/v1/teams{teamId}`: fetch team by id
  - **POST:** `api/v1/teams`: add a team
  - **DELETE:** `api/v1/teams/{teamId}`: delete a team
  - **PATCH:** `api/v1/teams/{teamId}`: update team by id
- Players
  - **GET:** `api/v1/players/pageable`: fetch all players, pageable, with specification
  - **POST:** `api/v1/players`: add a player
  - **DELETE:** `api/v1/players/{playerId}`: delete a player
  - **PATCH:** `api/v1/players/{teamId}`: update player by id

## 🛠 Technologies Used

* Java 17
* Maven
* Spring Framework 3
* Hibernate
* Liquibase
* PostgreSQL
* Docker
* REST
