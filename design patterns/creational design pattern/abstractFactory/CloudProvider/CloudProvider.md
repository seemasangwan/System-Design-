
# Abstract Factory Design Pattern – Cloud Provider System

## Overview

This project demonstrates the **Abstract Factory Design Pattern** by designing a system that supports **multiple cloud providers** such as AWS, Azure, and Google Cloud.

The system allows applications to create and manage cloud resources like:

* **Virtual Machines (VM)**
* **Storage Services**

The main goal is to ensure that when a specific cloud provider is selected, the correct set of related resources is created.

---

# Problem Statement

Design a system that supports **multiple cloud providers** such as:

* AWS
* Azure
* Google Cloud (GCP)

Each cloud provider should provide services like:

* **Virtual Machines**
* **Storage Services**

The system should ensure that when a specific provider is chosen, the correct set of services is used.

Example:

AWS → AwsVMProvider + AwsStorageProvider
Azure → AzureVMProvider + AzureStorageProvider
GCP → GcpVMProvider + GcpStorageProvider

The system should **avoid mixing resources from different providers**.

Incorrect example:

AwsVMProvider + AzureStorageProvider ❌

The design should also ensure:

* Client code does **not depend on concrete classes**
* It should be **easy to add new cloud providers**
* Object creation logic should be **centralized**

---

# My Approach

While designing the system, I first identified that all cloud providers offer similar types of resources like **Virtual Machines** and **Storage Services**.

Instead of directly creating concrete classes, I started by defining **separate interfaces** for these resources.

Interfaces created:

* `VMProvider`
* `StorageProvider`

These interfaces define the common operations that every cloud provider must implement.

Example:

`VMProvider`

* createVM()
* deleteVM()

`StorageProvider`

* addStorage()
* deleteStorage()

After defining the interfaces, I created **provider-specific implementations**.

For example:

AWS:

* `AwsVMProvider`
* `AwsStorageProvider`

Azure:

* `AzureVMProvider`
* `AzureStorageProvider`

GCP:

* `GcpVMProvider`
* `GcpStorageProvider`

While designing this, I noticed that **each cloud provider has a family of related objects** that should always be used together.

Example:

AWS → AwsVMProvider + AwsStorageProvider
Azure → AzureVMProvider + AzureStorageProvider
GCP → GcpVMProvider + GcpStorageProvider

To enforce this rule and avoid mixing providers, I used the **Abstract Factory Design Pattern**.

---

# Abstract Factory

I created an abstract factory called:

`CloudFactory`

This factory defines methods for creating cloud resources:

* `getVMProvider()`
* `getStorageProvider()`

Concrete factories implement this interface for each cloud provider.

Examples:

* `AwsCloudFactory`
* `AzureCloudFactory`
* `GcpCloudFactory`

Each factory creates the correct set of resources for its provider.

---

# Project Structure

```
cloud-provider-system
│
├── factory
│   ├── CloudFactory.java
│   ├── AwsCloudFactory.java
│   └── AzureCloudFactory.java
│
├── vm
│   ├── VMProvider.java
│   ├── AwsVMProvider.java
│   └── AzureVMProvider.java
│
├── storage
│   ├── StorageProvider.java
│   ├── AwsStorageProvider.java
│   └── AzureStorageProvider.java
│
├── provider
│   └── CloudProvider.java
│
└── Main.java
```

---

# Example Usage

```java
CloudFactory cloudFactory = CloudProvider.getCloudFactory("aws");

VMProvider vmProvider = cloudFactory.getVMProvider();
StorageProvider storageProvider = cloudFactory.getStorageProvider();

vmProvider.createVM();
storageProvider.addStorage();
```

Example Output:

```
Creating VM in AWS Cloud
Adding storage in AWS Cloud
```

---

# Architecture Diagram

```
                  CloudFactory
                       |
        -----------------------------------
        |                 |               |
   AwsCloudFactory   AzureCloudFactory  GcpCloudFactory
        |                 |               |
   ------------      ------------     ------------
   |          |      |          |     |          |
 AwsVM   AwsStorage  AzureVM  AzureStorage  GcpVM  GcpStorage
```

---

# Benefits of Abstract Factory

* Ensures **correct family of objects is created**
* Prevents **mixing incompatible implementations**
* Promotes **loose coupling**
* Makes the system **easy to extend**
* Improves **maintainability**

---

# When to Use Abstract Factory

Use the Abstract Factory pattern when:

* A system needs to create **families of related objects**
* Objects must **work together**
* You want to **hide object creation logic**
* The system should support **multiple implementations**


⭐ This project is part of my learning journey in **Low Level Design (LLD) and Design Patterns in Java**.
