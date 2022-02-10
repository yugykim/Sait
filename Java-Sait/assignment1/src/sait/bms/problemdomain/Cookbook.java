package sait.bms.problemdomain;

public class Cookbook extends Book {

  private String publisher;
  private String diet;

  public Cookbook() {
    super();
  }

  public Cookbook(long isbn, String call, int available, int total, String title) {
    super(isbn, call, available, total, title);

  }

  public Cookbook(long isbn, String call, int available, int total, String title, String publisher, String diet) {
    super(isbn, call, available, total, title);
    this.publisher = publisher;
    this.diet = diet;

  }

  public String getPublisher() {
    return this.publisher;
  }

  public String getDiet() {
    return this.diet;
  }

  @Override
  public String toString() {
    return "ISBN:      " + getIsbn() + "\nCall Number:     " + getCall() + "\nAvailable:        " + getAvailable()
        + "\nTotal:         " + getTotal()
        + "\nTitle:     " + getTitle() + "\nPublisher:      " + publisher + "\nDiet:        " + diet + "\n";
  }

}
