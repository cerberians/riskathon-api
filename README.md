# riskathon-api

## Run the API and the database

The API is a Spring Boot Application and the database is Neo4j.

There is a docker-compose.yml to run the API and the database together.

```bash
docker-compose --file docker-compose.yml down
docker-compose --file docker-compose.yml up --build --detach
```

To launch just the database you can run the following command:

```bash
docker-compose --file docker-compose-local.yml down
docker-compose --file docker-compose-local.yml up --build --detach
```