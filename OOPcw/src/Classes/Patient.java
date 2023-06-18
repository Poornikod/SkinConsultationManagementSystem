package Classes;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Patient extends Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 3L;
    private long uniqueID;
    private static  ArrayList<Patient> oldPatient = new ArrayList<>();

    public Patient(long uniqueID) {
        this.uniqueID = uniqueID;
    }

    public Patient(String firstName, String surName,
                   Date dateOfBirth, String mobileNumber,
                   String address) {
        super(firstName,surName,mobileNumber,dateOfBirth,address);
        setUniqueID();
    }

    public void patient(long uniqueID){
        this.uniqueID =uniqueID;
    }

    //getters

    public long getUniqueID() {
        return uniqueID;
    }

    //setters

    public void setUniqueID() {
        this.uniqueID = oldPatient.size() + 1;
    }

    public static ArrayList<Patient> getOldPatient() {
        return oldPatient;
    }

    @Override
    public String toString() {       // Overriding  toString() method to list out patient details
        return super.toString()+
                "uniqueID = " + uniqueID + "\n";
    }
    public static Patient findPatientByName(String name, String surname){   //check whether the patient already exits
        for (Patient patient : oldPatient) {
            if (patient.getName().equals(name) && patient.getSurname().equals(surname)) {
                return patient;
            }
        }
        return null;
    }
}
