package Gui;

import Classes.Doctor;
import Classes.DoctorComparator;
import Classes.WestminsterSkinConsultationManager;
import Gui.table.DocTableModel;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class DocTable extends JFrame implements ActionListener {

    JPanel jPanel = new JPanel();   //Implementing a panel
    JButton back;                  //Implementing a button
    JTable table;                  //Implementing a table

    public DocTable(){

        initializer();
        add(jPanel);                                //add to panel
        jPanel.setBackground(Color.DARK_GRAY);      //Set background color

        back = new JButton("Back");
        back.setBackground(Color.lightGray);
        back.setForeground(Color.WHITE);

        jPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.insets = new Insets(20,20,0,20);     //set a layout
        gbc.gridwidth=3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        jPanel.add(table.getTableHeader(),gbc);
        table.setBackground(Color.darkGray);
        table.setForeground(Color.WHITE);

        gbc.insets = new Insets(0,20,10,20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        jPanel.add(table,gbc);

        gbc.gridwidth=3;
        gbc.gridx = 1;
        gbc.gridy = 2;
        jPanel.add(back,gbc);
        back.setBackground(Color.lightGray);
        back.setForeground(Color.BLACK);

        setUndecorated(true);   //Hide a close,mini-maize,show-full-size
        setLocation(500,100);  //Set Location
        pack();                 //Set gui as pack
        setVisible(true);          //set to show panel
        back.addActionListener(this);
    }

    public void initializer() {

//        WestminsterSkinConsultationManager.readInFile();

        ArrayList<Doctor> myList = WestminsterSkinConsultationManager.docList;    //IIT Lecture Slides
        // ... Here some code to fill the array list with Book objects
        myList.sort(new DoctorComparator());
        DocTableModel tableModel = new DocTableModel(myList);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setPreferredSize(new Dimension(200,300));

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();                           //Close the window
        new HomePage();                           //ActionListener
    }
}


