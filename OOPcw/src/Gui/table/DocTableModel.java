package Gui.table;

import Classes.Consultation;
import Classes.Doctor;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DocTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Name","Specialisation","MedicalLicenceNumber"};  //Initializing a String array
    private final Doctor[] myList = new Doctor[10];    //Initializing a doctor array

    private int rawCount=0;

    public DocTableModel(ArrayList<Doctor> bkList){
        for (int i = 0; i < 10; i++) {
            if (bkList.size()==i) break;
            if (bkList.get(i)!=null) myList[i]= bkList.get(i);
            rawCount++;
        }
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount(){
        return rawCount;
    }

    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = myList[row].getName()+" "+myList[row].getSurname();
        }
        else if (col == 1) {
            temp = myList[row].getSpecialisation();
        }
        else if (col == 2) {
            temp = myList[row].getMedicalLicenceNumber();
        }
        return temp;
    }

    // needed to show column names in JTable
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Doctor[] getMyList() {
        return myList;
    }

    public Class <?> getColumnClass(int col) {
        return String.class;
    }
}
