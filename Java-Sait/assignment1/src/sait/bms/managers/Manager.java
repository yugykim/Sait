package sait.bms.managers;

import java.io.*;
import java.util.*;
import sait.bms.problemdomain.*;

public class Manager {
  private static Scanner sc = new Scanner(System.in);
  private ArrayList<Book> books = new ArrayList<Book>();

  public Manager() throws FileNotFoundException {
    System.out.println("work");
    loadBooksFromFile();
    selectOption();
  }

  public int mainDashboard() {

    System.out.println("Welcome in ABC Book Company: How May We Assist You?");
    System.out.println("1	Checkout Book");
    System.out.println("2	Find Books by Titl");
    System.out.println("3	Display Books by Type");
    System.out.println("4	Produce Random Book List");
    System.out.println("5	Save & Exit");
    System.out.print("Enter option: ");

    int userInput = sc.nextInt();
    return userInput;

  }

  public void selectOption() {
    int userInput = 0;
    while (userInput != 5) {
      userInput = mainDashboard();

      switch (userInput) {
        case 1:
          checkOutBook();
          break;
        case 2:
          findBookByTitle();
          break;
        case 3:
          displayBooksByType();
          break;
        case 4:
          produceRandomBookList();
          break;
        case 5:
          produceRandomBookList();
          break;
        default:
          System.out.println("Invalid Option");
      }
    }
  }

  public void checkOutBook() {
    System.out.print("Enter ISBN of book: ");

    long UserInputIsbn = sc.nextLong();

    for (Book book : books) {
      if (book.getIsbn() == UserInputIsbn) {
        if (book.getTotal() > 0) {
          if (!(book instanceof Periodical)){
            book.reduceAvailableNumber();
            System.out.println("The book \"" + book.getTitle() + "\" has been checked out");
            System.out.println("It can be located using a calling number: " + book.getCall());
            
            break;
          } else {
            System.out.println("Periodical");
            break;
          }
        } else {
          System.out.println("The book " + book.getTitle() + " has been checked out.");
          System.out.println("It can be located using a call number: " + book.getCall());
          break;
        }

      }
    }

    mainDashboard();
    sc.nextLine();
  }

  public void findBookByTitle() {
    System.out.print("Enter title to search for: ");
    String userSearchTitle = sc.next();
    System.out.println("Matching books: ");

    for (Book book : books) {
      if (book.getTitle().toLowerCase().contains(userSearchTitle)) {
        System.out.println(book.toString());
        System.out.println();
      }
    }
    sc.nextLine();
  }

  public void displayBooksByType() {
    //System.out.println("#     Type\n1     Children's Books\n2     Cookbooks\n3     Paperbacks\n4     Periodicals");
    //System.out.print("Enter type of book: ");
    //int userInputTypeOfBook = sc.nextInt();
    //sc.nextLine();

    for (Book book : books) {
      /*
       * switch (userInputTypeOfBook) {
       * case 1:
       * if (book instanceof ChildrensBook) {
       * System.out.
       * println("Enter format (P for Picture book, E for Early Readers, or C for Chapter book): "
       * );
       * System.out.println(book.toString());
       * }
       * break;
       * case 2:
       * if (book instanceof Cookbook) {
       * System.out.
       * println("Enter diet type (D for Diabecit, V for Vegetarian, G for Gluten-free, I for International, or N for None): "
       * );
       * System.out.println(book.toString());
       * }
       * break;
       * case 3:
       * if (book instanceof PaperBack) {
       * System.out.
       * println("Enter genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction): "
       * );
       * System.out.println(book.toString());
       * }
       * break;
       * case 1:
       */
      if (book instanceof Periodical) {
        //System.out.println(book.toString());
        
        System.out.print("Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly): ");
        String userInputFrequency = sc.nextLine();

        if (((Periodical) book).getFrequency().equalsIgnoreCase(userInputFrequency)) {
          System.out.println(((Periodical)book).toString());
        }
        
      }
    }

    mainDashboard();

  }

  public void produceRandomBookList() {
    System.out.print("Enter Number of books: ");
    int numberOfBooks = sc.nextInt();

    for (int i = 0; i < numberOfBooks; i++) {
      int randomNumber = (books.size() * (int) Math.random());
      System.out.println(books.get(randomNumber).toString());
    }

    mainDashboard();

  }

  public void loadBooksFromFile() throws FileNotFoundException {
    System.out.println("work");
    File inputFile = new File("res/books.txt");
    Scanner in = new Scanner(inputFile);

    while (in.hasNext()) {
      String line = in.nextLine();
      String[] fields = line.split(";");
      int digit = (int) (Double.parseDouble(fields[0]) % 10);

      switch (digit) {
        case 0, 1:
          books.add(new ChildrensBook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
              Integer.parseInt(fields[3]), fields[4], fields[5], fields[6]));
          break;
        case 2, 3:
          books.add(new Cookbook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
              Integer.parseInt(fields[3]), fields[4], fields[5], fields[6]));
          break;
        case 4, 5, 6, 7:
          books.add(new PaperBack(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
              Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]), fields[7]));
          break;
        case 8, 9:
          books.add(new Periodical(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
              Integer.parseInt(fields[3]), fields[4], fields[5]));
          break;
      }
    }

    in.close();
  }
}
