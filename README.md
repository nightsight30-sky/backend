CipherSQLStudio – SQL Practice Platform
Overview
CipherSQLStudio is a browser-based SQL learning platform where users can practice SQL queries on pre-configured assignments using real PostgreSQL data. The focus of the project is to provide a safe environment for executing SQL queries and understanding database concepts through hands-on practice.
This project is not a database creation tool. All assignments and sample data are pre-inserted by the administrator. Users only interact with the data by writing and executing SQL queries.

Features
- View list of SQL assignments
- Select an assignment to attempt
- View table schema related to the assignment
- Write and execute SQL queries
- View query results in real time
- Get conceptual hints using an LLM
- Track user query attempts per assignment

Tech Stack

Backend:
- Java
- Spring Boot
- REST APIs (MVC architecture)
- JDBC and JPA (Hibernate)
- PostgreSQL

Frontend:
- HTML
- CSS
- JavaScript

LLM Integration:
- OpenAI / GPT API (used only for hints)

--------------------------------------------------

System Architecture
Frontend communicates with the Spring Boot backend using REST APIs.  
Backend executes SQL queries on PostgreSQL using JDBC.  
Hint requests are forwarded to an external LLM service.

--------------------------------------------------
End-to-End Application Flow
1. User opens the application in the browser.
2. Frontend requests the list of assignments from the backend.
3. Backend fetches assignments from PostgreSQL and returns them.
4. User selects an assignment.
5. Frontend requests schema information for the selected assignment.
6. Backend reads schema details from PostgreSQL and returns them.
7. User writes an SQL query and clicks Execute.
8. Backend validates the query and executes it using JDBC.
9. PostgreSQL returns query results to the backend.
10. Backend sends results back to the frontend.
11. Frontend displays the results.
12. User can request a hint if needed.
13. Backend sends a controlled prompt to the LLM and returns the hint.
14. User query attempts are saved in the database.


Important Design Decisions

- SQL queries are executed directly by PostgreSQL.
- Only read-only SQL queries (SELECT) are allowed.
- LLM is used only for conceptual hints, not for providing SQL solutions.
- Frontend does not directly interact with the database.
- Backend controls validation, execution, and data flow.


How to Run the Project

Backend:
1. Start PostgreSQL.
2. Insert assignment metadata and sample tables manually.
3. Run the Spring Boot application.
4. Backend runs on http://localhost:8080

Frontend:
- Frontend is served as a static file from Spring Boot.
- Open in browser using:
  http://localhost:8080

--------------------------------------------------

Limitations
- No authentication system
- No automatic answer validation
- Basic user interface

These limitations are intentional to keep the project simple and easy to understand.
