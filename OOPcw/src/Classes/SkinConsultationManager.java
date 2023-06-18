package Classes;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public interface SkinConsultationManager {
     void AddDoctor(Scanner sc) throws ParseException;
     void DeleteDoctor(Scanner sc);
     void DocSortList();
     boolean saveInFile() throws IOException;

}
