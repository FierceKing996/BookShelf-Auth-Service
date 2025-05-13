# BookLibrary Service

A Spring Boot–based REST API for managing authors and books, secured with JWT authentication.

---

## 📖 Overview

BookLibrary is a standalone backend service that allows clients to:

- Sign up and log in with username/password  
- Issue and validate JSON Web Tokens (JWT) for stateless auth  
- Create, read, and delete Authors and Books  
- Enforce role-based access (default `ROLE_USER`)  
- Provide input validation and global error handling  
- Auto-generate Swagger/OpenAPI documentation

---

## 🚀 Tech Stack

- **Language**: Java 17  
- **Framework**: Spring Boot 3  
  - Spring Web (REST controllers)  
  - Spring Data JPA (Hibernate + PostgreSQL)  
  - Spring Security (JWT + role-based auth)  
  - Spring Validation (bean validation)  
  - Springdoc OpenAPI UI (Swagger)  
- **Database**: PostgreSQL (or in-memory H2 for testing)  
- **Build**: Maven  
- **Authentication**:  
  - BCrypt password hashing  
  - JWTs via [jjwt](https://github.com/jwtk/jjwt)  
    

---



   
