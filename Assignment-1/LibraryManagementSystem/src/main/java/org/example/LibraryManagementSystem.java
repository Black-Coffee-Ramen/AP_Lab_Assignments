package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



class Member {
    int id;
    String name;
    int age;
    String phoneNumber;
    int penalty;
    ArrayList<Book> borrowedBooks;

    public Member(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.penalty = 0;
        this.borrowedBooks = new ArrayList<>();
    }
}


class Book {
    int id;
    String title;
    String author;
    int totalCopies;
    int availableCopies;
    long dueDate;  // Add the dueDate field

    public Book(int id, String title, String author, int totalCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.dueDate = 0; //initialize due date to 0
    }
}

public class LibraryManagementSystem {
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();
    static int memberIdCounter = 1;
    static int bookIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            displayMainMenu();
            choice = scanner.nextInt();

            if (choice == 1) {
                librarianLogin(scanner);
            } else if (choice == 2) {
                memberLogin(scanner);
            } else if (choice == 3) {
                System.out.println("Thanks for visiting!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    static void displayMainMenu() {
        System.out.println("Library Management System:");
        System.out.println("1. Enter as a librarian");
        System.out.println("2. Enter as a member");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    static void librarianLogin(Scanner scanner) {
        int librarianChoice;
        while (true) {
            displayLibrarianMenu();
            librarianChoice = scanner.nextInt();

            if (librarianChoice == 1) {
                registerMember(scanner);
            } else if (librarianChoice == 2) {
                removeMember(scanner);
            } else if (librarianChoice == 3) {
                addBook(scanner);
            } else if (librarianChoice == 4) {
                removeBook(scanner);
            } else if (librarianChoice == 5) {
                viewMembers();
            } else if (librarianChoice == 6) {
                viewBooks();
            } else if (librarianChoice == 7) {
                System.out.println("Returning to main menu.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void displayLibrarianMenu() {
        System.out.println("Librarian Menu:");
        System.out.println("1. Register a member");
        System.out.println("2. Remove a member");
        System.out.println("3. Add a book");
        System.out.println("4. Remove a book");
        System.out.println("5. View all members along with their books and fines");
        System.out.println("6. View all books");
        System.out.println("7. Back");
        System.out.print("Enter your choice: ");
    }

    static void registerMember(Scanner scanner) {
        scanner.nextLine(); // Consume newline
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Phone no: ");
        String phoneNumber = scanner.nextLine();

        members.add(new Member(memberIdCounter, name, age, phoneNumber));
        System.out.println("Member Successfully Registered with Member ID: " + memberIdCounter);
        memberIdCounter++;
    }

    static void removeMember(Scanner scanner) {
        scanner.nextLine(); // Consume newline
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone No: ");
        String phoneNumber = scanner.nextLine();

        Member memberToRemove = null;
        for (Member member : members) {
            if (member.name.equals(name) && member.phoneNumber.equals(phoneNumber)) {
                memberToRemove = member;
                break;
            }
        }

        if (memberToRemove != null) {
            members.remove(memberToRemove);
            System.out.println("Member with Name: " + name + " and Phone No: " + phoneNumber + " removed.");
        } else {
            System.out.println("Member with Name: " + name + " and Phone No: " + phoneNumber + " doesn't exist.");
        }
    }

    static void addBook(Scanner scanner) {
        scanner.nextLine(); // Consume newline
        System.out.print("Book title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Copies: ");
        int copies = scanner.nextInt();

        books.add(new Book(bookIdCounter, title, author, copies));
        System.out.println("Book Added Successfully!");
        bookIdCounter++;
    }

    static void removeBook(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        Book bookToRemove = null;
        for (Book book : books) {
            if (book.id == bookId) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book ID: " + bookId + " successfully removed.");
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }

    static void viewMembers() {
        System.out.println("Members List:");
        for (Member member : members) {
            System.out.println("Member ID: " + member.id);
            System.out.println("Name: " + member.name);
            System.out.println("Phone Number: " + member.phoneNumber);
            System.out.println("Borrowed Books: " + member.borrowedBooks.size());
            System.out.println("Penalty: " + member.penalty);
            System.out.println("----------");
        }
    }

    static void viewBooks() {
        System.out.println("Books List:");

        // Create a map to group books by title
        Map<String, List<Book>> booksByTitle = new HashMap<>();
        for (Book book : books) {
            booksByTitle.computeIfAbsent(book.title, k -> new ArrayList<>()).add(book);
        }

        // Display books with their copies
        for (List<Book> copies : booksByTitle.values()) {
            System.out.println("Book ID - " + copies.get(0).id);
            System.out.println("Name - " + copies.get(0).title);
            System.out.println("Author - " + copies.get(0).author);
            System.out.println("Total Copies - " + copies.get(0).totalCopies);
            System.out.println("Available Copies - " + copies.size());
            System.out.println("----------");
        }
    }


    static void memberLogin(Scanner scanner) {
        System.out.print("Name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Phone No: ");
        String phoneNumber = scanner.nextLine();

        Member loggedInMember = null;
        for (Member member : members) {
            if (member.name.equals(name) && member.phoneNumber.equals(phoneNumber)) {
                loggedInMember = member;
                break;
            }
        }

        if (loggedInMember != null) {
            System.out.println("Welcome " + loggedInMember.name + ". Member ID: " + loggedInMember.id);
            memberMenu(scanner, loggedInMember);
        } else {
            System.out.println("Member not found.");
        }
    }

    static void memberMenu(Scanner scanner, Member loggedInMember) {
        int memberChoice = 0; // Initialize to a value outside the valid choices
        while (memberChoice != 6) {
            displayMemberMenu();
            memberChoice = scanner.nextInt();

            if (memberChoice == 1) {
                listAvailableBooks();
            } else if (memberChoice == 2) {
                listMyBooks(loggedInMember);
            } else if (memberChoice == 3) {
                issueBook(scanner, loggedInMember);
            } else if (memberChoice == 4) {
                returnBook(scanner, loggedInMember);
            } else if (memberChoice == 5) {
                payFine(loggedInMember);
            } else if (memberChoice == 6) {
                System.out.println("Returning to main menu.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    static void displayMemberMenu() {
        System.out.println("Member Menu:");
        System.out.println("1. List Available Books");
        System.out.println("2. List My Books");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. Pay Fine");
        System.out.println("6. Back");
        System.out.print("Enter your choice: ");
    }

    static void listAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println("Book ID: " + book.id);
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("Available Copies: " + book.availableCopies);
            System.out.println("----------");
        }
    }

    static void listMyBooks(Member loggedInMember) {
        System.out.println("Books borrowed by " + loggedInMember.name + ":");
        for (Book book : loggedInMember.borrowedBooks) {
            System.out.println("Book ID: " + book.id);
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("----------");
        }
    }

    static void issueBook(Scanner scanner, Member loggedInMember) {
        listAvailableBooks();
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        Book bookToIssue = null;
        for (Book book : books) {
            if (book.id == bookId) {
                bookToIssue = book;
                break;
            }
        }

        if (bookToIssue != null) {
            if (loggedInMember.penalty > 0) {
                System.out.println("You have a penalty of Rs. " + loggedInMember.penalty + ". Please pay the penalty before issuing a book.");
            } else if (loggedInMember.borrowedBooks.size() >= 2) {
                System.out.println("You have reached the maximum limit of borrowed books.");
            } else if (bookToIssue.availableCopies > 0) {
                loggedInMember.borrowedBooks.add(bookToIssue);
                bookToIssue.availableCopies--;

                // Set the due date to 10 days from the issue date
                bookToIssue.dueDate = System.currentTimeMillis() + (10 * 24 * 60 * 60 * 1000);

                System.out.println("Book Issued Successfully!");
            } else {
                System.out.println("No available copies of the book.");
            }
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }

    static void returnBook(Scanner scanner, Member loggedInMember) {
        listMyBooks(loggedInMember);
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        Book bookToReturn = null;
        for (Book book : loggedInMember.borrowedBooks) {
            if (book.id == bookId) {
                bookToReturn = book;
                break;
            }
        }

        if (bookToReturn != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long delayMillis = currentTimeMillis - bookToReturn.dueDate;
            long delayDays = delayMillis / (24 * 60 * 60 * 1000); // Convert milliseconds to days

            if (delayDays > 0) {
                int fine = (int) (delayDays * 3); // Charge 3 rupees per day of delay
                System.out.println("Book ID: " + bookToReturn.id + " successfully returned. " + fine + " Rupees has been charged for a delay of " + delayDays + " days.");
                loggedInMember.penalty += fine;
            } else {
                System.out.println("Book ID: " + bookToReturn.id + " successfully returned.");
            }

            bookToReturn.availableCopies++;
            loggedInMember.borrowedBooks.remove(bookToReturn);
            // Reset the due date to 0
            bookToReturn.dueDate = 0;
        } else {
            System.out.println("Book with ID " + bookId + " not found in your borrowed books.");
        }
    }


    static void payFine(Member loggedInMember) {
        System.out.println("You had a total fine of Rs. " + loggedInMember.penalty + ". It has been paid successfully!");
        loggedInMember.penalty = 0;
    }
}


