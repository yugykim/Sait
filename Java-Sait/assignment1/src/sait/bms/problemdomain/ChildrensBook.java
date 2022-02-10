package sait.bms.problemdomain;

public class ChildrensBook extends Book{
  private String author;
  private String format;
  
  public ChildrensBook()
	{
		super();
	}

  public ChildrensBook(long isbn, String call, int available, int total, String title) {
    super(isbn, call, available, total, title);

  }

  public ChildrensBook(long isbn, String call, int available, int total, String title, String author, String format) {
    super(isbn, call, available, total, title);

    this.author = author;
    this.format = format;

  }

  public String getAuthors() {
    return this.author;
  }

  public String getFormat() {
    return this.format;
  }

  @Override
  public String toString(){
    return "ISBN:      " + getIsbn() + "\nCall Number:     " + getCall() + "\nAvailable:        " + getAvailable() + "\nTotal:         " + getTotal()
    + "\nTitle:     " + getTitle() + "\nAuthors:      " + author + "\nFormat:        " + format + "\n";
  }

}