package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class bordingPass extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, tfnationality, tfsrc, tfdest, labelfname, labelfcode, tfdate;
    JButton enterButton;
    
    public bordingPass(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Indian Airlines");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        JLabel subheading = new JLabel("Boading Pass");
        subheading.setBounds(360, 50, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(subheading);
        
        JLabel lbpnr = new JLabel("PNR DETAILS");
        lbpnr.setBounds(60, 100, 150, 25);
        lbpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbpnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);
        
        enterButton = new JButton("Enter");
        enterButton.setBackground(Color.BLACK);
        enterButton.setForeground(Color.WHITE);
        enterButton.setBounds(380, 100, 120, 25);
        enterButton.addActionListener(this);
        add(enterButton);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        JLabel lblsrc = new JLabel("SRC");
        lblsrc.setBounds(60, 220, 150, 25);
        lblsrc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsrc);
        
        tfsrc = new JLabel();
        tfsrc.setBounds(220, 220, 150, 25);
        add(tfsrc);
        
        JLabel lbldest = new JLabel("DEST");
        lbldest.setBounds(380, 220, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        tfdest = new JLabel();
        tfdest.setBounds(540, 220, 150, 25);
        add(tfdest);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 260, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        tfdate = new JLabel();
        tfdate.setBounds(220, 300, 150, 25);
        add(tfdate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);
        
        setSize(1000, 450);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String pnr = tfpnr.getText();
        
        try{
            Conn conn = new Conn();
            
            String query = "select * from reservation where pnr = '"+pnr+"' ";
               
            ResultSet rs = conn.s.executeQuery(query);
                
            if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfsrc.setText(rs.getString("src"));
                    tfdest.setText(rs.getString("des"));
                    labelfname.setText(rs.getString("flightname"));
                    labelfcode.setText(rs.getString("flightcode"));
                    tfdate.setText(rs.getString("ddate"));
                   
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR");
                }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new bordingPass();
    }
}

