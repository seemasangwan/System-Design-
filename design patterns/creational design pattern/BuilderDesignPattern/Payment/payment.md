# 📦 Builder Design Pattern – Payment System

## 🚀 Overview

This project demonstrates the **Builder Design Pattern** using a real-world example of an **Online Payment System**.

The Builder Pattern helps construct complex objects step-by-step, especially when:
- Some fields are **required**
- Some are **optional**
- Some depend on **conditions**

---

## 🧠 What I Learned

- Difference between **required, optional, and conditional fields**
- Implementation of **Builder Design Pattern in Java**
- Creating **immutable objects**
- Performing **validation inside build()**
- Writing **clean, readable, and scalable code**

---


## 🏗️ Why Builder Pattern?

Instead of multiple constructors:

```java
new Payment(amount)
new Payment(amount, method)
new Payment(amount, method, currency)

we use builder patter
Payment payment = new Payment.PaymentBuilder(1000, PaymentMethod.UPI)
        .upiId("user@upi")
        .description("Test payment")
        .build();
