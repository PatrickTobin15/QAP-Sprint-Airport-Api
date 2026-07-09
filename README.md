# Airport API

This is the API half of my Sprint Week 1 project. It's a Spring Boot app backed by MySQL that manages
Cities, Airports, Passengers, and Aircraft, and answers four specific questions about how they relate to
each other.

## Tech Stack
- Java 17
- Spring Boot 3.2.5 with Spring Web + Spring Data JPA
- MySQL
- Maven

## Data Model

| Entity | Fields |
|---|---|
| City | id, name, state, population |
| Passenger | id, firstName, lastName, phoneNumber |
| Airport | id, name, code |
| Aircraft | id, type, airlineName, numberOfPassengers |

**Relationships:**
- A City has many Airports (Airport → City is a many to one)
- A Passenger lives in one City (many to one) and can fly on many Aircraft (many to many)
- An Aircraft can carry many Passengers and operate out of many Airports (many to many)

## Setup

1. Make sure MySQL is running locally.
2. Update `src/main/resources/application.properties` with your MySQL username/password.
3. Run it:
   ```
   mvn spring-boot:run
   ```
4. The API will start on `http://localhost:8080`.

## Endpoints

### Standard CRUD (all four entities)
- `GET /api/cities`, `GET /api/cities/{id}`, `POST /api/cities`, `PUT /api/cities/{id}`, `DELETE /api/cities/{id}`
- `GET /api/airports`, `GET /api/airports/{id}`, `POST /api/airports`, `PUT /api/airports/{id}`, `DELETE /api/airports/{id}`
- `GET /api/passengers`, `GET /api/passengers/{id}`, `POST /api/passengers`, `PUT /api/passengers/{id}`, `DELETE /api/passengers/{id}`
- `GET /api/aircraft`, `GET /api/aircraft/{id}`, `POST /api/aircraft`, `PUT /api/aircraft/{id}`, `DELETE /api/aircraft/{id}`

### The Four Questions
- `GET /api/cities/airports-summary` → What airports are in each city?
- `GET /api/passengers/aircraft-summary` → What aircraft has each passenger flown on?
- `GET /api/aircraft/airports-summary` → What airports does each aircraft take off from and land at?
- `GET /api/airports/used-by-passengers` → What airports have passengers used?

### Pagination & Sorting
`GET /api/passengers` supports pagination and sorting through query params, e.g.:
```
GET /api/passengers?page=0&size=5&sort=lastName,asc
```
- `page` — which page to return (0-indexed)
- `size` — how many results per page
- `sort` — field name, plus `asc` or `desc`

This returns a `Page<Passenger>` instead of a plain list, which includes metadata like total pages and
total elements alongside the actual content.

## Notes on the data model
I kept the entity relationships one directional where I could (e.g. Airport points to City, not the other
way around) instead of making everything bidirectional. It avoids any infinite loops when Jackson serializes
the JSON responses, and I don't need to reverse the direction for anything the assignment asks for I can
always "give me all airports for this city" through the repository instead of doing an in memory
collection.

## Testing
This is mainly tested using postman which is hitting each CRUD endpoint plus the four summary endpoints and the
pagination example above.
