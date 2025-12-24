package library;

import java.util.ArrayList;

public class Library {
  private ArrayList<Book> books;
  private static int totalBooks;

  public Library(ArrayList<Book> books) {
    this.books = books;
    if (books.size() <= 0) {
      totalBooks = 0;
    } else {
      int countBooks = 0;
      for (Book book : books) {
        countBooks += book.getStock();
      }
      totalBooks = countBooks;
    }
  }

  // getters

  public ArrayList<Book> getBooks() {
    return books;
  }

  public static int getTotalBooks() {
    return totalBooks;
  }

  // methods
  public void addBook(Book book) {
    this.books.add(book);
    totalBooks += book.getStock();
  }

  public Book lendBook(String bookId) {
    Book lendBook = null;
    for (int index = 0; index < this.books.size(); index++) {
      Book currentBook = books.get(index);
      if (((currentBook).getId()).equals(bookId)) {
        if (currentBook.getStock() <= 0) {
          System.out.println("There is not stock available!!");
          break;
        } else {
          lendBook = currentBook;
          totalBooks-=1;
          currentBook.setStock(currentBook.getStock() - 1);
          break;
        }
      }
    }
    return lendBook;
  }

  public Book searchBook(String bookId) {
    Book foundBook = null;
    for (Book book : this.books) {
      if (book.getId().equals(bookId)) {
        foundBook = book;
        break;
      }
    }
    return foundBook;
  }


}
