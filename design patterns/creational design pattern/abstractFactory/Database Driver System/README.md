# Abstract Factory Design Pattern – Database Driver System

## Overview

This project demonstrates the **Abstract Factory Design Pattern** by designing a system that supports multiple database providers such as **MySQL** and **MongoDB**.

The system allows the application to create database connections and execute queries without being tightly coupled to a specific database implementation.

---

# Problem Statement

Design a system that supports multiple database providers such as **MySQL** and **MongoDB**.

Each database provider should allow the application to:

* Create a **database connection**
* Execute **queries**

The system should ensure that the correct **connection and query executor are used together** for a given database.

The design should also make it easy to **add support for new databases in the future** without modifying the existing client code.

---

# My Approach

When I started thinking about the problem, my first idea was to create a **single class** that would handle both:

* Database connection
* Query execution

However, I realized that this would violate the **Single Responsibility Principle (SRP)** because connection management and query execution are two different responsibilities.

So I decided to **separate them into two interfaces**:

* `DatabaseConnection`
* `DatabaseQueryExecutor`

Each database would then implement these interfaces.

Example implementations:

* `MysqlDatabaseConnection`
* `MongoDatabaseConnection`
* `MysqlDatabaseQueryExecutor`
* `MongoDatabaseQueryExecutor`

---

# Design Challenge

The main challenge was ensuring that when a database is selected, the correct **pair of objects** is created.

For example:

```
MySQL → MysqlConnection + MysqlQueryExecutor
MongoDB → MongoConnection + MongoQueryExecutor
```

We must prevent incorrect combinations like:

```
MysqlConnection + MongoQueryExecutor
```

To solve this problem, I used the **Abstract Factory Design Pattern**.

---

# Solution Using Abstract Factory

I created an interface called `DatabaseFactory` that defines methods to create:

* `DatabaseConnection`
* `DatabaseQueryExecutor`

Then I created **database-specific factories**:

* `MysqlDatabaseFactory`
* `MongoDatabaseFactory`

Each factory creates the correct pair of objects.

Example:

```
MysqlDatabaseFactory
   → MysqlDatabaseConnection
   → MysqlDatabaseQueryExecutor

MongoDatabaseFactory
   → MongoDatabaseConnection
   → MongoDatabaseQueryExecutor
```

---

# Factory Provider

To avoid creating factories directly in the client code, I added a helper class called **DatabaseFactoryProvider**.

This class selects the correct factory based on the database type.

Example:

```java
DatabaseFactory factory = DatabaseFactoryProvider.getDatabaseFactory("mysql");
```

---

# Final Design

The system contains the following components.

## Interfaces

```
DatabaseConnection
DatabaseQueryExecutor
DatabaseFactory
```

## Concrete Implementations

```
MysqlDatabaseConnection
MongoDatabaseConnection

MysqlDatabaseQueryExecutor
MongoDatabaseQueryExecutor
```

## Factories

```
MysqlDatabaseFactory
MongoDatabaseFactory
```

## Factory Provider

```
DatabaseFactoryProvider
```

---

# Benefits of This Design

* The client code is **independent of database implementations**
* **New databases can be added easily**
* The correct **family of related objects** is always created
* The design follows the **Abstract Factory Pattern**

---

# Example Usage

```java
DatabaseFactory factory =
        DatabaseFactoryProvider.getDatabaseFactory("mysql");

DatabaseConnection connection = factory.getDatabaseConnection();
DatabaseQueryExecutor executor = factory.getDatabaseQueryExecutor();

connection.createConnection();
executor.executeQuery();
```

---

# Design Pattern Used

**Abstract Factory Pattern**

The Abstract Factory pattern provides an interface for creating **families of related objects** without specifying their concrete classes.

In this example:

```
DatabaseFactory → Connection + QueryExecutor
```

---

⭐ This project was created as part of learning **Low Level Design (LLD) and Design Patterns in Java**.
