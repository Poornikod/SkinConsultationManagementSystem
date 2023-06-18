package Classes;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;
        private String name;
        private String surname;
        private String mobileNo;
        private Date date;
        private String address;
        public Person(){}
        public Person(String name,String surname,String mobileNo,Date date,String address){
            this.name=name;
            this.surname=surname;
            this.mobileNo =mobileNo;
            this.date = date;
            this.address = address;
        }
        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public Date getDate() {
            return date;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        //setters
        public void setName(String name) {
            this.name = name;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getAddress() {
        return address;
        }

        public void setAddress(String address) {
        this.address = address;
        }

    public static boolean nameValidation(String firstName,String surName) {    //name Validation

        if (firstName.equals("") || surName.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public static Date dobValidation(String dOB) {    //dob validation

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            return dateFormat.parse(dOB);

        } catch (ParseException e) {
            return null;
        }
    }

    public static boolean mobileNumValidation(String mobileNo) {    //mobile-number-validation

        if (mobileNo.equals("")) {
            return false;
        } else if (mobileNo.length() != 10){
            return false;
        }
        else return true;
    }

    public static boolean addressValidation(String address) {     //address validation

        return !address.equals("");
    }


    public static String noteValidation(String noteF) {   //note validation

        if (noteF.equals("")) {
            return null;
        } else {
            return noteF;
        }
    }

    @Override
    public String toString() {
        return
                "name= " + name + "\n" +
                "surname= " + surname + "\n" +
                "mobileNo= " + mobileNo + "\n" +
                "date= " + date + "\n" +
                "address= " + address + "\n\n";
    }
}





