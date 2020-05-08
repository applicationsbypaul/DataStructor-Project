/**************************************************************
* Name        : QueueView
* Author      : Paul Ford
* Created     : 5/7/2020
* Course      : CIS 152 Data Structures
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : Queueview is the Frame that will list the views
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/
package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Model.Ticket;

public class QueueView extends JFrame {
    // updated labels for the view
    private JLabel updateStoreCode;
    private JLabel updateDateLabel;
    private JLabel updatePrioLabel;
    private JLabel updateRegNumLabel;
    private JTextPane descTextPane;
    private JLabel updateNumTickets;

    private Object[] tickets;
    // counter to keep track of what ticket we are on
    private int currentTicket = 0;
    public JPanel queueViewPanel;

    /**
     * Constructor that first checks if the queue is empty.
     * If it is it tells the user to open tickets and will now open the frame
     */
    public QueueView() {

        if (MainMenu.ticketQueue.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There are no tickets in the que, please add tickets first.");
            return;
        }

        createFrame();
        createPanel();
        createComponents();
        createButtons();

        startView();

        setVisible(true);
    }
    /**
     * creates the buttons. 
     * Each action is in each button
     */
    private void createButtons() {
        JButton prevTicketBTN = new JButton("prev");
        prevTicketBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                goPrev();
            }
        });
        prevTicketBTN.setBounds(10, 202, 72, 23);
        queueViewPanel.add(prevTicketBTN);

        JButton nextTicketBTN = new JButton("next");
        nextTicketBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goNext();
            }
        });
        nextTicketBTN.setBounds(332, 202, 72, 23);
        queueViewPanel.add(nextTicketBTN);

        JButton completeTicketBTN = new JButton("Complete Ticket");
        completeTicketBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeTicket();
            }
        });
        // completeTicketBTN.setMnemonic(KeyEvent.VK_ENTER);
        completeTicketBTN.setBounds(152, 388, 137, 23);
        queueViewPanel.add(completeTicketBTN);

        JButton orderByBTN = new JButton("Order By Priority");
        orderByBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectionSort();
            }
        });
        orderByBTN.setBounds(152, 479, 137, 23);
        queueViewPanel.add(orderByBTN);

    }
    /**
     * Creates the components for the panel
     */
    private void createComponents() {

        JLabel storeNumLabel = new JLabel("Store Code");
        storeNumLabel.setBounds(168, 11, 84, 14);
        queueViewPanel.add(storeNumLabel);

        updateStoreCode = new JLabel("");
        updateStoreCode.setBorder(new LineBorder(Color.BLACK));
        updateStoreCode.setBounds(168, 36, 72, 14);
        queueViewPanel.add(updateStoreCode);

        JLabel dateTimeLabel = new JLabel("Date and Time");
        dateTimeLabel.setBounds(62, 89, 109, 14);
        queueViewPanel.add(dateTimeLabel);

        JLabel priorityLabel = new JLabel("Priority");
        priorityLabel.setBounds(267, 89, 46, 14);
        queueViewPanel.add(priorityLabel);

        JLabel registerNumLabel = new JLabel("Register Number");
        registerNumLabel.setBounds(152, 153, 101, 14);
        queueViewPanel.add(registerNumLabel);

        JLabel descLabel = new JLabel("Description");
        descLabel.setBounds(168, 219, 84, 14);
        queueViewPanel.add(descLabel);

        updateDateLabel = new JLabel("");
        updateDateLabel.setBorder(new LineBorder(Color.BLACK));
        updateDateLabel.setBounds(10, 114, 184, 14);
        queueViewPanel.add(updateDateLabel);

        updatePrioLabel = new JLabel("");
        updatePrioLabel.setBorder(new LineBorder(Color.BLACK));
        updatePrioLabel.setBounds(256, 114, 72, 14);
        queueViewPanel.add(updatePrioLabel);

        updateRegNumLabel = new JLabel("");
        updateRegNumLabel.setBorder(new LineBorder(Color.BLACK));
        updateRegNumLabel.setBounds(168, 178, 60, 14);
        queueViewPanel.add(updateRegNumLabel);

        descTextPane = new JTextPane();
        descTextPane.setBounds(67, 245, 281, 116);
        queueViewPanel.add(descTextPane);

        JLabel numticketsLabel = new JLabel("Number of Tickets: ");
        numticketsLabel.setBounds(95, 422, 125, 14);
        queueViewPanel.add(numticketsLabel);

        updateNumTickets = new JLabel("0");
        updateNumTickets.setBounds(284, 422, 46, 14);
        queueViewPanel.add(updateNumTickets);
    }

    private void createPanel() {
        queueViewPanel = new JPanel();
        queueViewPanel.setBounds(10, 11, 464, 539);
        getContentPane().add(queueViewPanel);
        queueViewPanel.setLayout(null);
    }

    private void createFrame() {
        setSize(500, 600);
        setTitle("View Ticket");
        getContentPane().setLayout(null);
    }
    /**
     * This method resets the view by grabbing an updated queue
     * the filling the data into Frame
     */
    public void startView() {
        tickets = (MainMenu.ticketQueue.toArray());
        currentTicket = 0;
        Ticket temp = (Ticket) tickets[currentTicket];
        fillData(temp);

    }
    /**
     * Fills the data from the ticket
     * @param temp is the current ticket we are viewing
     */
    public void fillData(Ticket temp) {
        updateDateLabel.setText(temp.getTime().toString());
        updatePrioLabel.setText(String.valueOf(temp.getPriority()));
        updateRegNumLabel.setText(String.valueOf(temp.getRegNumber()));
        updateStoreCode.setText(String.valueOf(temp.getLocationCode()));
        descTextPane.setText(temp.description);
        updateNumTickets.setText(String.valueOf(MainMenu.ticketQueue.size()));
    }
    /**
     * checks to see if it is at the end
     * if it is reset the current ticket and fill data.
     */
    public void goNext() {
        if (currentTicket == MainMenu.ticketQueue.size() - 1) {
            currentTicket = 0;
        } else {
            currentTicket++;
        }
        fillData((Ticket) tickets[currentTicket]);

    }
/**
     * checks to see if it is at the start
     * if it is reset the current ticket and fill data.
     */
    public void goPrev() {
        if (currentTicket == 0) {
            currentTicket = MainMenu.ticketQueue.size() - 1;
        } else {
            currentTicket--;
        }
        fillData((Ticket) tickets[currentTicket]);
    }
    /**
     * Remove ticket will prompt the user if it is the last ticket
     * then dispose of the frame
     * otherwise remove ticket from the queue.
     */
    public void removeTicket() {
        if (MainMenu.ticketQueue.size() == 1) {
            JOptionPane.showMessageDialog(null, "CONGRADULATIONS YOUR QUEUE IS EMPTY");
            updateDateLabel.setText("");
            updatePrioLabel.setText("");
            updateRegNumLabel.setText("");
            updateStoreCode.setText("");
            descTextPane.setText("");
            MainMenu.ticketQueue.remove((Ticket) tickets[currentTicket]);
            currentTicket = 0;
            dispose();
            return;
        }
        MainMenu.ticketQueue.remove((Ticket) tickets[currentTicket]);
        startView();
    }

    /**
     * sorts the queue by priority
     */
    public void selectionSort() {
        if(MainMenu.ticketQueue.size() <= 2){
            JOptionPane.showMessageDialog(null, "There are only two tickets in the queue");
            return;
        }

        Ticket[] array =  new Ticket[MainMenu.ticketQueue.size()];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = (Ticket) tickets[i];
       }
        int n = array.length;
       for (int i = 0; i < n-1; i++) 
       { 
           // Find the minimum element in unsorted array 
           int min_idx = i; 
           for (int j = i+1; j < n; j++) 
               if (array[j].getPriority() < array[min_idx].getPriority()) 
                   min_idx = j; 
 
           // Swap the found minimum element with the first 
           // element 
           Ticket temp = array[min_idx]; 
           array[min_idx] = array[i]; 
           array[i] = temp; 
       } 
    

        MainMenu.ticketQueue.clear();
        for (int i = 0; i < array.length; i++) {
           MainMenu.ticketQueue.add(array[i]);
        }
        startView();
    
    }
}

