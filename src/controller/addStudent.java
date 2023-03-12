package controller;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import model.Student;

public class addStudent {
  public void addStudent(Object[] inputs, DefaultTableModel tableModel, List<Student> listStudent) {
    int result = JOptionPane.showConfirmDialog(null, inputs, "Add Student",
        JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
      // Add student to table
      JTextField IDField = (JTextField) inputs[1];
      String ID = IDField.getText();
      JTextField nameField = (JTextField) inputs[3];
      String name = nameField.getText();
      JTextField markField = (JTextField) inputs[5];
      String mark = markField.getText();
      String image = ID + ".jpg";
      JTextField addressField = (JTextField) inputs[10];
      String address = addressField.getText();
      JTextField noteField = (JTextField) inputs[12];
      String note = noteField.getText();
      if (ID.equals("") || name.equals("") || image.equals("") || address.equals("")) {
        JOptionPane.showMessageDialog(null, "Please fill in all the fields: ID, Name, Image, Address");
        return;
      }
      if (listStudent != null)
        for (Student st : listStudent) {
          if (st.getID().equals(ID)) {
            JOptionPane.showMessageDialog(null, "Student already exists");
            return;
          }
        }
      if (mark.equals("")) {
        mark = "0";
      }
      Object[] row = { ID, name, mark, image, address, note };
      tableModel.addRow(row);
      Student student = new Student(ID, name, Float.parseFloat(mark), image, address, note);
      if (listStudent == null)
        listStudent = new ArrayList<Student>();
      listStudent.add(student);
      writeListStudents writeListStudent = new writeListStudents();
      writeListStudent.writeListStudent(listStudent);
    }
  }
}
