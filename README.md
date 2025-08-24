# Media Library Management System

The **Media Library Management System** is a Java-based application designed to showcase strong object-oriented programming (OOP) principles. It provides functionality for organizing and managing a collection of books, movies, albums, series, and music while demonstrating the use of **abstraction, inheritance, polymorphism, exception handling, and design patterns**.  

---

## 🚀 Features
- **Robust Object-Oriented Design**
  - Abstract `Media` superclass with well-defined subclasses:
    - `Book`, `Movie`, `Album`, `Series`, `Music`, `Single`
- **Comprehensive Media Management**
  - Add, remove, and search for media items
  - Enforce uniqueness using a custom exception (`MediaAlreadyInLibrary`)
- **Advanced Filtering & Searching**
  - Strategy-based filters via `MediaFilter` and `SearchFilter` interfaces
  - Flexible queries by title, creator, or other attributes
- **Extensible Classification**
  - `Label` and `Format` classes for flexible tagging and media categorization
- **Reliable Error Handling**
  - Clean handling of invalid input and duplicate entries

---

## 🛠️ Tech Stack
- **Language**: Java (JDK 17+ recommended)
- **Programming Paradigm**: Object-Oriented Programming (OOP)
- **Version Control**: Git & GitHub

---

## 📂 Project Architecture

```
media-library-management-system/
├── src/
│   └── Album.java
│   └── Book.java
│   └── Format.java
│   └── Label.java
│   └── Media.java
│   └── MediaAlreadyInLibrary.java
│   └── MediaFilter.java
│   └── MediaLibrary.java
│   └── Movie.java
│   └── Music.java
│   └── SearchFilter.java
│   └── Series.java
│   └── Single.java
├── .gitignore
└── README.md
```

---

## 📖 Example Usage
```java
public class App {
    public static void main(String[] args) {
        MediaLibrary library = new MediaLibrary();

        Book book = new Book("Clean Code", "Robert C. Martin", 2008, "978-0132350884");
        Movie movie = new Movie("Inception", "Christopher Nolan", 2010, 148);

        library.addMedia(book);
        library.addMedia(movie);

        System.out.println("Search results for 'Nolan':");
        library.filter(new SearchFilter("Nolan"))
               .forEach(System.out::println);
    }
}
```

---

⚠️ **Academic Integrity Notice**  
This project was completed as part of **CS 211 at George Mason University**. It is shared here strictly for **portfolio purposes**. Current students must **not copy, reuse, or submit this code** as their own work, as doing so would constitute an **Honor Code violation**.