package library;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      ArrayList<Book> myBooks = new ArrayList<>();
      Library library1 = new Library(myBooks);
      LibraryApp libraryApp = new LibraryApp(library1);

      libraryApp.start();
    }
}