package sait.bms.problemdomain;

public class Book {

  private long isbn;
  private String call;
  private int available;
  private int total;
  private String title;

  public Book()
	{
		super();
	}

  public Book(long isbn, String call, int available, int total, String title) {
    super();
    
    this.isbn = isbn;
    this.call = call;
    this.available = available;
    this.total = total;
    this.title = title;
  }

  public long getIsbn() {
    return this.isbn;
  }

  public String getCall() {
    return this.call;
  }

  public int getAvailable() {
    return this.available;
  }

  public int getTotal() {
    return this.total;
  }

  public void reduceTotalNumber() {
    if (this.total > 0){
      this.total--;
    }
  }

  public String getTitle() {
    return this.title;
  }

  @Override
  public String toString(){
    return "";
  }
  
}


