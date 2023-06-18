package Gui;

import Classes.Consultation;
import Classes.Person;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;


public class  ViewConsultation extends JFrame implements ActionListener {

     JButton back,uploadedPhoto;   //Initializing buttons

     Consultation bookingConsultation;

    public ViewConsultation(Consultation bookingConsultationN){

        this.bookingConsultation = bookingConsultationN;

        JPanel jPanel1 = new JPanel();


        add(jPanel1);
        jPanel1.setBackground(Color.DARK_GRAY);

        JLabel jLabel1 = new JLabel("Booked Consultation",SwingConstants.CENTER);
        jLabel1.setFont(new Font("SansSerif",Font.ITALIC | Font.BOLD ,15));

        JLabel jLabel2 = new JLabel("First Name: ",SwingConstants.LEFT);
        JLabel jLabel3 = new JLabel("Surname: ",SwingConstants.LEFT);
        JLabel jLabel4 = new JLabel("DOB:(dd/mm/YYYY) ",SwingConstants.LEFT);
        JLabel jLabel5 = new JLabel("Mobile number: ",SwingConstants.LEFT);
        JLabel jLabel6 = new JLabel("Address: ",SwingConstants.LEFT);
        JLabel jLabel7 = new JLabel("Date:(dd/mm/YYYY) ",SwingConstants.LEFT);
        JLabel jLabel8 = new JLabel("Notes: ",SwingConstants.LEFT);
        JLabel jLabel9 = new JLabel("Selected doctor: ",SwingConstants.LEFT);
        JLabel jLabel10 = new JLabel("Time : ",SwingConstants.LEFT);
        JLabel jLabel11 = new JLabel("Expenses : ",SwingConstants.LEFT);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy mm/HH");
        Person person = bookingConsultation.getPatient();
        String fName = bookingConsultation.getDoctor().getName() + " " + bookingConsultation.getDoctor().getSurname();

        JLabel firstNameBlank = new JLabel(person.getName());
        JLabel surNameBlank = new JLabel(person.getSurname());
        JLabel dOBBlank = new JLabel(simpleDateFormat.format(person.getDate()));
        JLabel mobileNumberBlank = new JLabel(person.getMobileNo());
        JLabel addressBlank = new JLabel(person.getAddress());
        JLabel dateBlank = new JLabel(simpleDateFormat1.format(bookingConsultation.getDate()));
        JLabel noteBlank = new JLabel(bookingConsultation.getNote());
        JLabel selectADoctorBlank = new JLabel(fName);
        JLabel time = new JLabel(bookingConsultation.getTime());
        JLabel expenses = new JLabel(String.valueOf(bookingConsultation.getCost()));


        back = new JButton("Back");
        uploadedPhoto = new JButton("ImageUploaded");


        jPanel1.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        gridBagConstraints.insets = new Insets(30,20,20,20);
        gridBagConstraints.gridwidth=3;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jLabel1,gridBagConstraints);
        jLabel1.setForeground(Color.WHITE);

        gridBagConstraints.insets = new Insets(0,40,10,20);
        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(jLabel2,gridBagConstraints);
        jLabel2.setForeground(Color.WHITE);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel1.add(jLabel3,gridBagConstraints);
        jLabel3.setForeground(Color.WHITE);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel1.add(jLabel4,gridBagConstraints);
        jLabel4.setForeground(Color.WHITE);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel1.add(jLabel5,gridBagConstraints);
        jLabel5.setForeground(Color.WHITE);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        jPanel1.add(jLabel6,gridBagConstraints);
        jLabel6.setForeground(Color.WHITE);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanel1.add(jLabel7,gridBagConstraints);
        jLabel7.setForeground(Color.WHITE);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        jPanel1.add(jLabel8,gridBagConstraints);
        jLabel8.setForeground(Color.WHITE);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        jPanel1.add(jLabel9,gridBagConstraints);
        jLabel9.setForeground(Color.WHITE);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        jPanel1.add(jLabel10,gridBagConstraints);
        jLabel10.setForeground(Color.WHITE);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        jPanel1.add(jLabel11,gridBagConstraints);
        jLabel11.setForeground(Color.WHITE);

        gridBagConstraints.insets = new Insets(0,20,10,40);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel1.add(firstNameBlank,gridBagConstraints);
        firstNameBlank.setForeground(Color.WHITE);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel1.add(surNameBlank,gridBagConstraints);
        surNameBlank.setForeground(Color.WHITE);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel1.add(dOBBlank,gridBagConstraints);
        dOBBlank.setForeground(Color.WHITE);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        jPanel1.add(mobileNumberBlank,gridBagConstraints);
        mobileNumberBlank.setForeground(Color.WHITE);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        jPanel1.add(addressBlank,gridBagConstraints);
        addressBlank.setForeground(Color.WHITE);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        jPanel1.add(dateBlank,gridBagConstraints);
        dateBlank.setForeground(Color.WHITE);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        jPanel1.add(noteBlank,gridBagConstraints);
        noteBlank.setForeground(Color.WHITE);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        jPanel1.add(selectADoctorBlank,gridBagConstraints);
        selectADoctorBlank.setForeground(Color.WHITE);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        jPanel1.add(time,gridBagConstraints);
        time.setForeground(Color.WHITE);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        jPanel1.add(expenses,gridBagConstraints);
        expenses.setForeground(Color.WHITE);

        gridBagConstraints.insets = new Insets(30,20,20,20);
        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        jPanel1.add(back,gridBagConstraints);
        back.setBackground(Color.lightGray);
        back.setForeground(Color.BLACK);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        jPanel1.add(uploadedPhoto,gridBagConstraints);
        uploadedPhoto.setBackground(Color.lightGray);
        uploadedPhoto.setForeground(Color.BLACK);

        setUndecorated(true);              //Hide a close,mini-maize,show-full-size
        setLocation(400,100);       //Set Location
        pack();                         //Set gui as pack
        setVisible(true);              //set to show panel
        back.addActionListener(this);
        uploadedPhoto.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            this.dispose();
            new PatientRegister();

        } else if (e.getSource() == uploadedPhoto) {
            if (bookingConsultation.getPhoto()!=null){
                new ImageView(bookingConsultation.getPhoto());
            }else JOptionPane.showMessageDialog(this,"No images found... ");
        }
    }
}
