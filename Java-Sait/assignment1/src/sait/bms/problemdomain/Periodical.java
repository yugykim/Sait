package sait.bms.problemdomain;

public class Periodical extends Book{
  
  private String frequency;

  public Periodical()
	{
		super();
	}

  public Periodical(long isbn, String call, int available, int total, String title) {
    super(isbn, call, available, total, title);

  }

  public Periodical(long isbn, String call, int available, int total, String title, String frequency) {
    super(isbn, call, available, total, title);

    this.frequency = frequency;
  }

  public String getFrequency(){
    return this.frequency;
  }

  public void setFrequency(String frequency){
    /*
    switch(frequency){
      case "D":
        this.frequency = "Daily";
        break;
      case "W":
        this.frequency = "Weekly";
        break;
      case "M":
        this.frequency = "Monthly";
        break;
      case "B":
        this.frequency = "Bi -Weekly";
      case "Q":
        this.frequency = "Quarterly";
    }
    */
  }

  @Override
  public String toString(){
    return "ISBN:      " + getIsbn() + "\nCall Number:     " + getCall() + "\nAvailable:        " + getAvailable() + "\nTotal:         " + getTotal()
    + "\nTitle:     " + getTitle() + "\nFrequency:      " + frequency + "\n";
  }
}

