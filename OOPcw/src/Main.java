import Classes.Consultation;
import Classes.WestminsterSkinConsultationManager;
import Gui.HomePage;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Consultation.objectDeSerialization();
        WestminsterSkinConsultationManager.readInFile();
        selection();
    }
    public static void selection(){

        boolean isGetting = true;

        while (isGetting){

            Scanner sc = new Scanner(System.in);
            System.out.println("------------------------------------------"  + "\n");
            System.out.println("Choose an option");
            System.out.println("1.  Console Menu");
            System.out.println("2.  GUI");
            System.out.println("------------------------------------------" + "\n");
            System.out.println("Choose an Option: ");

            try {

                int selection = Integer.parseInt(sc.nextLine());
                if (selection == 1) {

                    WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
                    manager.display();

                }
                else if (selection == 2) {
                    new HomePage();
                    isGetting = false;
                }
                else {
                    System.out.println("Invalid Input!!!");
                }
            }
            catch (NumberFormatException exception) {
                System.out.println("Invalid input...Please try again!!!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
