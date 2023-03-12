package controller;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import model.Student;

public class importStudents {
  public List<Student> importStudent(DefaultTableModel tableModel) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new java.io.File("./lib/importCSV"));
    fileChooser.setDialogTitle("Choose a file");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    FileNameExtensionFilter fileExtenstion = new FileNameExtensionFilter("csv", "csv");
    fileChooser.setFileFilter(fileExtenstion);
    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      tableModel.setRowCount(0);
      try (BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
        String line = br.readLine();
        line = br.readLine();
        List<Student> listStudent = new ArrayList<>();
        while (line != null) {
          String[] data = line.split(",");
          Student st = new Student(data[0], data[1], Float.parseFloat(data[2]), data[3], data[4], data[5]);
          listStudent.add(st);
          tableModel.addRow(new Object[] { data[0], data[1], data[2], data[3], data[4], data[5] });
          line = br.readLine();
        }
        writeListStudents writeListStudent = new writeListStudents();
        writeListStudent.writeListStudent(listStudent);
        br.close();
        return listStudent;
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }
    return null;
  }
}
