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

---

### Backend Setup

1. Clone the repository:
```bash
git clone https://github.com/your_username/Omnify-Blog.git
cd Omnify-Blog
```

2. Navigate to the backend directory and build the Spring Boot application:
```bash
cd backend
./mvnw clean install
```

3. Start the backend server:
```bash
./mvnw spring-boot:run
```

## Update the application.properties file in the backend:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/omnify_blog
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
```

### Frontend Setup

1. Navigate to the frontend directory:
```bash
cd Omnify-Blog/frontend/Omnify
```

2. Create a .env file in the frontend root:
```bash
REACT_APP_API_BASE_URL=http://localhost:8080/api
```

3. Install dependencies:
```bash
npm install
```

4. Start the React development server:
```bash
npm start
```
