package controller;

import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

import model.Student;

public class editStudent {
  public void editStudent(Object[] inputs, DefaultTableModel tableModel, List<Student> listStudent, int row) {
    int result = JOptionPane.showConfirmDialog(null, inputs, "Edit student",
        JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
      // Get data from inputs
      JTextField IDField = (JTextField) inputs[1];
      String ID = IDField.getText();
      System.out.println(ID);
      JTextField nameField = (JTextField) inputs[3];
      String name = nameField.getText();
      JTextField markField = (JTextField) inputs[5];
      String mark = markField.getText();
      String image = ID + ".jpg";
      System.out.println(image);
      JTextField addressField = (JTextField) inputs[10];
      String address = addressField.getText();
      JTextField noteField = (JTextField) inputs[12];
      String note = noteField.getText();
      Object[] rowd = { ID, name, mark, image, address, note };

      tableModel.removeRow(row);
      tableModel.insertRow(row, rowd);
      listStudent.set(row, new Student(ID, name, Float.parseFloat(mark), image, address, note));
      writeListStudents writeListStudent = new writeListStudents();
      writeListStudent.writeListStudent(listStudent);
    }
  }
}
