# FastBurguer

## Installation and Development

## Start FastBurguer-Api on Docker
Go to workspace root and run commands:

**1.** Build Application
 ```bash
mvn clean package
 ```
**2.** Build Docker Image
 ```bash
 docker build -f DockerFile -t fastburguer:latest .
 ```

**3.** Up Container
 ```bash
 docker compose up -d
 ```