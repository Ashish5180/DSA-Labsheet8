E-Commerce Search and Sort System


Project Objective

    Implement sorting and searching algorithms.
    Manage product data (ID, name, category, price, rating).
    Provide search and sort functionalities based on user input.

Features

    Sorting Algorithms:
        Insertion Sort, Selection Sort, Bubble Sort
        Merge Sort, Quick Sort, Heap Sort
        Counting Sort, Radix Sort, Bucket Sort

    Searching Algorithms:
        Sequential Search
        Binary Search (Recursive & Iterative)

    E-Commerce Product Management:
        Add, Update, Delete products
        Search and Sort products by price, rating, and name

Requirements

    Java: JDK 8 or higher
    IDE: Any Java-compatible IDE (Eclipse, IntelliJ IDEA, or NetBeans)
    Operating System: Windows, macOS, or Linux

Installation

    Clone the repository:

git clone https://github.com/Ashish5180/DSA-Labsheet8.git

    Navigate to the project directory:

cd ecommerce-search-sort

    Open the project in your IDE:
        Import the project into your IDE (Eclipse, IntelliJ IDEA, etc.).
        Alternatively, open the source code files directly if not using an IDE.

Compilation and Running the Program

    Compile the Java program: Open a terminal or command prompt, navigate to the project directory, and run the following:

javac Main.java

    Run the Program:

After compiling, execute the program with:

java Main

The program will prompt you to interact with the E-Commerce product management system, allowing you to add, update, delete, search, and sort products.
Code Structure

    Product.java: Contains the Product class with attributes (ID, name, category, price, rating) and methods for product management.
    SortingAlgorithms.java: Implements various sorting algorithms (Insertion Sort, Selection Sort, etc.).
    SearchingAlgorithms.java: Implements search algorithms (Sequential Search, Binary Search).
    Main.java: The main entry point for the application where the user can interact with the system.

Sample Input and Output
Test Case 1: Insertion Sort by Price

    Input:

[Product1, Product2, Product3]

Expected Output:

    [Product2, Product3, Product1]  // Sorted by price

Test Case 2: Binary Search by ID

    Input:

ProductID = 101

Expected Output:

    {ID: 101, Name: "ProductA", Price: 50}  // Product found

Test Cases

    Insertion Sort by Price:
        Input: [Product1, Product2, Product3]
        Output: Sorted list by price.

    Binary Search by ID:
        Input: ProductID = 101
        Output: {ID: 101, Name: "ProductA", Price: 50}.
