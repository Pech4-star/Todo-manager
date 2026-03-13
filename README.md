# Todo Manager

A simple **Todo Manager web application** built with **Spring Boot, Thymeleaf, and MySQL** that allows users to manage their daily tasks through a clean web interface.

## Features

* User login page
* Add new todo tasks
* View list of todos
* Delete todos
* Automatically record task creation time
* Clean and responsive UI

---

## Technologies Used

*  Java
*  Spring Boot
*  Spring MVC
*  Spring Data JPA
*  Thymeleaf
*  MySQL
*  Maven
*  IntelliJ IDEA

---

## Project Structure

```
Todo-manager
│
├── src/main/java/com/example/todomanager
│   ├── controller
│   │   └── TodoController.java
│   │
│   ├── model
│   │   ├── Todo.java
│   │   └── User.java
│   │
│   ├── repository
│   │   └── TodoRepository.java
│   │
│   └── TodoManagerApplication.java
│
├── src/main/resources
│   ├── templates
│   │   ├── home.html
│   │   ├── login.html
│   │   └── todos.html
│   │
│   └── application.properties
│
└── pom.xml
```

## Database Structure (ERD)
The app has two main tables:

**User Table**
| Column   | Type         | Description            |
|----------|-------------|------------------------|
| id       | BIGSERIAL   | Primary key            |
| username | VARCHAR(50) | Unique username        |
| password | VARCHAR(255)| Hashed password        |

**TodoItem Table**
| Column       | Type         | Description                  |
|--------------|-------------|------------------------------|
| id           | BIGSERIAL   | Primary key                  |
| title        | VARCHAR(100)| Task title                   |
| description  | TEXT        | Task description (optional)  |
| completed    | BOOLEAN     | Task status                  |
| user_id      | BIGINT      | Foreign key → User(id)       |

**Relationship:** One User → Many TodoItems

---

## Setup & Installation

### Prerequisites
- Java 17+  
- Maven  
- Node.js & npm (if using React frontend)  
- PostgreSQL  

### Backend Setup
1. Clone the repository:  
```bash
git clone <your-github-repo-link>
---

##  Installation

### 1️ Clone the repository

```bash
git clone https://github.com/yourusername/todo-manager.git
```

### 2️ Open the project

Open the project in:

* IntelliJ IDEA
* VS Code

---

### 3️ Configure Database

Edit `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tododb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
```

---

### 4️ Run the Application

Run the Spring Boot application:

```
TodoManagerApplication.java
```

Or using Maven:
- click lifecycle-clean-install-run app

---

## Access the Application

Open browser go to:

```
http://localhost:8080/login
```
railway deployment link: 
https://todo-manager-production-7b35.up.railway.app/
---

## Screens

### Login Page

Simple login interface for accessing the todo manager.

### Todo List Page

* Add new tasks
* View tasks

---

## Future Improvements

* User authentication with Spring Security
* Register new users
* Edit todo tasks
* Mark tasks as completed
* REST API support
* Delete task list

---

Perfect! Here’s a **ready-to-use “Local Setup & Troubleshooting” section** you can add to your `README.md`. I formatted it cleanly so it fits naturally with the rest of your documentation:

---

````markdown
## Local Setup & Troubleshooting

### Running the Backend
1. Make sure **PostgreSQL** is installed and running.
2. Create a database named `tododb`.
3. Update `application.properties` with your DB credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tododb
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
````

4. Run the backend:

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

**Common Issues:**

* **Port already in use:**
  Change the port in `application.properties`:

  ```properties
  server.port=8081
  ```
* **Database connection failed:**

  * Ensure PostgreSQL is running
  * Verify credentials and DB name
* **Dependencies not found:**
  Run `mvn clean install` to download all dependencies

---

### Running the Frontend (React)

1. Navigate to frontend folder:

```bash
cd frontend
```

2. Install dependencies:

```bash
npm install
```

3. Start the frontend:

```bash
npm start
```

**Common Issues:**

* **CORS errors:**
  Add this in Spring Boot backend:

  ```java
  @Configuration
  public class CorsConfig {
      @Bean
      public WebMvcConfigurer corsConfigurer() {
          return new WebMvcConfigurer() {
              @Override
              public void addCorsMappings(CorsRegistry registry) {
                  registry.addMapping("/**").allowedOrigins("http://localhost:3000");
              }
          };
      }
  }
  ```
* **Backend URL mismatch:**
  Ensure frontend API calls point to `http://localhost:8080` (or your backend port)

---

### Login / Authentication Issues

* Passwords must be **hashed** before storing:

  ```java
  String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
  ```
* Verify **sessions** are correctly storing `userId` in `HttpSession`.
* Check that protected endpoints validate the session before returning data.

---

# AI Usage Declaration

This project used AI tools for assistance in the following areas:

- **ChatGPT** was used to:
  - Provide example guidance on project structure for a full-stack ToDo app
  - Suggest some code snippets for Spring Boot, PostgreSQL, and frontend integration
  - Offer advice on deployment to Railway
