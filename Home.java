package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    public Home(){
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/bgImage.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0, 1600, 800);
        add(image);
        
        JLabel heading = new JLabel("WELCOMES TO INDIAN AIRLINES");
        heading.setBounds(500, 40, 1000, 40);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("POPPINS", Font.PLAIN, 36));
        image.add(heading);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellication = new JMenuItem("Cancel Ticket");
        ticketCancellication.addActionListener(this);
        details.add(ticketCancellication);
        
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem downloadbordingpass = new JMenuItem("Bording Pass");
        downloadbordingpass.addActionListener(this);
        ticket.add(downloadbordingpass);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String text = ae.getActionCommand();
        
        if(text.equals("Add Customer Details")){
            new AddCustomer();
        }else if(text.equals("Flight Details")){
            new flightInfo();
        }else if(text.equals("Book Flight")){
            new bookFlight();
        }else if(text.equals("Journey Details")){
            new journeyDetails();
        }else if(text.equals("Cancel Ticket")){
            new cancel();
        }else if(text.equals("Bording Pass")){
            new bordingPass();
        }
    }
    
    public static void main(String[] args){
        new Home();
    }
}

