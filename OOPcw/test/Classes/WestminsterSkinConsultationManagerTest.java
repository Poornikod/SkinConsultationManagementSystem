package Classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class WestminsterSkinConsultationManagerTest {

    static WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
    static Scanner sc;

    static {
        try {
            sc = new Scanner(new FileReader("test/Classes/Testing.txt"));
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeAll
    public static void setManager(){
    }

    @Test
    void addDoctor() {
        manager.AddDoctor(sc);
        assertEquals(2,Doctor.getAvailableDoctorCount());
    }

    @Test
    void deleteDoctor() {

    }

    @Test
    void docSortList() {
        manager.DocSortList();
    }

    @Test
    void saveInFile() throws IOException {
        manager.saveInFile();
    }
}