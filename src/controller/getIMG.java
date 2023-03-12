package controller;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class getIMG {
  public void getIMG(JTextField hinhanhField, JTextField IDField) {
    System.out.println("Select image");
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new java.io.File("."));
    FileNameExtensionFilter fileExtenstion = new FileNameExtensionFilter("jpg and png", "JPEG", "PNG", "JPG");
    fileChooser.setFileFilter(fileExtenstion);
    int returnValue = fileChooser.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      File inputFile = fileChooser.getSelectedFile();
      try {
        if (inputFile.exists()) {
          // Read Image to BufferedImage
          BufferedImage image = ImageIO.read(inputFile);
          if (image != null) {
            if (!new File("lib/Img/").exists())
              new File("lib/Img/").mkdirs();
            File outputFile = new File("lib/Img/" + IDField.getText() + ".jpg");

            hinhanhField.setText(inputFile.getName());
            ImageIO.write(image, "png", outputFile);

          } else {
            JOptionPane.showMessageDialog(null, "Can't read image from selected file");
          }
        } else {
          JOptionPane.showMessageDialog(null, "File not exist");
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}
