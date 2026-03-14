# Abstract Factory Design Pattern – Database Driver System

## Overview
This project demonstrates the **Abstract Factory Design Pattern** by designing a system that supports multiple database providers such as **MySQL** and **MongoDB**.

The system allows the application to create database connections and execute queries without being tightly coupled to a specific database implementation.

---

# Problem Statement

Design a system that supports multiple database providers such as **MySQL** and **MongoDB**.

Each database provider should allow the application to:

- Create a **database connection**
- Execute **queries**

The system should ensure that the correct **connection and query executor are used together** for a given database.

The design should also make it easy to **add support for new databases in the future** without modifying the existing client code.

---

# My Approach

When I started thinking about the problem, my first idea was to create a **single class** that would handle both:

- Database connection
- Query execution

However, I realized that this would violate the **Single Responsibility Principle (SRP)** because connection management and query execution are two different responsibilities.

So I decided to **separate them into two interfaces**:

- `DatabaseConnection`
- `DatabaseQueryExecutor`

Each database would then implement these interfaces.

Example implementations:

- `MysqlDatabaseConnection`
- `MongoDatabaseConnection`
- `MysqlDatabaseQueryExecutor`
- `MongoDatabaseQueryExecutor`

---

# Design Challenge

The main challenge was ensuring that when a database is selected, the correct **pair of objects** is created.

For example:
