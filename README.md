# Omnify Blog

A full-stack blogging platform where users can sign up, log in, and create blogs.  
Built with **React (frontend)** and **Spring Boot (backend)**, deployed on a cloud platform.

---

## Table of Contents

- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Architecture](#architecture)  
- [Installation](#installation)  
- [Usage](#usage)  
- [API Endpoints](#api-endpoints)  
- [Deployment](#deployment)  
- [Contributing](#contributing)  

---

## Features

- **User Authentication**: Signup/Login with email & password (JWT-based).  
- **Blog Management**: Authenticated users can create, edit, delete blogs.  
- **Public Access**: Anyone can view blogs and blog details without login.  
- **Pagination**: Blog listing page supports pagination for large datasets.  
- **Responsive Design**: Works on desktop and mobile devices.  
- **Role-based Control**: Only blog authors can edit or delete their blogs.  

---

## Tech Stack

- **Frontend**: React.js, React Router, Axios, Tailwind/MUI  
- **Backend**: Spring Boot (REST APIs), Spring Security (JWT)  
- **Database**: MySQL 
- **Authentication**: JWT  
- **Deployment**: AWS / GCP / Azure  

---

## Architecture

- **Frontend**: React handles routing, API calls, and UI state.  
- **Backend**: Spring Boot provides secure APIs, authentication, and data persistence.  
- **Database**: SQL-based storage for users and blogs.  
- **Authentication**: JWT ensures stateless, secure sessions.  

---

## Installation

### Prerequisites
- JDK 11+  
- Maven  
- npm  
- MySQL 

### Backend Setup
```bash
git clone https://github.com/harshk1010/Omnify-Blog.git
cd Omnify-Blog/backend

CREATE DATABASE omnify_blog;


spring.datasource.url=jdbc:mysql://localhost:3306/omnify_blog
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=your_secret_key


./mvnw clean install
./mvnw spring-boot:run


```
### Frontend Setup

cd Omnify-Blog/frontend/Omnify


REACT_APP_API_BASE_URL=http://localhost:8080/api

npm install

PI Endpoints
Authentication

POST /api/auth/signup → Register a new user

POST /api/auth/login → Authenticate and get JWT

Blogs

GET /api/blogs → Get all blogs (with pagination)

GET /api/blogs/{id} → Get blog details

POST /api/blogs → Create a new blog (requires JWT)

PUT /api/blogs/{id} → Update a blog (author only)

DELETE /api/blogs/{id} → Delete a blog (author only)



