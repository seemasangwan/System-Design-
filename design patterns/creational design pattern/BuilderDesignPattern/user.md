# Builder Design Pattern in Java 🚀

This project demonstrates the implementation of the **Builder Design Pattern** in Java along with important OOP concepts like **Encapsulation** and **Immutability**.

---

## 📌 Overview

When a class has multiple fields (especially optional ones), creating objects using constructors becomes complex and reduces readability.

The **Builder Pattern** solves this problem by:
- Creating objects step-by-step
- Separating object construction from representation
- Improving code readability and maintainability

---

## 🧠 Concepts Covered

### 🔹 1. Builder Design Pattern
- Used to construct complex objects step by step
- Avoids multiple constructors (Telescoping Constructor Problem)
- Provides clean and readable object creation

### 🔹 2. Encapsulation
- All fields are marked `private`
- Data is hidden from external classes
- Access is controlled

### 🔹 3. Immutability
- All fields are marked `final`
- No setter methods
- Object state cannot be changed after creation

### 🔹 4. Required vs Optional Fields
- Required fields → passed via Builder constructor
- Optional fields → set using setter methods

### 🔹 5. Method Chaining
- Each setter returns `this`
- Enables chaining like:
  ```java
  new User.UserBuilder("name", "email")
      .setAge(22)
      .build();
