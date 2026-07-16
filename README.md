# Workshop Spring Boot MongoDB

![Java](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1-6DB33F?logo=springboot&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-Database-47A248?logo=mongodb&logoColor=white)

REST API for managing users and their posts, built with Spring Boot and MongoDB.

This study project was developed during Nelio Alves' Java course. In addition to the course content, I added and refined parts of the implementation, including combined post search, strict date validation, UTC date boundaries, and consistent HTTP error responses.

## Features

- User CRUD operations
- Posts associated with users
- Embedded author and comment data
- Post lookup by ID
- Case-insensitive title search using a custom MongoDB query
- Combined search by title, body, comments, and date range
- Validation of query dates in `yyyy-MM-dd` format
- Centralized `400 Bad Request` and `404 Not Found` responses
- Automatic sample-data initialization

## Technologies

- Java 21
- Spring Boot 4.1
- Spring Web MVC
- Spring Data MongoDB
- Maven
- MongoDB

## Main endpoints

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/users` | List users |
| `GET` | `/users/{id}` | Find a user by ID |
| `POST` | `/users` | Create a user |
| `PUT` | `/users/{id}` | Update a user |
| `DELETE` | `/users/{id}` | Delete a user |
| `GET` | `/users/{id}/posts` | List posts from a user |
| `GET` | `/posts` | List posts |
| `GET` | `/posts/{id}` | Find a post by ID |
| `GET` | `/posts/titlesearch?text=mission` | Search posts by title |
| `GET` | `/posts/fullsearch?text=mission&minDate=2025-01-01&maxDate=2026-12-31` | Search by text and date range |

The full search checks the post title, body, and comment text. Both date parameters are optional; invalid dates return `400 Bad Request`.

## Running locally

### Requirements

- Java 21
- Maven 3.9+
- MongoDB available at `localhost:27017`

Start MongoDB locally or with Docker:

```bash
docker run --name workshop-mongo -p 27017:27017 -d mongo
```

Then run the application:

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

> [!IMPORTANT]
> This project uses sample-data initialization for study purposes. The `user` and `post` collections are cleared and recreated whenever the application starts.

## Tests

```bash
mvn test
```

## Project context

The project documents my progress learning REST APIs and document-oriented databases with Spring Boot. Its commit history follows the implementation incrementally, from the first MongoDB connection and CRUD endpoints to relationships, DTO projections, comments, exception handling, and advanced searches.
