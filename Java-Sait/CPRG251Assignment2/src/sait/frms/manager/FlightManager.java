package sait.frms.manager;

import sait.frms.manager.*;
import sait.frms.problemdomain.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FlightManager {
  String WEEKDAY_ANY, WEEKDAY_SUNDAY, WEEKDAY_MONDAY, WEEKDAY_TUESDAY, WEEKDAY_WEDNESDAY, WEEKDAY_THURSDAY,
      WEEKDAY_FRIDAY, WEEKDAY_SATURDAY;
  static ArrayList<Flight> flights = new ArrayList<Flight>();
  static ArrayList<String> airports = new ArrayList<String>();
  static final String FLIGHTS_PATH = "res/flights.csv";
  static final String AIRPORTS_PATH = "res/airports.csv";

  public String[] getAirports() {

    String[] airportCode = new String[airports.size() / 2];
    for (int i = 0; i < airportCode.length; i++) {
      int index = i * 2;
      airportCode[i] = airports.get(index);
    }

    return airportCode;
  }

  public ArrayList<Flight> getFlights() {

    return null;
  }

  public String findAirportByCode(String code) {
    for (String a : airports) {
      if (a == code) {
        return airports.get(1);
      }
    }
    return null;
  }

  public Flight findFlightByCode(String code) {
    for (int i = 0; i < flights.size(); i++) {
      if (flights.get(i).getCode().equals(code)) {

        return flights.get(i);
      }
    }
    return null;
  }

  public ArrayList<Flight> findFlights(String from, String to, String weekday) {
    ArrayList<Flight> foundFlights = new ArrayList<Flight>();
    from = from == null ? "YYC" : from;
    to = to == null ? "YYC" : to;
    weekday = weekday == null ? "Any" : weekday;
    for (Flight f : flights) {
      if (f.getFrom().equals(from) && f.getTo().equals(to)) {
        if (f.getWeekday().equals(weekday)) {
          foundFlights.add(f);
        } else {
          if (weekday.equals("Any")) {
            foundFlights.add(f);
          }
        }
      } else {

      }
    }
    return foundFlights;
  }

  public static void returnSeat(String flightCode) {
    for (Flight f : flights){
      if (f.getCode().equals(flightCode)){
        f.returnSeats();
      }
    }
  }

  public static void reduceSeat(String flightCode) {
    for (Flight f : flights){
      if (f.getCode().equals(flightCode)){
        f.reduceSeats();
      }
    }
  }

  public void populateFlight() throws FileNotFoundException {
    Scanner fligthScanner = new Scanner(new File(FLIGHTS_PATH));
    ArrayList<Flight> readflights = new ArrayList<Flight>();
    System.out.println("--------------------------------------");
    while (fligthScanner.hasNext()) {
      String line = fligthScanner.nextLine();
      String[] fields = line.split(",");

      /*
       * System.out.println(fields[0]+ fields[1]+ fields[2]+ fields[3]+ fields[4]+
       * fields[5]+
       * Integer.parseInt(fields[6])+ Double.parseDouble(fields[7]));
       */
      readflights.add(new Flight(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5],
          Integer.parseInt(fields[6]), Double.parseDouble(fields[7])));

    }

    flights = readflights;
    
  }

  public void populateAirports() throws FileNotFoundException {
    Scanner airportScanner = new Scanner(new File(AIRPORTS_PATH));
    while (airportScanner.hasNext()) {
      String line = airportScanner.nextLine();
      String[] fields = line.split(",");
      airports.add(fields[0]);
      airports.add(fields[1]);
    }
  }

  public static void writeFlight() throws Exception {
    System.out.println("Start writing ");

    FileWriter add = new FileWriter(FLIGHTS_PATH);

    for (Flight f : flights) {
      add.write(f.toString());
      add.write("\n");
    }
    System.out.println("Writing Done");

    add.close();
  }
}
