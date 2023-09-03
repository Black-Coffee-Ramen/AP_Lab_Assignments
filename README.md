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
   git clone https://github.com/Alpha-rgb-cell/AP_Lab_Assignments.git
   cd LibraryManagementSystem
   ```

2. **Compile and Package the Application:**
   ```bash
   mvn clean package
   ```

3. **Run the Application:**
   ```bash
   java -jar target/LibraryManagementSystem.jar
   ```

4. The program will display a menu with options for librarian and member actions.

## Maven Structure
This project follows a standard Maven project structure:

- `src/main/java/org/example`: Contains the Java source code.
- `target`: Contains the compiled classes and the JAR file.
- `pom.xml`: The pom.xml file in Maven projects specifies project information, dependencies, build instructions, and other settings for consistent project management.

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
If you have any questions or suggestions, please feel free to contact athiyodhamei@gmail.com.

---

## LICENSE
MIT License

Copyright (c) 2023 Athiyo Chakma

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
