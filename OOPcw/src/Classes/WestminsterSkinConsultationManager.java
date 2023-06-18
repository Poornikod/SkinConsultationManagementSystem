package Classes;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    public static ArrayList<Doctor> docList = new ArrayList<>(10);     //Initializing number of 10 doctors arrayList
    public void display() throws IOException {

        WestminsterSkinConsultationManager wsc = new WestminsterSkinConsultationManager();    // Creating a Classes.WestminsterSkinConsultationManager object to call methods

        while (true) {

            System.out.println();

            System.out.println("--------------------------------------------------------------");
            System.out.println("|" + "                        Menu                           " +                                      "|");
            System.out.println("|" + "                 Available Number Of Doctors: " + Doctor.getAvailableDoctorCount() +  "        "  +    "|");
            System.out.println("--------------------------------------------------------------");
            System.out.println("| " + "   1      |     Add a new doctor                      " + "|");
            System.out.println("| " + "   2      |     Delete a doctor                       " + "|");
            System.out.println("| " + "   3      |     Print the list of the doctor          " + "|");
            System.out.println("| " + "   4      |     Save in a file                        " + "|");
            System.out.println("| " + "   5      |     Exit                                  " + "|");
            System.out.println("--------------------------------------------------------------");

            System.out.println();


            Scanner sc = new Scanner(System.in);
            int number;
            while(true){
                System.out.println("Please enter menu number:");
                try{
                    number = Integer.parseInt(sc.nextLine());
                    if(number>6 || number<1){
                        throw new Exception();
                    }
                    break;
                }catch(Exception e){
                    System.out.println("Please Enter valid input!!!");   //Console  validation
                }
            }

            if (number == 1) {               //Add a new doctor
                wsc.AddDoctor(sc);

            } else if (number == 2) {        //Delete a doctor
                wsc.DeleteDoctor(sc);

            } else if (number == 3) {        //Display sorted arraylist
                wsc.DocSortList();

            } else if (number == 4) {         //Save to file
                wsc.saveInFile();

            } else if (number == 5) {         //Exit the programme
                break;
            }
        }
    }
    @Override
    public void AddDoctor(Scanner sc) {

        String pattern = "[a-zA-Z]+";   //any character from a to z or A to Z.

//        Scanner sc = new Scanner(System.in);
        System.out.println("--------Add a new doctor--------");

        if (Doctor.getAvailableDoctorCount() < 10) {
            Doctor d1 = new Doctor();
            while(true){
                System.out.print("Please enter Doctor name:  ");
                String fName =sc.nextLine();
                if(fName.matches(pattern)){
                    d1.setName(fName);
                    break;
                }else{
                    System.out.println("name cannot contain numbers.... please try again!!!!!!!");
                }
            }
            System.out.println();
            while(true){
                System.out.print("Please enter Doctor surname:  ");
                String sName =sc.nextLine();
                if(sName.matches(pattern)){
                    d1.setSurname(sName);
                    break;
                }else{
                    System.out.println("name cannot contain numbers..... please try again!!!!!!!");
                }
            }
            System.out.println();
            while(true){
                String reg ="^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";          // Date validation using regex
                System.out.println("Please enter Date of birth:  ");
                System.out.println("--------Please enter this format--------'dd/MM/yyyy'--------");
                try{
                    String inp =sc.nextLine();
                    if(!inp.matches(reg)){
                        throw new RuntimeException();
                    }
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    d1.setDate(formatter.parse(inp));
                    break;
                }catch(ParseException | RuntimeException e){
                    System.out.println("--------Invalid Date format : Please enter this format-------- 'dd/MM/yyyy'--------\n");
                }
            }
            System.out.println();
            System.out.print("Please enter Mobile number: ");
            d1.setMobileNo(sc.next());
            String Pattern = "^[0-9]{10}$";              //https://www.javacodeexamples.com/java-regex-10-digit-mobile-number-validation/3452
            while (!d1.getMobileNo().matches(Pattern)) {
                System.out.println();
                System.out.println("--------Please enter valid mobile number--------");
                System.out.print("Please enter Mobile number: ");
                d1.setMobileNo(sc.next());
            }
            System.out.println();
           while(true){
               System.out.print("Please enter medical Licence number:  ");
               String lNumber = sc.nextLine();
               if(lNumber.length() != 10){
                   System.out.println("Medical Licence number should contain 10 digits!!!");
                   continue;
               }
               boolean flag = false;
               for(Doctor d : docList){
                   if(d.getMedicalLicenceNumber().equals(lNumber)){
                       flag = true;
                       break;
                   }
               }
               if (flag){
                   System.out.println(lNumber + " is already exist please try again!!!");
               }else {
                   d1.setMedicalLicenceNumber(lNumber);
                   break;
               }
           }
            while(true) {
                System.out.println("Please enter specialisation: ");
                String specialisation = sc.nextLine();
                if (specialisation.matches(pattern)) {
                    d1.setSpecialisation(specialisation);
                    break;
                } else {
                    System.out.println("specialisation cannot contain numbers please try again!!!");
                }
            }
            System.out.println();

            docList.add(d1);

            System.out.println("You Successfully added a doctor!!!");

        }else{
            System.out.println("You cannot add more than 10 docList!!!");
        }
    }
    @Override
    public void DeleteDoctor(Scanner sc){

//        Scanner sc = new Scanner(System.in);
        System.out.println("--------Delete a Classes.Doctor--------");
        System.out.println();
        String str;

        while (true){

            System.out.println("Please enter the medical licence number that you want to delete: ");
            str = sc.nextLine().trim();
            if (str.length()<10)
                System.out.println("Enter correct input");
            else break;
        }
        boolean isDeleted = false;

        if(Doctor.getAvailableDoctorCount()>0) {
            for(int i=0; i<Doctor.getAvailableDoctorCount(); i++){
                if (str.equals(docList.get(i).getMedicalLicenceNumber())) {
                    System.out.println("You successfully deleted the Dr." + docList.get(i).getName() + "!!" + "\n");
                    System.out.println("FirstName:      " + docList.get(i).getName());
                    System.out.println("SurName:        " + docList.get(i).getSurname());
                    System.out.println("DateOfBirth:    " + docList.get(i).getDate());
                    System.out.println("MobileNo:       " + docList.get(i).getMobileNo());
                    System.out.println("Specialisation: " + docList.get(i).getSpecialisation() + "\n");
                    docList.remove(i);
                    Doctor.setAvailableDoctorCount();
                    isDeleted = true;
                    System.out.println("--------The total amount of the docList: " + ' ' + Doctor.getAvailableDoctorCount() + "--------");
                    break;
                }
            }
        }
        if (!isDeleted) System.out.println("--------- Don't have such a doctor ---------");
    }
    @Override
    public void DocSortList(){
        System.out.println("--------Print the list of the docList--------");
        System.out.println();
        docList.sort(Doctor.DoctorComparator);       //Sorting the above list with the Collections class's sort() method
        for(Doctor str : docList){                               // Using a for, each loop to iterate over the list
            System.out.println(str);                             // Printing all List elements
            System.out.println();
        }
    }
    @Override
    public boolean saveInFile() throws IOException {
     //   try {

            FileWriter myWriter = new FileWriter("Doctors.txt");
            BufferedWriter bw = new BufferedWriter(myWriter);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            int j = 0;

            for (Doctor d1 : docList) {
                myWriter.write("FirstName: " + d1.getName() + "\n"
                        + "Surname: " + d1.getSurname() + "\n"
                        + "DateOfBirth: " + formatter.format(d1.getDate()) + "\n"
                        + "MobileNo: " + d1.getMobileNo() + "\n"
                        + "MedicalLicenceNumber: " + d1.getMedicalLicenceNumber() + "\n"
                        + "Specialisation: " + d1.getSpecialisation() + "\n" + "\n");
                j++;
            }

            myWriter.write("Stored successfully!!");
            bw.close();
            myWriter.close();
            System.out.println("Successfully wrote to the file.....");
            return j != 0;
    }
    public static void readInFile(){

        try {
            File myObj = new File("Doctors.txt");
            Scanner myReader = new Scanner(myObj);

            int i =0;

            String firstName = null;
            String surname = null;
            Date DateOfBirth = null;
            String MobileNo = null;
            String MedicalLicenceNumber = null;
            String Specialisation = null;

            while (true) {
                if (Doctor.getAvailableDoctorCount() > 10)break;
                String input = myReader.nextLine();
                i++;
                if (input.equals("Stored successfully!!")) break;
                if (i%7==1) {
                    firstName = input.split(":")[1].trim();
                }else if (i % 7==2) {
                    surname = input.split(":")[1].trim();
                } else if (i % 7==3) {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    DateOfBirth = formatter.parse(input.split(":")[1].trim());
                } else if (i % 7==4) {
                    MobileNo = input.split(":")[1].trim();
                } else if (i % 7==5) {
                    MedicalLicenceNumber = input.split(":")[1].trim();
                } else if (i % 7==6) {
                    Specialisation = input.split(":")[1].trim();
                } else if (i % 7==0) {

                    Doctor doctor = new Doctor();

                    doctor.setName(firstName);
                    doctor.setSurname(surname);
                    doctor.setDate(DateOfBirth);
                    doctor.setMobileNo(MobileNo);
                    doctor.setMedicalLicenceNumber(MedicalLicenceNumber);
                    doctor.setSpecialisation(Specialisation);
                    docList.add(doctor);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {

            System.out.println("An error occurred.....");

        }
        catch (ParseException ignored) {

        }
    }
}
