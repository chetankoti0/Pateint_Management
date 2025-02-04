Hospital Patient Management System

📌 Overview

The Hospital Patient Management System is a Java-based application that helps manage patient records efficiently. 
It integrates JDBC with an SQL database to store, retrieve, update, and delete patient details. 
The system also utilizes linked lists for optimized data management.

🛠 Features :

🏥 Add new patients with complete details.

🔍 Search for patients using their unique ID.

📋 Display all patients stored in the database.

❌ Delete patients using their ID.

📡 SQL Database Integration using JDBC.



🚀 Tech Stack

Java

JDBC (Java Database Connectivity)

MySQL

Linked Lists (for efficient in-memory operations)



📂 Project Structure

📁 HospitalPatientManagementSystem

│── 📄 HospitalPatientManagementSystem.java  # Main application logic

│── 📄 variable.java                          # Patient data model

│── 📄 Node.java                              # Linked list node structure

│── 📄 DatabaseConnection.java                # Database connection utility

│── 📄 README.md                              # Project documentation

│── 📄 SQL_Schema.sql                         # SQL script to create the Patients table



🛠 Setup Instructions

1️⃣ Database Configuration
Create a MySQL database and table using the following script:
CREATE DATABASE HospitalDB;
USE HospitalDB;

CREATE TABLE Patients (
    patientId INT PRIMARY KEY,
    Pname VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    contactNumber VARCHAR(15),
    bloodGroup VARCHAR(5),
    doctorInCharge VARCHAR(100),
    disease VARCHAR(100),
    emergencyNumber VARCHAR(15)
);
Update DatabaseConnection.java with your MySQL credentials.


2️⃣ Run the Application

Compile the Java files
bash
Copy
Edit
javac HospitalPatientManagementSystem.java variable.java Node.java
Run the application
bash
Copy
Edit
java HospitalPatientManagementSystem

📢 Future Improvements
🔄 Implement update patient details functionality.
📊 Add a graphical user interface (GUI) using JavaFX or Swing.
🌐 Develop a web-based version using Spring Boot and React.

You can create a README.md file with this content and upload it to your GitHub repository. Let me know if you need any modifications! 🚀







