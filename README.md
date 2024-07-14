Getting Started
Clone the repository
git clone https://github.com/yourusername/blog-comments-api.git
cd blog-comments-api
Configure the database
Edit src/main/resources/application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/yourdbname
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Build and run the application
mvn clean install
mvn spring-boot:run
Endpoints
GET /comments: Retrieve all comments
GET /comments/{id}: Retrieve a specific comment by ID
POST /comments: Create a new comment
PUT /comments/{id}: Update an existing comment
DELETE /comments/{id}: Delete a comment

API de Comentarios de Blog
Una simple API REST para gestionar comentarios de blogs usando Spring Boot y PostgreSQL.

Requisitos Previos
Java 17
Maven
PostgreSQL
Primeros Pasos
Clonar el repositorio
git clone https://github.com/tuusuario/blog-comments-api.git
cd blog-comments-api
Configurar la base de datos
Edita src/main/resources/application.properties con tus credenciales de PostgreSQL:
spring.datasource.url=jdbc:postgresql://localhost:5432/tubasededatos
spring.datasource.username=tuusuario
spring.datasource.password=tupassword
spring.jpa.hibernate.ddl-auto=update
Construir y ejecutar la aplicación
mvn clean install
mvn spring-boot:run
Acceder a la API
La API estará disponible en http://localhost:8080.

Endpoints
GET /comments: Obtener todos los comentarios
GET /comments/{id}: Obtener un comentario específico por ID
POST /comments: Crear un nuevo comentario
PUT /comments/{id}: Actualizar un comentario existente
DELETE /comments/{id}: Eliminar un comentario
