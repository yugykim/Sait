package sait.frms.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import sait.frms.gui.FlightsTab.MyListSelectionListener;
import sait.frms.manager.ReservationManager;
import sait.frms.problemdomain.Reservation;

/**
 * Holds the components for the reservations tab.
 * 
 */
public class ReservationsTab extends TabBase {
   /**
    * Instance of reservation manager.
    */
   private ReservationManager reservationManager;

   private JList<Reservation> reservationsList;

   private DefaultListModel<Reservation> reservationModel;

   /**
    * Creates the components for reservations tab.
    */
    JScrollPane scrollPane;
    Reservation selectedReservation;
    JTextField findingByCodeJField;
    JTextField findingByAirlineJField;
    JTextField findingByNameJField;
    JTextField codeJField;
    JTextField flightJField;
    JTextField airlineJField;
    JTextField costJField;
    JTextField nameJField;
    JTextField citizenshipJField;

   public ReservationsTab(ReservationManager reservationManager) {
      this.reservationManager = reservationManager;
      panel.setLayout(new BorderLayout());

      JPanel northPanel = createNorthPanel();
      panel.add(northPanel, BorderLayout.NORTH);

      JPanel centerPanel = createCenterPanel();
         panel.add(centerPanel, BorderLayout.CENTER);

      JPanel eastPanel = createEastPanel();
      panel.add(eastPanel, BorderLayout.EAST);

      JPanel southPanel = createSouthPanel();
      panel.add(southPanel, BorderLayout.SOUTH);
   }

   /**
    * Creates the north panel.
    * 
    * @return JPanel that goes in north.
    */
   private JPanel createNorthPanel() {
      JPanel panel = new JPanel();

      JLabel title = new JLabel("Reservations", SwingConstants.CENTER);
      title.setFont(new Font("serif", Font.PLAIN, 29));
      panel.add(title);

      return panel;
   }

   private JPanel createCenterPanel() {
      JPanel panel = new JPanel();

      panel.setLayout(new BorderLayout());

      reservationModel = new DefaultListModel<>();
      reservationsList = new JList<>(reservationModel);

      // User can only select one item at a time.
      reservationsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      // Wrap JList in JScrollPane so it is scrollable.
      scrollPane = new JScrollPane(this.reservationsList);

      reservationsList.addListSelectionListener(new MyListSelectionListener());

      panel.add(scrollPane);

      return panel;
   }

   private class MyListSelectionListener implements ListSelectionListener {
      /**
       * Called when user selects an item in the JList.
       */
      @Override
      public void valueChanged(ListSelectionEvent e) {

        selectedReservation = reservationsList.getSelectedValue();
        codeJField.setText(selectedReservation.getCode());
        flightJField.setText(selectedReservation.getFlightCode());
        airlineJField.setText(selectedReservation.getAirline());
        costJField.setText(Double.toString(selectedReservation.getCost()));
        nameJField.setText(selectedReservation.getName());
        citizenshipJField.setText(selectedReservation.getCitizenship());

      }

   }

   private JPanel createEastPanel() {

      // container contains north, center(combobox), south
      JPanel containerPanel = new JPanel();
      containerPanel.setLayout(new BorderLayout());

      JPanel panel = new JPanel();
      containerPanel.add(panel, BorderLayout.CENTER);

      JLabel title = new JLabel("Reserve", SwingConstants.CENTER);
      title.setFont(new Font("serif", Font.PLAIN, 25));
      containerPanel.add(title, BorderLayout.NORTH);

      panel.setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints();

      constraints.fill = GridBagConstraints.HORIZONTAL;

      // Code
      JLabel codeJLabel = new JLabel("Code: ");
      codeJLabel.setHorizontalAlignment(JLabel.RIGHT);
      constraints.gridx = 0;
      constraints.gridy = 3;
      panel.add(codeJLabel, constraints);

      codeJField = new JTextField(10);
      codeJField.setEditable(false);
      constraints.gridx = 1;
      constraints.gridy = 3;
      panel.add(codeJField, constraints);

      // Flight
      JLabel flightJLabel = new JLabel("Flight: ");
      flightJLabel.setHorizontalAlignment(JLabel.RIGHT);
      constraints.gridx = 0;
      constraints.gridy = 4;
      panel.add(flightJLabel, constraints);

      flightJField = new JTextField(10);
      flightJField.setEditable(false);
      constraints.gridx = 1;
      constraints.gridy = 4;
      panel.add(flightJField, constraints);

      // Airline
      JLabel airlineJLabel = new JLabel("Airline: ");
      airlineJLabel.setHorizontalAlignment(JLabel.RIGHT);
      constraints.gridx = 0;
      constraints.gridy = 5;
      panel.add(airlineJLabel, constraints);

      airlineJField = new JTextField(10);
      airlineJField.setEditable(false);
      constraints.gridx = 1;
      constraints.gridy = 5;
      panel.add(airlineJField, constraints);

      // Cost
      JLabel costJLabel = new JLabel("Cost: ");
      costJLabel.setHorizontalAlignment(JLabel.RIGHT);
      constraints.gridx = 0;
      constraints.gridy = 6;
      panel.add(costJLabel, constraints);

      costJField = new JTextField(10);
      costJField.setEditable(false);
      constraints.gridx = 1;
      constraints.gridy = 6;
      panel.add(costJField, constraints);

      // Name
      JLabel nameJLabel = new JLabel("Name: ");
      nameJLabel.setHorizontalAlignment(JLabel.RIGHT);
      constraints.gridx = 0;
      constraints.gridy = 7;
      panel.add(nameJLabel, constraints);

      nameJField = new JTextField(10);
      constraints.gridx = 1;
      constraints.gridy = 7;
      panel.add(nameJField, constraints);

      // Citizenship
      JLabel citizenshipJLabel = new JLabel("Citizenship: ");
      citizenshipJLabel.setHorizontalAlignment(JLabel.RIGHT);
      constraints.gridx = 0;
      constraints.gridy = 8;
      panel.add(citizenshipJLabel, constraints);

      citizenshipJField = new JTextField(10);
      constraints.gridx = 1;
      constraints.gridy = 8;
      panel.add(citizenshipJField, constraints);

      // Status
      JLabel statusJLabel = new JLabel("Status: ");
      statusJLabel.setHorizontalAlignment(JLabel.RIGHT);
      constraints.gridx = 0;
      constraints.gridy = 9;
      panel.add(statusJLabel, constraints);

      String[] status = { "Active", "InActive"};
      JComboBox statusBox = new JComboBox(status);
      constraints.gridx = 1;
      constraints.gridy = 9;
      panel.add(statusBox, constraints);

      // Reserve
      JButton updateButton = new JButton("Update");
      containerPanel.add(updateButton, BorderLayout.SOUTH);

      updateButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          // TODO Auto-generated method stub
          selectedReservation.setCitizenship(citizenshipJField.getText());
          selectedReservation.setName(nameJField.getText());
          boolean active = statusBox.getSelectedItem().toString().equals("Active")? true : false;
          selectedReservation.setActive(active);
          System.out.println();
          if (!active) {
            reservationManager.flightList.returnSeats();
          } 
        }

      });
      return containerPanel;

   }

   private JPanel createSouthPanel() {

      // container contains north, center(combobox), south
      JPanel containerPanel = new JPanel();
      containerPanel.setLayout(new BorderLayout());

      JPanel panel = new JPanel();
      containerPanel.add(panel, BorderLayout.CENTER);

      JLabel title = new JLabel("Search", SwingConstants.CENTER);
      title.setFont(new Font("serif", Font.PLAIN, 25));
      panel.add(title,BorderLayout.NORTH);

      panel.setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints();

      constraints.fill = GridBagConstraints.HORIZONTAL;

      // Code
      JLabel codeLabel = new JLabel("Code: ");
      codeLabel.setHorizontalAlignment(JLabel.LEFT);
      constraints.gridx = 0;
      constraints.gridy = 3;
      panel.add(codeLabel, constraints);

      findingByCodeJField = new JTextField();
      findingByCodeJField.setPreferredSize(new Dimension(500,25));
      constraints.gridx = 1;
      constraints.gridy = 3;
      panel.add(findingByCodeJField, constraints);

      // Airline
      JLabel airlineLabel = new JLabel("Airline: ");
      airlineLabel.setHorizontalAlignment(JLabel.LEFT);
      constraints.gridx = 0;
      constraints.gridy = 4;
      panel.add(airlineLabel, constraints);

      findingByAirlineJField = new JTextField();
      findingByAirlineJField.setPreferredSize(new Dimension(500,25));
      constraints.gridx = 1;
      constraints.gridy = 4;
      panel.add(findingByAirlineJField, constraints);

      // Name
      JLabel nameLabel = new JLabel("Name: ");
      nameLabel.setHorizontalAlignment(JLabel.LEFT);
      constraints.gridx = 0;
      constraints.gridy = 5;
      panel.add(nameLabel, constraints);

      findingByNameJField = new JTextField();
      findingByNameJField.setPreferredSize(new Dimension(500,25));
      constraints.gridx = 1;
      constraints.gridy = 5;
      panel.add(findingByNameJField, constraints);

      JButton findResButton = new JButton("Find Reservation");
      containerPanel.add(findResButton, BorderLayout.SOUTH);

      findResButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          // TODO Auto-generated method stub
          
          ArrayList<Reservation> foundReservations = reservationManager.findReservations(findingByCodeJField.getText(), findingByAirlineJField.getText(), findingByNameJField.getText());
          
          reservationModel.clear();
          for (Reservation r : foundReservations){
            reservationModel.addElement(r);
          }
        }

      });

      return containerPanel;
   }

}
