package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageView extends JFrame {

    Image image;

    JLabel jLabel;

    public ImageView(String filepath) {

        jLabel = new JLabel();
        if (filepath.equals("")){
            jLabel.setText("Image not found...");
        }else {
            try {
                image = ImageIO.read(new File(filepath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(400,400,Image.SCALE_SMOOTH));


            jLabel.setIcon(imageIcon);
        }


        add("Center",jLabel);

        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
