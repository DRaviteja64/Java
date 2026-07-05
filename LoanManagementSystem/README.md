
# Loan Management System

## Overview

The Loan Management System is a console-based Java application that automates the loan application process for multiple loan types. It validates customer information, evaluates loan eligibility using the applicant's CIBIL score, calculates the applicable interest rate and repayment details, and generates a detailed loan application summary.

## Features

* Supports multiple loan types:

  * Personal Loan
  * Home Loan
  * Car Loan
  * Gold Loan
* Menu-driven console application
* Customer validation:

  * Age validation
  * Aadhaar number validation
  * PAN card validation
  * Mobile number validation
* CIBIL score verification
* Loan eligibility assessment based on CIBIL score
* Salary-based loan amount eligibility (where applicable)
* Gold weight-based loan calculation for Gold Loans
* Dynamic Rate of Interest (ROI) calculation
* EMI and total repayment calculation
* Formatted loan application summary with masked Aadhaar and mobile numbers
* Modular design using separate classes for each loan type

## Object-Oriented Programming Concepts Used

* Encapsulation (Private fields with getters and setters)
* Inheritance
* Abstraction
* Interfaces
* Runtime Polymorphism (Dynamic Method Dispatch)
* Method Overriding

## Technologies Used

* Java
* Core Java
* Object-Oriented Programming (OOP)
* Collections (`ArrayList`)
* Regular Expressions (Regex)
* Scanner Class
* Console-Based Application

## Project Structure

```text
LoanManagementSystem/
├── InterfaceLoan.java
├── Loan.java
├── PersonalLoan.java
├── HomeLoan.java
├── CarLoan.java
├── GoldLoan.java
└── MainExecutor.java
```

## Learning Outcomes

This project strengthened my understanding of Core Java and Object-Oriented Programming by implementing real-world concepts such as customer validation, business logic, inheritance, abstraction, encapsulation, interfaces, runtime polymorphism, and modular application design.
