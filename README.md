# Library Management System

## Description
The Library Management System (LMS) is a console-based application built in Java. It is designed to manage books and users in a library setting. Admin users can add, remove, and list books, while regular users can borrow and return books. This project helps automate the management of library resources, reducing the overhead for library staff.

## Setup Instructions

### Prerequisites
1. **Java Development Kit (JDK)**:
   - Install [JDK 8 or above](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).
   - Set up the `JAVA_HOME` environment variable.

2. **IDE or Text Editor**:
   - Use any Java IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor (e.g., VS Code).

### Running the Project
1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/yourusername/LibraryManagementSystem.git
   cd LibraryManagementSystem
Compile and run the Java files:

bash
Copy
javac src/*.java
java src.LibraryApp
Follow the on-screen prompts for logging in and interacting with the system.

Features
Admin Features:
Add, remove, and list books.

Admin authentication for secure access.

User Features:
Borrow books if available.

Return borrowed books.

List available books.

Exception Handling:
Custom exceptions like BookNotFoundException are thrown when a user tries to borrow a non-existent or unavailable book.

Java Concepts Used
Classes & Objects: The Book, User, and LibraryService classes represent the main entities in the system.

Packages: The project is organized into model, repository, service, and exception packages for better modularity.

Exception Handling: The system handles scenarios like borrowing or removing a non-existent book using custom exceptions.

Collections: ArrayList is used to store books and users dynamically.

Scanner: The Scanner class is used for reading user input from the console.

Sample Console Output
1. Login and Admin Menu
mathematica
Copy
Welcome to the Library Management System
1. Login
2. Exit
1
Username: admin
Password: admin123
Welcome admin

Admin Menu:
1. Add Book
2. Remove Book
3. List Books
4. Log Out
1
Enter Book Title: Java Fundamentals
Enter Author: John Smith
Enter ISBN: 112233
Book added successfully.
2. Borrowing a Book
mathematica
Copy
User Menu:
1. Borrow Book
2. Return Book
3. List Books
4. Log Out
1
Enter ISBN of the book you want to borrow: 112233
Book borrowed: Java Fundamentals
3. Removing a Non-Existent Book
mathematica
Copy
Admin Menu:
1. Add Book
2. Remove Book
3. List Books
4. Log Out
2
Enter Book ISBN to remove: 99999
Book with ISBN 99999 not found.
Future Improvements
Database Integration: Integrate a relational database (MySQL, SQLite) to persist book and user data.

Graphical User Interface (GUI): Implement a GUI using JavaFX to provide a user-friendly interface.

Multiple Libraries: Extend the system to handle multiple libraries and branches.

Due Dates & Late Fees: Implement due dates for borrowed books and calculate late fees for overdue books.
