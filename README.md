# CSE 108: Object-Oriented Programming Language Sessional

## Course Overview

CSE 108 is a 1.5 credit hour sessional course offered by the Department of Computer Science and Engineering (CSE) at Bangladesh University of Engineering and Technology (BUET). The course is designed to provide hands-on experience with the core principles of Object-Oriented Programming (OOP), complementing the theoretical knowledge gained in CSE 107: Object-Oriented Programming Language.

## Repository Structure

This repository contains assignments and projects implemented in **Java** and **C++**. Each assignment demonstrates the application of core OOP principles.

---

## Assignments and Projects

### 1. **Java Assignments**
   - Focus on applying OOP principles in Java.
   - **Key Topics Covered**:
     - **Inheritance**:
       - Implementing hierarchical relationships between classes.
       - Utilizing `super` and overriding methods in derived classes.
     - **Polymorphism**:
       - Method overriding and dynamic method dispatch.
       - Abstract classes and interfaces.
     - **Encapsulation**:
       - Using access modifiers (`private`, `protected`, `public`) to restrict access.
       - Getter and setter methods for controlled access to class fields.
     - **File I/O**:
       - Reading and writing data to files.
       - Handling exceptions during file operations.

   - **Example Work**:
     - Creating a system for managing a library, including book classes and user interactions.
     - Implementing an employee management system using inheritance and file-based persistence.

---

### 2. **C++ Assignments**
   - Focus on implementing OOP concepts using C++.
   - **Key Topics Covered**:
     - **Inheritance**:
       - Base and derived class relationships.
       - Overriding base class methods and calling parent class constructors.
     - **Operator Overloading**:
       - Customizing operators like `+`, `-`, and `<<` for user-defined types.
     - **Friend Functions**:
       - Enabling external functions to access private members.
     - **Polymorphism**:
       - Using virtual functions to implement dynamic binding.
     - **Exception Handling**:
       - Handling runtime errors with `try-catch` blocks.
     - **Templates**:
       - Implementing generic programming using function and class templates.

   - **Example Work**:
     - Designing a banking system with account hierarchies (e.g., savings, current, fixed deposit).
     - Implementing a basic vector class with overloaded operators for mathematical operations.

---

## Getting Started

### Prerequisites
To compile and run the assignments, ensure you have the following:
- **Java Development Kit (JDK)**: For Java assignments.
- **C++ Compiler** (e.g., GCC, Clang): For C++ assignments.

### Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/shahriar-raj/CSE_108-Object-Oriented-Programming-Language-Sessional.git
   cd CSE_108-Object-Oriented-Programming-Language-Sessional

### Assignment Overview
<b> 1. Assignment 1 : </b> This is the first offline assignment for the CSE 108 (Object Oriented Programming) sessional course. The task involves completing a C++ code template involving basic OOP principles such as:

    Class creation and encapsulation using Point and Circle

    Constructor overloading and method definition

    Overloading an update function for positional and radius updates

    Extension task: Creating a new class Line using two Point instances and calculating its length

The final output demonstrates object state changes through a sequence of updates. The goal is to match the expected formatted output precisely, without modifying the given code structure.

<b> 2. Assignment 2 : </b> This is the second offline assignment for the CSE 108 (Object Oriented Programming) sessional course. It focuses on dynamic memory handling, deep copying, and object interaction between classes:

    Book class: Predefined; handles book attributes and operations like edition generation and identity checking.

    BookShop class: Implemented by the student to support:

        Adding/removing books

        Updating prices by ISBN

        Searching by title

        Merging two bookshops

        Copy constructor and dynamic array management

Key Concepts Practiced

    Dynamic memory allocation & destructors

    Deep copying vs shallow copying

    Class composition and array manipulation

    Realistic object-based interaction simulations

The output of the program must exactly match the sample output provided in BookShop.cpp, using both individual and batch operations on books.

<b> 3. Assignment 3 : </b> This is the third offline assignment for the CSE 108 (Object Oriented Programming) sessional course. The focus of this task is on operator overloading in user-defined types to mimic mathematical vector operations.
Features Implemented

    A custom Vector class with:

        Dynamically allocated name

        Overloaded operators:

            ^ for cross product

            * for scalar multiplication and component-wise multiplication

            == for equality check

    Custom output via a print() method (assumed implemented)

    Memory management with dynamic allocation and proper destructor

Objective

Match the exact sample output provided by using operator overloading in a mathematically consistent way, while strictly adhering to the given template and constraints.

<b> 4. Assignment 4 : </b> This repository contains a Java project developed as part of an academic assignment. It models a simple sports league management system using object-oriented principles.
📁 Project Structure

    League.java
    Manages the overall league, storing a collection of matches and computing summaries like total goals, top scorers, or standings.

    Match.java
    Represents individual matches, including teams, scores, and date/time information. May also support comparison or filtering logic.

    Main.java
    Entry point of the application. Likely responsible for initializing the league, adding matches, and invoking summary or display methods.

🧠 Core Concepts Demonstrated

    Object-oriented design with multiple interacting classes (League, Match)

    Encapsulation and data abstraction

    Use of collections (e.g., arrays, ArrayList)

    Input/output handling (console or file-based)

    Basic statistics aggregation (e.g., total scores, win counts, etc.)

🚀 Example Features (Expected)

    Add a match to the league

    Display all matches

    Calculate total/average goals

    Display match summaries

    Identify highest scoring team or player
