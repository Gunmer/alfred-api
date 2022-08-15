# Alfred API

## About

## Getting Started

> All commits in this project comply with the [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) specification.

### Prerequisites

You must be had installed:
- JDK 17

### Installation

1. Clone the repo
    ```sh
    git clone https://github.com/Gunmer/alfred-api.git
    ```
2. Build project
    ```sh
    ./gradlew build
    ```
### Run
To run the project should execute

```sh
./gradlew bootRun --args='--spring.profiles.active=local'
```

These command startup the API in the port ```8080``` and with the context-path: ```/alfred-api```. To ensure that API has been raised, we can call the health endpoint:
```sh
curl --request GET --url 'http://localhost:8080/alfred-api/actuator/health'
```

#### Profiles
- **local**: To run in localhost with a h2 database in memory
- **dev**: Coming soon
- **prod**: Coming soon

### Testing
This API has 3 types of tests, although by default all of them run.
```sh
./gradle test
```

#### Unit Test
```sh
./gradle test -Dtags='UnitTest'
```

#### Functional test
```sh
./gradle test -Dtags='FunctionalTest'
```

#### Architecture test
Coming soon

