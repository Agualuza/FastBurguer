# FastBurguer

## Installation and Development

## Start FastBurguer-Api on Docker
Go to workspace root and run commands:

**1.** Build Application
 ```bash
 Create Enviroment variable MYSQL_SECRET with your local mysql password
 ```
**2.** build java app
 ```bash
 mvn clean package
 ```

**3.** Build and Up Container
 ```bash
 docker compose up --build -d
 ```