# AP_Lab_Assignments
CSE-201(Advance Programming) Course offered in 3rd Semester of B.Tech at IIIT-D.

# Assignment-1
## Library Management System README

## Introduction
This Java program is a simple Library Management System that allows librarians to manage books and members, and members to borrow and return books. It includes features such as member registration, book addition/removal, fine calculation for overdue books, and more. This project is structured to be built and managed using Apache Maven.

## How to Build and Run
To build and run this program using Apache Maven, follow these steps:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/library-management-system.git
   cd library-management-system
   ```

2. **Compile and Package the Application:**
   ```bash
   mvn clean package
   ```

3. **Run the Application:**
   ```bash
   java -jar target/library-management-system.jar
   ```

4. The program will display a menu with options for librarian and member actions.

## Maven Structure
This project follows a standard Maven project structure:

- `src/main/java`: Contains the Java source code.
- `src/main/resources`: Contains resource files, such as configuration files.
- `target`: Contains the compiled classes and the JAR file.

## Features

### Librarian Actions
1. **Register a Member**: Librarians can register a new member by providing their name, age, and phone number.

2. **Remove a Member**: Librarians can remove a member by specifying their name and phone number.

3. **Add a Book**: Librarians can add a new book by providing its title, author, and the number of copies.

4. **Remove a Book**: Librarians can remove a book by specifying its ID.

5. **View all Members**: Librarians can view a list of all registered members, along with their borrowed books and fines.

6. **View all Books**: Librarians can view a list of all books, grouped by title, and display the total copies and available copies.

### Member Actions
1. **List Available Books**: Members can see a list of available books.

2. **List My Books**: Members can see a list of books they have borrowed.

3. **Issue Book**: Members can borrow a book by specifying its ID. They can only borrow if they don't have a penalty, haven't reached the maximum limit of borrowed books, and if the book is available.

4. **Return Book**: Members can return a book by specifying its ID. If the book is returned late, a fine is calculated based on the delay and added to the member's penalty.

5. **Pay Fine**: Members can pay their fine to clear their penalty.

## Implementation Details
- The program uses object-oriented principles, with classes for `Book` and `Member`.
- Librarians and members are stored in `ArrayList` collections.
- A `Timer` is used to periodically calculate fines for overdue books.
- The due date for each book is set to 10 days from the issue date.
- Fines are calculated at a rate of 3 Rupees per day for overdue books.
- The program handles input validation to prevent invalid actions.

## Future Improvements
Here are some potential improvements for this program:
- Implement a database for data persistence.
- Add the ability to search for books by title, author, or other criteria.
- Allow members to renew borrowed books if they are not overdue.
- Implement a reservation system for books that are currently unavailable.

## License
This program is provided under the MIT License. You are free to use and modify it according to your needs.

## Author
This program was developed by Athiyo Chakma.

## Contact
If you have any questions or suggestions, please feel free to contact [Your Email Address].

---

**Note:** This README is a template. Replace `Athiyo Chakma` and `athiyodhame@gmail.com` with your own information, and make any other necessary modifications to fit your specific implementation.
