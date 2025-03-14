# Ecommerce-App Repository

This repository contains two projects:
1. **Ecommerce API** - Backend application built with Spring Boot.
2. **Ecommerce Frontend** - Frontend application developed using Angular.

## Ecommerce API
The eCommerce API provides the backend services for user management, product management, and shopping cart functionalities. It includes full CRUD (Create, Read, Update, Delete) operations for users, products, and carts.

### Technologies Used
- **Spring Boot** - Backend framework
- **Spring Data** - Database interaction
- **Spring Security** - Authentication 
- **MapStruct** - Object mapping
- **Swagger Documentation** - API documentation

### API Documentation
You can access the API documentation via Swagger at:
[Swagger API Documentation](https://app.swaggerhub.com/apis/salmaabdallah-722/ecommerceApi/2.0)

## Ecommerce Frontend
The eCommerce Frontend is built using Angular and serves as the UI for users to interact with the eCommerce platform.

### Features
- User authentication and management
- Product listing 
- Shopping cart functionality

## Getting Started
### Clone the Repository
```bash
git clone https://github.com/your-repo/ecommerce-app.git
```

### Running the Backend (eCommerce API)
1. Navigate to the API project folder.
```bash
cd ecommerceApi
```
2. Build and run the Spring Boot application.
```bash
mvn spring-boot:run
```
3. Access the API via `http://localhost:7070`.

### Running the Frontend (Ecommerce Frontend)
1. Navigate to the frontend project folder.
```bash
cd ecommerce-frontend
```
2. Install dependencies and start the Angular app.
```bash
npm install
ng serve
```
3. Open `http://localhost:4200` in your browser.



