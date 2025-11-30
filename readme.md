🚍 RedBus Ticket Booking System – Java JDBC Project

A console-based RedBus-like ticket booking application built using Java, JDBC, and MySQL, following MVC architecture with a modular package structure.

📌 Features
👤 User Features

Search buses by boarding point, dropping point, and date

Filter buses by:

AC / Non-AC

Seat Type (Seater / Sleeper)

Rating (1–5)

Price (High → Low / Low → High)

Book bus seats with:

Passenger name

Gender

Contact number

Automatic seat availability + booking validation

View bus details including available, occupied, and total seats

🛠 Admin Features

Add new buses

Update existing bus details

Delete buses

View all buses

Full CRUD operations via JDBC

🧱 Tech Stack
Component	Technology
Language	Java
Backend	JDBC
Database	MySQL
Architecture	MVC
Packages	controller, service, repository, model, utils
📂 Project Structure
src/
│
├── com.dashboard
│   └── DashBoard.java
│
├── com.redbus.controller
│   └── RedBusController.java
│
├── com.redbus.model
│   └── Bus.java
│
├── com.redbus.repository
│   └── Repository.java
│
├── com.redbus.service
│   └── Service.java
│
├── com.redbus.utils
│   └── Utils.java
│
└── application.properties   (DB Configuration)

🗄️ Database Table Structure
buses Table
Column	Type
busno	INT (PK)
busname	VARCHAR
totalseats	INT
availseats	INT
occupiedseats	INT
bustype	VARCHAR
seattype	VARCHAR
boardingpoint	VARCHAR
boardingtime	VARCHAR
dropingpoint	VARCHAR
droppingtime	VARCHAR
pricing	DOUBLE
rating	INT
dateofboarding	VARCHAR
🔧 How to Run
1️⃣ Clone the repository
git clone https://github.com/yourusername/RedBus-JDBC.git

2️⃣ Import the project

Open in Eclipse or IntelliJ

Add MySQL JDBC driver to your build path

3️⃣ Configure the database

Edit application.properties:

db.url=jdbc:mysql://localhost:3306/redbus
db.username=root
db.password=yourpassword

4️⃣ Run the application

Run:

DashBoard.java

📊 Application Flowchart
<img width="800" height="1000" alt="RedBus Flowchart" src="https://github.com/user-attachments/assets/3c564eb9-779a-40a6-9426-f609ddf638c2" />

GitHub supports Mermaid syntax.

🎯 Learning Outcomes

JDBC CRUD operations

MVC architecture

OOP concepts (Encapsulation, Abstraction)

Handling user input with Scanner

Modular, layered architecture

Real-world bus booking system logic

🤝 Contributing

Feel free to fork this project and enhance features like:

User login & authentication

Payment gateway simulation

GUI version using JavaFX

REST API version using Spring Boot

📜 License

This project is open-source under the MIT License.
