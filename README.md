# Running & Tests

- For running application 
    - `mvn clean install`
    - `docker-compose up -d` 
    - Application will start at port 8080
- For running test, `mvn test`

# Tech Stack
- Spring Boot is used as application framework
- Main data source is MySql
- Java 14 for switch expressions
- Lombok


# API Details


```sh 

POST /api/link/convert-to-deep-link          # Converts link to deep link
POST /api/link/convert-to-web-link          # Converts deep link to link

```
- You can find Postman export for sample requests under `postman` folder 