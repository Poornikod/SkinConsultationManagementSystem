package Gui;

import Classes.Consultation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class HomePage extends JFrame implements ActionListener {

    JButton viewDoc, bookConsultation,viewConsultation,exit;   //Initializing a buttons

    public HomePage(){

        JPanel panel1 = new JPanel();      //Initializing a panel

        add(panel1);                            //add panel
        panel1.setBackground(Color.BLACK);      //set-background color

        JLabel backGround = new JLabel();           //Initializing a background label
        backGround.setSize(400,200);    //Set background size
        Image image = new ImageIcon(Objects.requireNonNull(getClass().getResource("../Gui/photo/Home.png"))).getImage();  //adding a image
        Image imageSize = image.getScaledInstance(backGround.getWidth(),backGround.getHeight(),Image.SCALE_SMOOTH);  //Set image size
        backGround.setIcon(new ImageIcon(imageSize));

        viewDoc = new JButton("View Doc List");
        viewDoc.setBackground(Color.lightGray);
        viewDoc.setForeground(Color.BLACK);
        bookConsultation = new JButton("Book Consultation");
        bookConsultation.setBackground(Color.lightGray);
        bookConsultation.setForeground(Color.BLACK);
        viewConsultation = new JButton("View Consultation");
        viewConsultation.setBackground(Color.lightGray);
        viewConsultation.setForeground(Color.BLACK);
        exit = new JButton("Exit");
        exit.setBackground(Color.lightGray);
        exit.setForeground(Color.BLACK);

        JLabel lbl1  = new JLabel("Skin Consultation Manager",SwingConstants.CENTER);
        lbl1.setForeground(Color.WHITE);
        lbl1.setFont(new Font("SansSerif",Font.ITALIC | Font.BOLD,30));

        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;

        gbc.insets = new Insets(35,30,70,30);
        gbc.gridwidth=10;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(backGround,gbc);

        gbc.insets = new Insets(10,100,30,20);
        gbc.gridwidth=3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(lbl1,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20,10,30,10);
        gbc.gridwidth=1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(viewDoc,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel1.add(bookConsultation,gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        panel1.add(viewConsultation,gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        panel1.add(exit,gbc);

        viewDoc.addActionListener(this);
        bookConsultation.addActionListener(this);
        viewConsultation.addActionListener(this);
        exit.addActionListener(this);

        setUndecorated(true);         //Hide a close,mini-maize,show-full-size
        setLocation(400,100);  //Set Location
        pack();                    //Set gui as pack
        setVisible(true);        //set to show panel
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewDoc){
            this.dispose();
            new DocTable();
        }
        else if (e.getSource()==bookConsultation) {
            this.dispose();
            new BookConsultation();
        } else if (e.getSource()==viewConsultation) {
            this.dispose();
            new PatientRegister();

        }else if (e.getSource() == exit){
            this.dispose();
            Consultation.objectSerialization();
        }
    }
}