package Classes;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Consultation implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private long appointmentId;
    static ArrayList <Consultation> consultations = new ArrayList<>();     //Initializing a consultations ArrayList
    private double cost;
    private String note;
    private Date date;
    private String time;
    private Doctor doctor;
    private Patient patient;
    private String photo;



    public Consultation(Patient patient,Doctor doctor, String notes,String photo,String time, Date date){  //Already existing patient
        this.cost = 25.0;
        this.note = notes;
        this.patient = patient;
        this.date = date;
        this.doctor = doctor;
        this.photo = photo;
        this.time = time;

        setAppointmentId();
        consultations.add(this);

    }
    public Consultation(String firstName,String surName,  //Add new Consultation
                        Date dateOfBirth, String mobileNumber,Doctor doctor,
                        String address, Date date, String notes,String photo,String time) {
        this.cost = 15.0;
        this.date = date;
        this.note = notes;
        this.doctor = doctor;
        this.photo = photo;
        this.time = time;

        this.patient = new Patient(firstName,surName,dateOfBirth,mobileNumber,address);

        setAppointmentId();
        consultations.add(this);
        Patient.getOldPatient().add(patient);
    }



    public static ArrayList<Consultation> getConsultations() {
        return consultations;
    }

    public static void setConsultations(ArrayList<Consultation> consultations) {
        Consultation.consultations = consultations;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor( Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    //getters
    public double getCost() {
        return cost;
    }

    public String getNote() {
        return note;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    //setters
    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId() {
        this.appointmentId = consultations.size() + 1;
    }

    public static void objectSerialization(){
        try
        {
            FileOutputStream fos = new FileOutputStream("ConsultationNew.txt");     //Creating FileOutputStream object

            ObjectOutputStream oos = new ObjectOutputStream(fos);    //Creating ObjectOutputStream object

            for (Consultation c : consultations) {                 //write object
                oos.writeObject(c);
            }

            oos.close();                        //close streams
            fos.close();

            System.out.println("Serialized data is saved in " + "ConsultationNew.txt");

        }catch(IOException e)
        {
            System.out.println(e);
        }
    }
    public static Date dateValidation(String date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy" );

        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public  static void objectDeSerialization(){        //Deserialize a serialize object.
        try
        {

            FileInputStream fIs = new FileInputStream("ConsultationNew.txt");    //Creating FileOutputStream object


            ObjectInputStream oIs = new ObjectInputStream(fIs);    //Creating ObjectOutputStream object


            while (true){                 //write object.
                try {
                    Consultation c= (Consultation) oIs.readObject();
                    consultations.add(c);
                   // System.out.println(c);
                }catch (EOFException e){
//                    System.out.println("End of the line...");
                    break;
                }
            }
            oIs.close();              //close streams.
            fIs.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static Consultation searchBooking(long uniqueId, long appointmentId){
        for (Consultation consultation : consultations) {
            if (consultation.patient.getUniqueID() == uniqueId && consultation.getAppointmentId() == appointmentId) {
                return consultation;
            }
        }
        JOptionPane.showMessageDialog(null,"There is no booking for this patient...");
        return null;
    }

    @Override
    public String toString() {              // Overriding  toString() method to list out consultation details
        return super.toString() + "\n" +
                "cost= " + cost + "\n" +
                "appointment id= " + appointmentId + "\n" +
                "note= " + note + "\n" +
                "date= " + date + "\n" +
                "doctor= " + doctor.toString() + "\n" +
                "patient= " + patient.toString() + "\n" +
                "time= " + time + "\n\n";
    }
}

