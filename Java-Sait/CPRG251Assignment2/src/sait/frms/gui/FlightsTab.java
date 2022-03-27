package sait.frms.gui;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Console;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import sait.frms.manager.FlightManager;
import sait.frms.manager.ReservationManager;
import sait.frms.problemdomain.Flight;

/**
 * Holds the components for the flights tab.
 * 
 */
public class FlightsTab extends TabBase {
	/**
	 * Instance of flight manager.
	 */
	private FlightManager flightManager;

	/**
	 * Instance of reservation manager.
	 */
	private ReservationManager reservationManager;

	/**
	 * List of flights.
	 */
	private JList<Flight> flightsList;

	private DefaultListModel<Flight> flightsModel;

	/**
	 * Creates the components for flights tab.
	 */
	/**
	 * Creates the components for flights tab.
	 * 
	 * @param flightManager      Instance of FlightManager.
	 * @param reservationManager Instance of ReservationManager
	 */
	String selectedFrom, selectedTo, selectedDay, name, citizenship;
	Flight selectedFlight;
	JScrollPane scrollPane;
	JTextField flightJField;
	JTextField airlineJField;
	JTextField dayJField;
	JTextField timeJField;
	JTextField costJField;
	JTextField nameJField;
	JTextField citizenshipJField;

	public FlightsTab(FlightManager flightManager, ReservationManager reservationManager) {
		this.flightManager = flightManager;
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

		JLabel title = new JLabel("Flights", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 29));
		panel.add(title);

		return panel;
	}

	/**
	 * Creates the center panel.
	 * 
	 * @return JPanel that goes in center.
	 */
	private JPanel createCenterPanel() {
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout());

		flightsModel = new DefaultListModel<>();
		flightsList = new JList<>(flightsModel);

		// User can only select one item at a time.
		flightsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Wrap JList in JScrollPane so it is scrollable.
		scrollPane = new JScrollPane(this.flightsList);

		flightsList.addListSelectionListener(new MyListSelectionListener());

		panel.add(scrollPane);

		return panel;
	}

	private class MyListSelectionListener implements ListSelectionListener {
		/**
		 * Called when user selects an item in the JList.
		 */
		@Override
		public void valueChanged(ListSelectionEvent e) {
      if(flightsList.getSelectedValue()==null || flightsList.getSelectedValue()==null){
        return;
      }
			selectedFlight = flightsList.getSelectedValue();
			flightJField.setText(selectedFlight.getCode());
			airlineJField.setText(selectedFlight.getAirlineName());
			dayJField.setText(selectedFlight.getWeekday());
			timeJField.setText(selectedFlight.getTime());
			costJField.setText(Double.toString(selectedFlight.getCostPerSeat()));
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

		// Flight
		JLabel flightJLabel = new JLabel("Flight: ");
		flightJLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 3;
		panel.add(flightJLabel, constraints);

		flightJField = new JTextField(10);
		flightJField.setEditable(false);
		constraints.gridx = 1;
		constraints.gridy = 3;
		panel.add(flightJField, constraints);

		// Airline
		JLabel airlineJLabel = new JLabel("Airline: ");
		airlineJLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 4;
		panel.add(airlineJLabel, constraints);

		airlineJField = new JTextField(10);
		airlineJField.setEditable(false);
		constraints.gridx = 1;
		constraints.gridy = 4;
		panel.add(airlineJField, constraints);

		// Day
		JLabel dayJLabel = new JLabel("Day: ");
		dayJLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 5;
		panel.add(dayJLabel, constraints);

		dayJField = new JTextField(10);
		dayJField.setEditable(false);
		constraints.gridx = 1;
		constraints.gridy = 5;
		panel.add(dayJField, constraints);

		// Time
		JLabel timeJLabel = new JLabel("Time: ");
		timeJLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 6;
		panel.add(timeJLabel, constraints);

		timeJField = new JTextField(10);
		timeJField.setEditable(false);
		constraints.gridx = 1;
		constraints.gridy = 6;
		panel.add(timeJField, constraints);

		// Cost
		JLabel costJLabel = new JLabel("Cost: ");
		costJLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 7;
		panel.add(costJLabel, constraints);

		costJField = new JTextField(10);
		costJField.setEditable(false);
		constraints.gridx = 1;
		constraints.gridy = 7;
		panel.add(costJField, constraints);

		// Name
		JLabel nameJLabel = new JLabel("Name: ");
		nameJLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 8;
		panel.add(nameJLabel, constraints);

		nameJField = new JTextField(10);
		constraints.gridx = 1;
		constraints.gridy = 8;
		panel.add(nameJField, constraints);

		// Citizenship
		JLabel citizenshipJLabel = new JLabel("Citizenship: ");
		citizenshipJLabel.setHorizontalAlignment(JLabel.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 9;
		panel.add(citizenshipJLabel, constraints);

		citizenshipJField = new JTextField(10);
		constraints.gridx = 1;
		constraints.gridy = 9;
		panel.add(citizenshipJField, constraints);

		// Reserve
		JButton reserveButton = new JButton("Reserve");
		containerPanel.add(reserveButton, BorderLayout.SOUTH);

		reserveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedFlight.getSeats() > 0) {
					if (nameJField.getText().equals("") || citizenshipJField.getText().equals("")
							|| selectedFlight == null) {
						JOptionPane.showMessageDialog(containerPanel,
								"Flight schedule, name and citizenship field are required.");
					} else {
						reservationManager.makeReservation(flightsList, nameJField.getText(),
								citizenshipJField.getText());
						int size = ReservationManager.reservations.size() - 1;
						JOptionPane.showMessageDialog(containerPanel,
								"Reservation created. Your code is " + ReservationManager.reservations.get(size));
					}
				} else {
					JOptionPane.showMessageDialog(containerPanel, "Seats are Fulled");
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

		JLabel title = new JLabel("Flight Finder", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 25));
		panel.add(title);

		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.HORIZONTAL;

		// From
		JLabel fromLabel = new JLabel("From: ");
		fromLabel.setHorizontalAlignment(JLabel.LEFT);
		constraints.gridx = 0;
		constraints.gridy = 3;
		panel.add(fromLabel, constraints);

		// Populate airports code to fromBox
		String[] fromNames = flightManager.getAirports();
		JComboBox fromBox = new JComboBox(fromNames);
		fromBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

				if (e.getStateChange() == ItemEvent.SELECTED) {
					selectedFrom = fromBox.getSelectedItem().toString();
				}
			}
		});

		fromBox.setPreferredSize(new Dimension(550, 25));
		constraints.gridx = 1;
		constraints.gridy = 3;
		panel.add(fromBox, constraints);
		panel.setVisible(true);

		// To
		JLabel toLabel = new JLabel("To: ");
		toLabel.setHorizontalAlignment(JLabel.LEFT);
		constraints.gridx = 0;
		constraints.gridy = 4;
		panel.add(toLabel, constraints);

		// Populate airports code to toBox
		String[] toName = flightManager.getAirports();
		JComboBox toBox = new JComboBox(toName);

		toBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

				if (e.getStateChange() == ItemEvent.SELECTED) {
					selectedTo = toBox.getSelectedItem().toString();
				}
			}
		});

		toBox.setPreferredSize(new Dimension(550, 25));
		constraints.gridx = 1;
		constraints.gridy = 4;
		panel.add(toBox, constraints);

		// Day
		JLabel dayLabel = new JLabel("Day: ");
		dayLabel.setHorizontalAlignment(JLabel.LEFT);
		constraints.gridx = 0;
		constraints.gridy = 5;
		panel.add(dayLabel, constraints);

		// Populate day to dayBox
		String[] dayStrings = { "Any", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		JComboBox dayBox = new JComboBox(dayStrings);

		dayBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

				if (e.getStateChange() == ItemEvent.SELECTED) {
					selectedDay = dayBox.getSelectedItem().toString();
				}
			}
		});

		dayBox.setPreferredSize(new Dimension(550, 25));
		constraints.gridx = 1;
		constraints.gridy = 5;
		panel.add(dayBox, constraints);

		JButton findFlightsButton = new JButton("Find Flights");
		containerPanel.add(findFlightsButton, BorderLayout.SOUTH);

		findFlightsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ArrayList<Flight> foundFlights = flightManager.findFlights(selectedFrom, selectedTo, selectedDay);
				flightsModel.clear();
				for (Flight f : foundFlights) {
					flightsModel.addElement(f);
				}
			}

		});

		return containerPanel;
	}

}