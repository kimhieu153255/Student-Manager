package controller;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class exportStudents {
  public void exportStudent(JTable table) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new java.io.File("./lib/exportCSV"));
    FileNameExtensionFilter fileExtenstion = new FileNameExtensionFilter("csv", "csv");
    fileChooser.setFileFilter(fileExtenstion);
    int choice = fileChooser.showSaveDialog(null);
    if (choice == JFileChooser.APPROVE_OPTION) {
      String path = fileChooser.getSelectedFile().getAbsolutePath();
      if (!path.toLowerCase().endsWith(".csv"))
        path += ".csv";
      try {
        File file = new File(path);
        FileWriter writer = new FileWriter(file);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.getColumnCount(); i++) {
          sb.append(table.getColumnName(i));
          if (i != table.getColumnCount() - 1)
            sb.append(",");
        }
        sb.append("\n");
        for (int i = 0; i < table.getRowCount(); i++) {
          for (int j = 0; j < table.getColumnCount(); j++) {
            sb.append(table.getValueAt(i, j));
            if (j != table.getColumnCount() - 1)
              sb.append(",");
          }
          sb.append("\n");
        }
        writer.write(sb.toString());
        writer.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}
