# Omnify Blog

A full-stack blogging platform that allows users to create, view, and manage blog posts.  
Built with **React (frontend)** and **Spring Boot (backend)**, deployed on the cloud.

---

## 🚀 Features

- **User Authentication**: Signup/Login using email and password.  
- **Blog Management**:
  - Only logged-in users can create, edit, or delete blogs.
  - Each blog has a title and content.
- **Public Access**:
  - Blogs are viewable by everyone (even without login).
  - Blog listing page with pagination.
  - Blog detail page shows full content.
- **Responsive Design**: Works on desktop and mobile devices.
- **Cloud Deployment**: Hosted on [AWS / GCP / Azure] (mention your actual cloud platform).

---

## 📂 Project Structure

Omnify-Blog/
│
├── backend/                     # Spring Boot backend (REST API + Auth + DB)
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/omnify/blog/   # Java source code
│   │   │   │   ├── controller/         # REST controllers
│   │   │   │   ├── model/              # Entities
│   │   │   │   ├── repository/         # Repositories
│   │   │   │   └── service/            # Services
│   │   │   └── resources/
│   │   │       └── application.properties
│   ├── pom.xml                 # Maven config
│   └── README.md
│
├── frontend/Omnify/            # React frontend
│   ├── src/
│   │   ├── components/         # Reusable UI components
│   │   ├── pages/              # Signup, Login, BlogList, BlogDetail, CreateBlog
│   │   ├── services/           # API calls (Axios)
│   │   └── App.js              # Main app entry
│   ├── public/
│   ├── package.json            # Node.js dependencies
│   └── README.md
│
├── .gitignore
├── README.md                   # Main project instructions (this file)
└── LICENSE (if any)




---

## 🛠️ Tech Stack

### Frontend
- **React** (with React Router, Axios, etc.)
- **Tailwind CSS / Material UI** (if used)
- Responsive UI

### Backend
- **Spring Boot**
- **Spring Security + JWT** for authentication
- **JPA / Hibernate** with SQL database (e.g., PostgreSQL/MySQL)

### Deployment
- **Cloud Platform**: [AWS / GCP / Azure]  
- **Database**: Cloud-hosted SQL/NoSQL instance

---

## 🔑 Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/harshk1010/Omnify-Blog.git
cd Omnify-Blog

