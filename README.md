# Car Management System

A Spring Boot application for managing car details, supporting features like CRUD operations, pagination, sorting, and search.

## Features
- Add, update, delete, and retrieve car details.
- Pagination and sorting of car records.
- Search by name, model, or fuel type.

## Technologies Used
- Spring Boot 
- MySQL Database
- Swagger UI for API Documentation
- AWS RDS, EC2, Elastic BeanStalk
- Gradle

## Setup Instructions

1.Deployed Application
   ```bash
   You can access the deployed application here:
   AWS Elastic Beanstalk URL:http://cars1-env.eba-sisie9vb.eu-north-1.elasticbeanstalk.com
   ```
2. Configure the database in application.properties:
   ```bash
   spring.datasource.url=jdbc:mysql://database-1.cz2gs00ku98u.eu-north-1.rds.amazonaws.com:3306/CarManagementSystem
   spring.datasource.username=admin
   spring.datasource.password=#Arifi786
   ```
3. Swagger UI
   ```bash
    URL:http://cars1-env.eba-sisie9vb.eu-north-1.elasticbeanstalk.com/swagger-ui.html