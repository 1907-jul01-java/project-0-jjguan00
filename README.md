# Banking App using Maven and JDBC
## Jackie
This is a banking apps that allow users to transfer, withdrawn, and deposit their money. Admin is allow to destroy accounts in addition to transfer,withdraw and deposit from any accounts.

# User Stories
- [x] List
- [] Each
- [] User
- [] Story

### Tools & APIs
- [x] Java SE 8
- [x] Maven 3
- [x] PostgreSQL 9+
- [x] `java.io` Scanner, BufferedReader/Buffered
- [x] `java.util` Collections API
- [x] `java.sql` JDBC - PreparedStatement, CallableStatement

### Architecture
- [x] Multiple Packages
- [x] Interfaces/Abstract Classes
- [x] OOP - Abstraction, Encapsulation, Inheritance, Polymorphism
- [x] Singleton
- [x] Factory
- [x] SQL Normalization
- [x] PL/pgSQL

### Functionality
- [x] CRUD - Create, Read, Update, Delete
- [x] CLI - command-line args and/or event-driven text menus
- [x] Login - Authentication & Authorization
- [x] Persisting State - Save/Load to file or DB

## Example: The Banking App
- [x] Build the application using Java 8.
- [x] All interaction with the user should be done through the console using the `Scanner` class.
- [x] Customers of the bank should be able to register with a username and password, and apply to open an account.
- [x] Customers should be able to apply for joint accounts.
- [x] Once the account is open, customers should be able to withdraw, deposit, and transfer funds between accounts.
- [x] Employees of the bank should be able to view all of their customers information. This includes:
    - [x] Account information
    - [x] Account balances
- [x] Employees should be able to approve/deny open applications for accounts.
- [x] Bank admins should be able to view and edit all accounts. This includes:
    - [x] Approving/denying accounts
    - [xx] Withdrawing, depositing, transferring from all accounts
    - [] Canceling accounts
- [x] All information should be persisted using text files and serialization.
- [x] Create an SQL script that will create a user in an SQL database and a table schema for storing your bank users and account information.
- [x] Have your bank application connect to your SQL database using JDBC and store all information that way.
- [x] You should use the DAO design pattern for data connectivity.
