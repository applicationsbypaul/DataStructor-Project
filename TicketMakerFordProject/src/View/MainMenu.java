package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Model.Ticket;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	public static Queue<Ticket> ticketQueue = new LinkedList<Ticket>();
	public MainMenu() {	
		
		buildFrame();
		buildPanel();
		setVisible(true);	
	}

	/**
	 * @return the ticketQueue
	 */
	public static Queue<Ticket> getTicketQueue() {
		return ticketQueue;
	}
	
	
	/**
	 * Builds the frame and sets the Title
	 */
	private void buildFrame() {
		setSize(450,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ticket Maker");
		getContentPane().setLayout(null);
		
	}
	
	/**
	 * Builds the panel and Label for the tile
	 * Builds the buttons that self contain the 
	 * action listeners
	 */
	private void buildPanel() {
		
		JPanel mainMenuPanel = new JPanel();
		mainMenuPanel.setBounds(0, 0, 484, 461);
		getContentPane().add(mainMenuPanel);
		mainMenuPanel.setLayout(null);
		
		JLabel mainMenuTitle = new JLabel("Ticket Main Menu");
		mainMenuTitle.setBounds(180, 11, 100, 14);
		mainMenuPanel.add(mainMenuTitle);
		
		//-------BUTTONS---------//
		
		JButton createTicketBTN = new JButton("Create Ticket");
		createTicketBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TicketMakerView();
			}
		});
		createTicketBTN.setBounds(147, 76, 146, 23);
		mainMenuPanel.add(createTicketBTN);
		
		JButton viewTicketBTN = new JButton("View Tickets");
		viewTicketBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QueueView();
			}
		});
		viewTicketBTN.setBounds(147, 126, 146, 23);
		mainMenuPanel.add(viewTicketBTN);
	}

}
