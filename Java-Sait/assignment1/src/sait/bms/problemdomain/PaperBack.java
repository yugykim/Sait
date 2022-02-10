package sait.bms.problemdomain;

public class PaperBack extends Book{
  private String authors;
  private int year;
  private String genre;
  
  public PaperBack()
	{
		super();
	}

  public PaperBack(long isbn, String call, int available, int total, String title) {
    super(isbn, call, available, total, title);

  }

  public PaperBack(long isbn, String call, int available, int total, String title, String authors, int year, String genre) {
    super(isbn, call, available, total, title);

    this.authors = authors;
    this.genre = genre;
    this.year = year;
  }

  public String getAuthors() {
    return this.authors;
  }

  public String getGenre() {
    return this.genre;
  }

  public int getYear() {
    return this.year;
  }

  @Override
  public String toString(){
    return "ISBN:      " + getIsbn() + "\nCall Number:     " + getCall() + "\nAvailable:        " + getAvailable() + "\nTotal:         " + getTotal()
    + "\nTitle:     " + getTitle() + "\nAuthors:      " + authors + "\nYear:       " + year + "\nGenre:        " + genre + "\n";
  }
}

