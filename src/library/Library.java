package library;

import java.util.ArrayList;

public class Library {
  private ArrayList<Book> books;
  private static int totalBooks;

  public Library(ArrayList<Book> books) {
    this.books = books;
    totalBooks = books.size();
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
  }

  public Book lendBook(String bookId) {
    Book removedBook = null;
    for (int index = 0; index < this.books.size(); index++) {
      if (((books.get(index)).getId()).equals(bookId)) {
        removedBook = books.remove(index);
        break;
      }
    }
    return removedBook;
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
