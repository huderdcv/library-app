package library;

import java.util.Scanner;

public class LibraryApp {
  private Library library;
  private Scanner scanner;

  public LibraryApp(Library library) {
    this.library = library;
    this.scanner = new Scanner(System.in);
  }

  // methods

  public void start() {
    int option;
    do {
      showMenu();
      option = getUserOption();
      handleOptions(option);
    } while (option != 5);
  }

  private void showMenu() {
    System.out.println("Select one option");
    System.out.println("1. Add a book");
    System.out.println("2. Search book by ID");
    System.out.println("3. Lend a book by ID");
    System.out.println("4. Show books");
    System.out.println("5. Exit");
  }

  private int getUserOption() {
    return this.scanner.nextInt();
  }

  private void handleOptions(int option) {
    switch (option) {
      case 1: {
        addBook();
        break;
      }
      case 2: {
        searchBook();
        break;
      }
      case 3: {
        lendBook();
        break;
      }
      case 4: {
        displayBooks();
        break;
      }
      case 5: {
        System.out.println("Thank you for use the app!!!");
        System.out.println("See you later!!");
        break;
      }
      default: {
        System.out.println("Invalid option...");
      }
    }
  }

  private void addBook() {
    String bookId = Long.toString(System.currentTimeMillis());

    System.out.println("Input the book title: ");
    String bookTitle = scanner.nextLine();

    System.out.println("Input the book author: ");
    String bookAuthor = scanner.nextLine();

    System.out.println("Input the book year of published: ");
    int bookYearPublished = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Input the book stock: ");
    int stock = scanner.nextInt();
    scanner.nextLine();

    Book newBook = new Book(bookId, bookTitle, bookAuthor, bookYearPublished, stock);
    this.library.addBook(newBook);

    System.out.println("New book " + bookTitle + " added!");
  }

  private void searchBook() {
    System.out.println("Input the book ID");
    String bookId = scanner.nextLine();

    Book foundBook = library.searchBook(bookId);

    if (foundBook != null) {
      System.out.println("Book found!!");
      System.out.println(foundBook.toString());
    } else {
      System.out.println("Book doesn't exists!!");
    }
  }

  private void lendBook() {
    System.out.println("Input the book ID");
    String bookId = scanner.nextLine();

    Book lendBook = library.lendBook(bookId);

    if (lendBook != null) {
      System.out.println("Now this book is yours!!");
      System.out.println(lendBook.toString());
    } else {
      System.out.println("Book doesn't exists!!");
    }
  }

  private void displayBooks() {
    System.out.println("Showing the list of books...");
    System.out.println(library.getBooks().toString());;
  }

}