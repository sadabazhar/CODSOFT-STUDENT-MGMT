# Student Management System (Java + Oracle + Console UI)

This is a Student Management System built using Java, JDBC, Oracle DB, and a console-based UI. It follows the MVC architecture and uses `.properties` files for DB config and SQL queries.

## 🔧 Technologies Used
- Java (Core)
- Oracle Database
- JDBC
- JavaFX-ready structure
- MVC Architecture
- Console UI (JavaFX coming soon)

## ✅ Features
- Add, View, Search, Update, Delete Students
- Input Validation
- Configurable queries via `properties/`
- Clean code separation using DAO and Controller layers

## 🛠️ Setup Instructions
1. Clone the repo
2. Create Oracle DB table using script below
3. Edit `db.properties` with your Oracle DB credentials
4. Run `MainConsoleUI.java`

## 🗃️ Oracle Table Script

```sql
CREATE TABLE students (
  roll_no VARCHAR2(20) PRIMARY KEY,
  name VARCHAR2(100),
  grade VARCHAR2(10),
  email VARCHAR2(100),
  phone VARCHAR2(20),
  address VARCHAR2(200)
);
