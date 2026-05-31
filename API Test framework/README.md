# RESTful Booker API Test Framework

A scalable API automation framework for the RESTful Booker public API.

## Key Features

- Java 17+ based framework
- Rest Assured for API interaction
- TestNG for execution and reporting
- Jackson for request/response mapping
- Log4j2 for centralized logging
- Allure and Extent Reports support
- GitHub Actions CI pipeline
- Docker execution support
- Environment-driven configuration

## Folder Structure

```
API Test framework/
├── pom.xml
├── Dockerfile
├── .github/workflows/api-test.yml
├── src/main/java/com/api
│   ├── clients
│   ├── config
│   ├── models
│   └── utils
├── src/test/java/com/api
│   ├── base
│   ├── listeners
│   └── tests
└── src/test/resources
    ├── config.properties
    └── testng.xml
```

## Getting Started

### Run locally

```bash
cd "API Test framework"
mvn test
```

### Run in Docker

```bash
docker build -t restful-booker-api-tests "API Test framework"
docker run --rm restful-booker-api-tests
```

### GitHub Actions

The workflow runs on pushes and pull requests to `main`, checking out code, setting up JDK 17, caching Maven dependencies, and executing the test suite.

## Configuration

Update `src/test/resources/config.properties` for different environments or provide system properties:

```bash
mvn test -Dapi.base.url=https://restful-booker.herokuapp.com -Dapi.environment=qa
```

## Design Notes

- `RequestSpecBuilder` centralizes HTTP request configuration.
- `BookingApi` encapsulates RESTful Booker API endpoints.
- `ConfigManager` enables environment-driven configuration with overrides.
- `BookingTests` demonstrates end-to-end test coverage for booking creation and retrieval.

## Interview Talking Points

- Separation of concerns: API clients, models, utilities, and tests.
- Reusable request specifications and environment configuration.
- Extensible structure for new endpoints and authentication flows.
- CI/CD ready with GitHub Actions and Docker support.
