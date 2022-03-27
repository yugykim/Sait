package sait.frms.problemdomain;

public class Flight {

	String code;
	String airlineName;
	String from;
	String to;
	String weekday;
	String time;
	int seats;
	double costPerSeat;

	
	public Flight(String code, String airlineName, String from, String to, String weekday, String time, int seats,
			double costPerSeat) {
		super();
		this.code = code;
		this.airlineName = airlineName;
		this.from = from;
		this.to = to;
		this.weekday = weekday;
		this.time = time;
		this.seats = seats;
		this.costPerSeat = costPerSeat;
	}

	public String getCode() {
		return code;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getWeekday() {
		return weekday;
	}

	public String getTime() {
		return time;
	}

	public int getSeats() {
		return seats;
	}

  public void reduceSeats() {
		this.seats--;
	}

  public void returnSeats() {
		this.seats++;
	}

	public double getCostPerSeat() {
		return costPerSeat;
	}

	public boolean isDomestic() {
		// temp
		return true;
	}

	public void parseCode(String code) {

	}

	@Override
	public String toString() {
    /*
		return "Flight [code=" + code + ", airlineName=" + airlineName + ", from=" + from + ", to=" + to + ", weekday="
				+ weekday + ", time=" + time + ", seats=" + seats + ", costPerSeat=" + costPerSeat + "]";
    */
    return code + ",FROM:" + from + ",To:" + to + ",Day:" + weekday + ",Cost:" + costPerSeat;
	}

}
