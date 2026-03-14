Problem Statement

Design a system that supports multiple database providers such as MySQL and MongoDB.

Each database provider should allow the application to:

Create a database connection

Execute queries

The system should ensure that the correct connection and query executor are used together for a given database.

The design should also make it easy to add support for new databases in the future without modifying the existing client code.

My Approach

When I started thinking about the problem, my first idea was to create a single class that would handle both:

Database connection

Query execution

However, I realized that this would violate the Single Responsibility Principle, because connection management and query execution are two different responsibilities.

So I decided to separate them into two interfaces:

DatabaseConnection

DatabaseQueryExecutor

Each database would then implement these interfaces.

For example:

MysqlDatabaseConnection

MongoDatabaseConnection

MysqlDatabaseQueryExecutor

MongoDatabaseQueryExecutor

Design Challenge

Now the problem was:

How can the system ensure that when we choose a database (for example MySQL), the correct connection and query executor pair is created?

For example:

MySQL → MysqlConnection + MysqlQueryExecutor  
MongoDB → MongoConnection + MongoQueryExecutor

To solve this problem, I decided to use the Abstract Factory Design Pattern.

Solution Using Abstract Factory

I created an interface called DatabaseFactory that defines methods to create:

DatabaseConnection

DatabaseQueryExecutor

Then I created database-specific factories:

MysqlDatabaseFactory

MongoDatabaseFactory

Each factory is responsible for creating the correct pair of objects.

Example:

MysqlDatabaseFactory
   → MysqlDatabaseConnection
   → MysqlDatabaseQueryExecutor
MongoDatabaseFactory
   → MongoDatabaseConnection
   → MongoDatabaseQueryExecutor
Factory Provider

To avoid creating factories directly in the client code, I added a helper class called DatabaseFactoryProvider.

This class selects the correct factory based on the database type.

Example:

DatabaseFactory factory = DatabaseFactoryProvider.getDatabaseFactory("mysql");
Final Design

The system contains the following components:

Interfaces:

DatabaseConnection
DatabaseQueryExecutor
DatabaseFactory

Concrete Implementations:

MysqlDatabaseConnection
MongoDatabaseConnection

MysqlDatabaseQueryExecutor
MongoDatabaseQueryExecutor

Factories:

MysqlDatabaseFactory
MongoDatabaseFactory

Factory Provider:

DatabaseFactoryProvider
Benefits of This Design

The client code is independent of database implementations

New databases can be added easily

The correct family of related objects is always created

The design follows the Abstract Factory Pattern

Example Usage
DatabaseFactory factory =
        DatabaseFactoryProvider.getDatabaseFactory("mysql");

DatabaseConnection connection = factory.getDatabaseConnection();
DatabaseQueryExecutor executor = factory.getDatabaseQueryExecutor();

connection.createConnection();
executor.executeQuery();



