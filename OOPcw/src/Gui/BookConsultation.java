package Gui;

import Classes.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class BookConsultation extends JFrame implements ActionListener {

    JButton bookConsultation, back, upload;  //Initializing buttons
    JTextField firstName, surName, dateOfBirth, mobileNumber, note, date, addressF, selectAnImage;     //Initializing a text-field
    String imagesPaths;  //Initializing a ArrayList

    JComboBox doctorDropDown;   //Initializing a dropdown
    JComboBox<String> timeAllocation;

    public BookConsultation() {
        JPanel jPanel1 = new JPanel();      //Initializing a panel


        add(jPanel1);                              //add to panel
        jPanel1.setBackground(Color.DARK_GRAY);    // set-background color

        JLabel jLabel1 = new JLabel("Registration Form",SwingConstants.CENTER);          //Initializing a  label
        jLabel1.setFont(new Font("SansSerif",Font.ITALIC | Font.BOLD ,15));   //set-font size
        jLabel1.setForeground(Color.WHITE);

        JLabel jLabel2 = new JLabel("First Name:",SwingConstants.LEFT);
        jLabel2.setForeground(Color.WHITE);
        JLabel jLabel3 = new JLabel("Surname:",SwingConstants.LEFT);
        jLabel3.setForeground(Color.WHITE);
        JLabel jLabel4 = new JLabel("Date of Birth(dd/mm/yyyy):",SwingConstants.LEFT);
        jLabel4.setForeground(Color.WHITE);
        JLabel jLabel5 = new JLabel("Mobile number:",SwingConstants.LEFT);
        jLabel5.setForeground(Color.WHITE);
        JLabel jLabel6 = new JLabel("Address:",SwingConstants.LEFT);
        jLabel6.setForeground(Color.WHITE);
        JLabel jLabel7 = new JLabel("Date(dd/mm/yyyy):",SwingConstants.LEFT);
        jLabel7.setForeground(Color.WHITE);
        JLabel jLabel8 = new JLabel("Notes:",SwingConstants.LEFT);
        jLabel8.setForeground(Color.WHITE);
        JLabel jLabel9 = new JLabel("Select a doctor:",SwingConstants.LEFT);
        jLabel9.setForeground(Color.WHITE);
        JLabel jLabel10 = new JLabel("Select an Image:",SwingConstants.LEFT);
        jLabel10.setForeground(Color.WHITE);
        JLabel jLabel11 = new JLabel("Time:",SwingConstants.LEFT);
        jLabel11.setForeground(Color.WHITE);

         firstName = new JTextField(15);      //Call the text-fields
         surName = new JTextField(15);
         dateOfBirth = new JTextField(15);
         mobileNumber = new JTextField(15);
         note = new JTextField(15);
         date = new JTextField(15);
         addressF = new JTextField(15);
         selectAnImage = new JTextField(15);

         ArrayList<String> doctors = new ArrayList<>();
         for (Doctor d: WestminsterSkinConsultationManager.docList){
             doctors.add(d.getName()+" "+d.getSurname());
         }

         String[] time = new String[]{"9.00-10.00 am","11.00-12.00 pm",
                 "1.00-2.00 pm","3.00-4.00 pm","5.00-6.00 pm","7.00-8.00 pm"};    //Initializing time slot Array


         doctorDropDown = new JComboBox(doctors.toArray());   //Call the dropdown
         timeAllocation =new JComboBox<>(time);


         bookConsultation = new JButton("Book Consultation");   //Call the buttons
         bookConsultation.setBackground(Color.lightGray);
         bookConsultation.setForeground(Color.BLACK);
         back = new JButton("Back");
         back.setBackground(Color.lightGray);
         back.setForeground(Color.BLACK);
         upload = new JButton("Upload");
         upload.setBackground(Color.lightGray);
         upload.setForeground(Color.BLACK);

        jPanel1.setLayout(new GridBagLayout());     //Set a Layout
        GridBagConstraints gridBagConstraints = new GridBagConstraints();    //Create a grid-dBag-Constrains Object
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        gridBagConstraints.insets = new Insets(30,20,20,20);
        gridBagConstraints.gridwidth=3;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jLabel1,gridBagConstraints);

        gridBagConstraints.insets = new Insets(0,20,10,20);
        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(jLabel2,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel1.add(jLabel3,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel1.add(jLabel4,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel1.add(jLabel5,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        jPanel1.add(jLabel6,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanel1.add(jLabel7,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        jPanel1.add(jLabel8,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        jPanel1.add(jLabel9,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        jPanel1.add(jLabel10,gridBagConstraints);


        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        jPanel1.add(jLabel11,gridBagConstraints);


        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel1.add(firstName,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel1.add(surName,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel1.add(dateOfBirth,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        jPanel1.add(mobileNumber,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        jPanel1.add(addressF,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        jPanel1.add(date,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        jPanel1.add(note,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        jPanel1.add(doctorDropDown,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        jPanel1.add(timeAllocation,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        jPanel1.add(upload,gridBagConstraints);

        gridBagConstraints.insets = new Insets(30,20,20,20);
        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        jPanel1.add(bookConsultation,gridBagConstraints);

        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        jPanel1.add(back,gridBagConstraints);


        setUndecorated(true);      //Hide a close,mini-maize,show-full-size
        setLocation(500,90);  //Set Location
        pack();                    //Set gui as pack
        setVisible(true);         //set to show panel
        bookConsultation.addActionListener(this);
        back.addActionListener(this);
        upload.addActionListener(this);
    }
    public void uploadPhoto() {      //Add a photo

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        jfc.removeChoosableFileFilter(jfc.getAcceptAllFileFilter());
        jfc.setDialogTitle("My files");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image files", ImageIO.getReaderFileSuffixes());
        jfc.addChoosableFileFilter(filter);
//        jfc.setMultiSelectionEnabled(true);
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File files = jfc.getSelectedFile();
            imagesPaths = files.getAbsolutePath();
//            for (int i = 0; i < 3; i++) {
//                if (files.length == i) break;
//                imagesPaths.add(files[i].getAbsolutePath());
//                System.out.println(imagesPaths.get(i));
//            }
        }
    }

    public boolean saveInformation(){    //Save data

        boolean isAdded = false;

        String firstNameText = firstName.getText();
        String surname = surName.getText();
        String dOB = dateOfBirth.getText();
        String mobileNumberText = mobileNumber.getText();
        String notes = note.getText();
        String selectedDate = date.getText();
        String address = addressF.getText();
        String doctorDropDown1 = (String) doctorDropDown.getSelectedItem();
        String time = (String) timeAllocation.getSelectedItem();

        Doctor doctor =  Doctor.selectedDoctor(doctorDropDown1);
//        if (!isAvailable(doctor)){
//            doctor = selectRandomDoctor();
//        }

        if (Person.nameValidation(firstNameText,surname)){       // Call the name validation method
            if (Person.dobValidation(dOB) != null){              //Call the dob validation
                if (Person.mobileNumValidation(mobileNumberText)){      //Call mobileNo validation
                    if (Person.addressValidation(address)){            //Call the address validation method
                        if (Consultation.dateValidation(selectedDate) != null){   //Call the date validation method

                            Date date1 =Consultation.dateValidation(selectedDate);
                            System.out.println(date1);
                            boolean isDoctorAvailable = Doctor.checkDocAvailable(date1, time,doctor);
                            if (!isDoctorAvailable) {
                                JOptionPane.showMessageDialog(this,"The selected doctor is not available at that time");
                                doctor = Doctor.randomlyAssignDoc(Consultation.dateValidation(selectedDate), time);
                                System.out.println(doctor);
                                if (doctor!=null) {
                                    JOptionPane.showMessageDialog(this, "Randomly added Dr."
                                            + doctor.getName() + " " + doctor.getSurname());
                                }
                            }
                            if (doctor!=null){
                                Consultation consultation;
                                Patient alreadyExists = Patient.findPatientByName(firstNameText, surname);
                                if (alreadyExists == null) {
                                    consultation = new Consultation(firstNameText, surname, Patient.dobValidation(dOB), mobileNumberText,
                                            doctor,
                                            address, Consultation.dateValidation(selectedDate), notes, imagesPaths, time);
                                } else {

                                    consultation = new Consultation(alreadyExists, doctor, notes, imagesPaths, time, Consultation.dateValidation(selectedDate));
                                }
                                consultation.setTime(time);

                                System.out.println(consultation.toString());

                                isAdded = true;
                            }else {
                                JOptionPane.showMessageDialog(this,"No any doctor available");
                            }


                        }else if (Consultation.dateValidation(selectedDate) == null){
                            JOptionPane.showMessageDialog(this,"Enter the correct date format....");
                        }
                    } else  {
                        JOptionPane.showMessageDialog(this,"Field can't be empty");
                    }
                } else if (!Person.mobileNumValidation(mobileNumberText)) {
                    JOptionPane.showMessageDialog(this,"Enter the Mobile Number in correct format");
                }
            }
            else if(Person.dobValidation(dOB) == null) {
                JOptionPane.showMessageDialog(this,"Enter the correct date format....");
            }
        } else if (!Person.nameValidation(firstNameText,surname)) {
            JOptionPane.showMessageDialog(this,"Fields can't be empty...");
        }
        return isAdded;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== bookConsultation){
             boolean added =  saveInformation();
            if (added) {
                JOptionPane.showMessageDialog(this,"Booking Confirmed!!");
                this.dispose();
                new HomePage();
            }
        }
        else if (e.getSource() == back) {
            this.dispose();
            new HomePage();
        }
        else if (e.getSource() == upload) {
//            this.dispose();
            this.uploadPhoto();
        }
    }

//    public boolean isAvailable(Doctor doctor){    //Check whether is available Doctor method
//
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");   //Simple date format
//
//        for (Consultation c :
//                Consultation.getConsultations()) {
//            Date date1;
//            try {
//                date1 = formatter.parse(date.getText());
//            } catch (ParseException e) {
//
//                throw new RuntimeException(e);
//            }
//            if (c.getDate() == null){
//                continue;
//            }
//            if (c.getDate().equals(date1) && c.getTime().equals(timeAllocation.getSelectedItem())
//                    && c.getDoctor().getMedicalLicenceNumber().equals(doctor.getMedicalLicenceNumber()) ) {
//                return false;
//            }
//        }
//
//        return true;
//    }

//    public Doctor selectRandomDoctor(){       //Random doctor adding method
//        for (Doctor doc : WestminsterSkinConsultationManager.docList){
//            if (doc != null){
//                if (isAvailable(doc)) {
//                    return doc;
//                };
//            }
//        }
//        return null;
//    }
}
