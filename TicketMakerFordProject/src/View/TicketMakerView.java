/**************************************************************
* Name        : TicketMakerView
* Author      : Paul Ford
* Created     : 5/7/2020
* Course      : CIS 152 Data Structures
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : Frame to create the tickets and place them in
				the queue.
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/
package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import Model.Ticket;

import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicketMakerView extends JFrame {
	public JPanel createTicketPanel;
	public Ticket ticket;

	/**
	 * create the Frame for the Ticket Maker
	 */
	public TicketMakerView() {
		createFrame();
		createPanel();
		createComponents();

		setVisible(true);
	}

	private void createPanel() {
		createTicketPanel = new JPanel();
		createTicketPanel.setBounds(0, 0, 474, 561);
		getContentPane().add(createTicketPanel);
		createTicketPanel.setLayout(null);
	}

	private void createFrame() {
		setSize(500, 600);
		setTitle("Create Ticket");
		getContentPane().setLayout(null);
	}

	private void createComponents() {

		JLabel createTicketTitle = new JLabel("Create Ticket");
		createTicketTitle.setBounds(183, 11, 99, 14);
		createTicketPanel.add(createTicketTitle);

		JLabel locationCodeLabel = new JLabel("Location Code: ");
		locationCodeLabel.setBounds(103, 72, 99, 14);
		createTicketPanel.add(locationCodeLabel);

		JSpinner locationCodeSpinner = new JSpinner();
		locationCodeSpinner.setModel(new SpinnerListModel(new String[] { "1552", "7055", "1889", "1401", "3358" }));
		locationCodeSpinner.setBounds(213, 69, 69, 20);
		createTicketPanel.add(locationCodeSpinner);

		JLabel registerNumberLabel = new JLabel("Register Number: ");
		registerNumberLabel.setBounds(90, 120, 126, 14);
		createTicketPanel.add(registerNumberLabel);

		JSpinner regNumSpinner = new JSpinner();
		regNumSpinner.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		regNumSpinner.setBounds(213, 117, 69, 20);
		createTicketPanel.add(regNumSpinner);

		JLabel dateTimeLabel = new JLabel("Date and Time:");
		dateTimeLabel.setBounds(90, 170, 139, 14);
		createTicketPanel.add(dateTimeLabel);

		JSpinner dateSpinner = new JSpinner();
		dateSpinner.setModel(new SpinnerDateModel(new Date(1588741200000L), null, null, Calendar.DAY_OF_YEAR));
		dateSpinner.setBounds(213, 167, 114, 20);
		createTicketPanel.add(dateSpinner);

		JLabel priorityLabel = new JLabel("Priority");
		priorityLabel.setBounds(103, 243, 79, 14);
		createTicketPanel.add(priorityLabel);

		JSpinner prioritySpinner = new JSpinner();
		prioritySpinner.setModel(new SpinnerNumberModel(4, 1, 4, 1));
		prioritySpinner.setBounds(213, 240, 69, 20);
		createTicketPanel.add(prioritySpinner);

		JLabel priorityExplainLabel = new JLabel("4 = Low \r\n3 = medium \r\n2 = high \r\n1 = emergency");
		priorityExplainLabel.setBounds(153, 218, 263, 14);
		createTicketPanel.add(priorityExplainLabel);

		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(183, 291, 99, 14);
		createTicketPanel.add(descriptionLabel);

		JTextArea descText = new JTextArea();
		descText.setBounds(56, 316, 363, 127);
		createTicketPanel.add(descText);

		JButton createTicketBTN = new JButton("Create Ticket");
		createTicketBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ticket ticket = new Ticket((Date) dateSpinner.getValue(), (int) regNumSpinner.getValue(),
						(String) locationCodeSpinner.getValue(), descText.getText(), (int) prioritySpinner.getValue());
				MainMenu.ticketQueue.add(ticket);
				JOptionPane.showMessageDialog(null, "Thank you for submitting your ticket.");
			}

		});
		createTicketBTN.setBounds(54, 492, 114, 23);
		createTicketPanel.add(createTicketBTN);
	}

}
