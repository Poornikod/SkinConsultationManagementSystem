package Gui;

import Classes.Consultation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class PatientRegister extends JFrame implements ActionListener {

    JButton confirm,back;  //Initializing a buttons

    JTextField uniqueIdField,appointmentIdField;   //Initialing text-field

    public PatientRegister(){

        JPanel jPanel1 = new JPanel();    //Initializing a panel

        add(jPanel1);                     //add panel
        jPanel1.setBackground(Color.DARK_GRAY);    //set-background color


        JLabel appointmentId = new JLabel("Appointment Id: ",SwingConstants.LEFT); //Initializing a label
        JLabel uniqueId = new JLabel("Unique Id: ",SwingConstants.LEFT);

        jPanel1.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        uniqueIdField = new JTextField(10);
        appointmentIdField = new JTextField(10);

        confirm = new JButton("Confirm");
        back = new JButton("Back");

        gridBagConstraints.insets = new Insets(5,8,11,14);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(appointmentId,gridBagConstraints);
        appointmentId.setForeground(Color.WHITE);

        gridBagConstraints.gridx = 1;
        jPanel1.add(appointmentIdField,gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(uniqueId,gridBagConstraints);
        uniqueId.setForeground(Color.WHITE);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel1.add(uniqueIdField,gridBagConstraints);


        gridBagConstraints.gridwidth =2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel1.add(confirm,gridBagConstraints);
        confirm.setBackground(Color.lightGray);
        confirm.setForeground(Color.BLACK);


        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel1.add(back,gridBagConstraints);
        back.setBackground(Color.lightGray);
        back.setForeground(Color.BLACK);


        setUndecorated(true);     //Hide a close,mini-maize,show-full-size
        setLocation(500,200);   //Set Location
        pack();   //Set gui as pack
        setVisible(true);      //set to show panel
        confirm.addActionListener(this);
        back.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == confirm) {
            if (!Objects.equals(this.uniqueIdField.getText(),"") && ! Objects.equals(this.appointmentIdField.getText(),"")) {
                String uniqueId = this.uniqueIdField.getText().trim();
                long uniqueIdLong = Long.parseLong(uniqueId);

                String appointmentId = this.appointmentIdField.getText().trim();
                long appointmentIdLong = Long.parseLong(appointmentId);

                System.out.println(uniqueIdLong+appointmentIdLong);
                Consultation bookingConsultation = Consultation.searchBooking(uniqueIdLong, appointmentIdLong);
                if (bookingConsultation != null){
                    new ViewConsultation(bookingConsultation);
                    this.dispose();
                }

            }else {
                JOptionPane.showMessageDialog(this,"Please enter uniqueId && appointmentId!!");
            }
        } else if (e.getSource() == back) {
            this.dispose();
            new HomePage();
        }
    }
}
