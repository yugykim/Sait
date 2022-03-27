package sait.frms.manager;

import sait.frms.manager.*;
import sait.frms.problemdomain.*;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.jar.Attributes.Name;

import javax.lang.model.element.NestingKind;
import javax.swing.JList;

public class ReservationManager {
   public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();

   static final String FLIGHTS_PATH = "res/flights.csv";
   static final String AIRPORTS_PATH = "res/airports.csv";
   static final String RESERVATIONS_PATH = "res/reservations.dat";

   public static Flight flightList;
   public static Reservation reservationList;

   public static void main(String[] args) throws IOException {
      loadFile();
   }

   public static void loadFile() throws FileNotFoundException {
      Scanner in = new Scanner(new File(FLIGHTS_PATH));

      while (in.hasNext()) {
         String line = in.nextLine();
         // System.out.println(line);

         String[] fields = line.split(",");

      }
   }

   public static void makeReservation(JList<Flight> flightsList, String newName, String newCitizenship) {
      flightList = flightsList.getSelectedValue();

      String code = generateReservationCode(flightList);
      String flightCode = flightList.getCode();
      String airline = flightList.getAirlineName();
      String name = newName;
      String citizenship = newCitizenship;
      double cost = flightList.getCostPerSeat();
      boolean active = false;

      // minus available seat
      flightList.reduceSeats();

      reservations.add(new Reservation(code, flightCode, airline, name, citizenship, cost, active));
   }

   public ArrayList<Reservation> findReservations(String code, String airline, String name) {
      // call code
      ArrayList<Reservation> findReservations = new ArrayList<Reservation>();
      for (Reservation r : reservations) {

         if (r.getCode().equals(code) || r.getAirline().equals(airline) || r.getName().equals(name)) {
            findReservations.add(r);
            System.out.println(airline);
         }
      }
      return findReservations;
   }

   public Reservation findReservationByCode(String code) {
      return null;
   }

   public void persist() {
   }

   public void returnAvailableSeats() {
      flightList.returnSeats();
   }

   public static String generateReservationCode(Flight flight) {
      String resCode = null;
      int minValue = 1000;
      int maxValue = 9999;
      int codeNum = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
      String codeNumString = Integer.toString(codeNum);
      char firstLetter;
      // String resCode = null;

      if (flight.getFrom().charAt(0) == flight.getTo().charAt(0)) {
         firstLetter = 'D';
      } else {
         firstLetter = 'I';
      }
      // resCode = firstLetter+codeNum;
      resCode = firstLetter + codeNumString;
      System.out.println(resCode);

      // pattern regex test
      Pattern p = Pattern.compile("^D|I[1-9]\\d{3}$");
      java.util.regex.Matcher matcher = p.matcher(resCode);
      if (matcher.matches()) {
         System.out.println("Reservation code matches");

      } else {
         System.out.println("Reservation code doesn't match");
      }

      return resCode;

   }

   public static void readFromBinary() throws IOException {

      FileInputStream fStream = new FileInputStream(RESERVATIONS_PATH);

      // Read
      try (DataInputStream inputStream = new DataInputStream(fStream)) {
         System.out.println("reading to a file...");
         String code = inputStream.readUTF();
         String flightCode = inputStream.readUTF();
         String airline = inputStream.readUTF();
         String name = inputStream.readUTF();
         String citizenship = inputStream.readUTF();
         Double cost = inputStream.readDouble();
         Boolean status = inputStream.readBoolean();

         reservations.add(new Reservation(code, flightCode, airline, name, citizenship, cost, status));
         System.out.println(reservations);

      } catch (FileNotFoundException e) { // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("Done");

      fStream.close();

   }

   public static void populateFromBinary(Reservation selectedReservation) throws IOException {

      FileOutputStream fStream = new FileOutputStream(RESERVATIONS_PATH);

      // Write
      try (DataOutputStream outputStream = new DataOutputStream(fStream)) {
         System.out.println("writing to a file...");

         reservations.add(selectedReservation);
         
         
         for (Reservation r : reservations) {
            outputStream.writeUTF(r.getCode());
            outputStream.writeUTF(r.getFlightCode());
            outputStream.writeUTF(r.getAirline());
            outputStream.writeUTF(r.getName());
            outputStream.writeUTF(r.getCitizenship());
            outputStream.writeDouble(r.getCost());
            outputStream.writeBoolean(r.isActive());
         }
      }

      System.out.println("Done");

      fStream.close();
   }
}


