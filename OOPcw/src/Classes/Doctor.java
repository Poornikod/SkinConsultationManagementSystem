package Classes;

import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

public class Doctor extends Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;
    private String medicalLicenceNumber;
    private String specialisation;
    private static int availableDoctorCount;

    public Doctor() {
        availableDoctorCount++;
    }

    public Doctor(String name, String surName, String address, Date dOB,String mobileNumber){
        super(name,surName,mobileNumber,dOB,address);
        availableDoctorCount++;
    }

    public static Doctor selectedDoctor(String doc){
            for (int i = 0; i < WestminsterSkinConsultationManager.docList.size(); i++) {
                String docFullName = WestminsterSkinConsultationManager.docList.get(i).getName() + " " +
                        WestminsterSkinConsultationManager.docList.get(i).getSurname();
                if (doc.equals(docFullName)){
                    return WestminsterSkinConsultationManager.docList.get(i);
                }
            }
            return null;
    }
    public static int getAvailableDoctorCount() {
        return availableDoctorCount;
    }

    public static void setAvailableDoctorCount() {
        Doctor.availableDoctorCount = availableDoctorCount-1;
    }
    //getters

    public String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    //setters

    public void setMedicalLicenceNumber(String medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public static Comparator<Doctor> DoctorComparator = new Comparator<Doctor>() {    // Using a comparator
        @Override
        public int compare(Doctor o1, Doctor o2){     // Comparing attributes of doctors
            return o1.getSurname().compareTo(o2.getSurname());   // Returning in ascending order
        }
    };

    public static boolean checkDocAvailable(Date date, String time, Doctor doctor){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (Consultation c:
        Consultation.getConsultations()){
            if (c.getDoctor().medicalLicenceNumber.equals(doctor.medicalLicenceNumber)){
                if (format.format(c.getDate()).equals(format.format(date)) &&
                        c.getTime().equals(time))
                    return false;
            }
        }

        return  true;
    }

    public static Doctor randomlyAssignDoc(Date date,String time){
        for (Doctor d: WestminsterSkinConsultationManager.docList){
            if (d == null) continue;
            if (checkDocAvailable(date,time,d)) return d;
        }
        return null;
    }

    public String toString(){                            // Overriding  toString() method to list out doctor details
        return "FirstName: "+ getName() +"\n"
                +"Surname: "+ getSurname()+"\n"
                +"DateOfBirth: "+ getDate()+"\n"
                +"MobileNo: "+ getMobileNo() +"\n"
                +"MedicalLicenceNumber: "+ getMedicalLicenceNumber()+"\n"
                +"Specialisation: "+ getSpecialisation() + "\n\n";
    }
}



