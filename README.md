# 🚆 Online Chat Application

A real-time one-to-one chat web application built using **Java 17, Spring Boot, Spring Security, MySQL, WebSocket, and Thymeleaf**.  
This application allows users to register, log in, and chat with other users in real time in a secure and responsive environment.

---

## ✨ Features

### 💬 Real-Time Messaging
- Instant one-to-one communication using **Spring WebSocket + STOMP**
- Messages are delivered instantly without page refresh

### 🔐 Secure Authentication
- User registration and login system
- Secured using **Spring Security**
- Password encryption for secure access

### 👤 User Management
- Individual user accounts
- Session-based authentication system

### 🔔 Notifications
- Real-time notifications for new messages
- Alerts for user activities (login/message events)

### 💾 Chat History
- Messages stored in **MySQL database**
- Access previous conversations anytime

### 🎨 Responsive UI
- Built using **Thymeleaf + Bootstrap**
- Mobile-friendly and responsive design

---

## 🛠 Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Security
- Spring WebSocket
- MySQL Database
- Lombok

### Frontend
- Thymeleaf
- HTML, CSS
- Bootstrap
- Font Awesome

### Build Tool
- Maven

---

## ⚙️ Setup Instructions

### 📌 Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL Server

---

### 🚀 Steps to Run Locally

#### 1. Clone the Repository
```bash
git clone https://github.com/YOUR_USERNAME/Online_Chat_App.git
cd Online_Chat_App
---

#### 2. Create MySQL Database

Open MySQL Workbench or command line and create the database:

```sql
CREATE DATABASE chatapp;
Then import the SQL script available in your project:

src/main/resources/static/sql-script/SQLScript.txt

3. Configure Database

Open application.properties file and update your MySQL credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/chatapp
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4. Build the Project

Run the following command in terminal:

mvn clean install
5. Run the Application

Start the Spring Boot application:

mvn spring-boot:run
6. Open in Browser

Once the application starts successfully, open:

http://localhost:8080
📁 Project Structure
src/
 ├── main
 │   ├── java
 │   │   └── com/goldencat/chatapp
 │   │       ├── config
 │   │       ├── controller
 │   │       ├── model
 │   │       ├── repository
 │   │       ├── service
 │   │       └── ChatappApplication.java
 │   ├── resources
 │   │   ├── templates
 │   │   ├── static
 │   │   └── application.properties
 └── test

📌 How It Works
User registers or logs in securely
Spring Security authenticates the user
User enters chat room
WebSocket establishes real-time connection
Messages are exchanged instantly
Messages are stored in MySQL database



## Future Enhancements

- **Profile Management**: Update username, details, or profile picture.
- **Privacy Controls**: Block or restrict messages from others.
- **Message Encryption**: Ensure secure chats with encrypted storage and transmission.
- **Media Sharing**: Share images and files effortlessly in chats.  

