[![josesahad](https://circleci.com/gh/josesahad/metadata-service.svg?style=svg)](https://circleci.com/gh/josesahad/metadata-service)

# Feature Service
Spring Boot Service to expose images metadata.

## API
The REST API exposes the following endpoints:
```
- GET /features
- GET /features/{featureId}
- GET /features/{featureId}/quicklook
```
## Data Management
The dataset is loaded from a json file. There is a default path defined in the _application-local_ profile but it is possible to override it by providing the **data.static.jsonFile** property when running the service (also possible by defining it as an environment variable).

Some considerations regarding data handling:
- The **StaticDatasetAccess** class is in charge of reading the static json file and populating a HashMap (the **data store**). The data is only accessible through this class.
- The data transformation (from JSON to the "model") is done through Jackson with a custom deserializer.
- The **data store** keeps the Feature UUID as the key, and the representation of the Feature (see below) as entry.
- The translation between the model and the Service happens in the **FeatureDTO**.

# Getting Started

## Compiling and running tests

- Run `mvn clean test`

## Running locally

- Run with `mvn spring-boot:run -Dspring.profiles.active=local`

By default, the service will expose in http://localhost:8080.

## Micrometer + Prometheus

- By default, Prometheus monitoring is enabled on http://localhost:8080/actuator/prometheus.
