package controller;

import java.io.File;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

import model.Student;

public class deleteStudent {
  public void deleteStudent(List<Student> listStudent, DefaultTableModel tableModel) {
    JTextField idField = new JTextField();
    Object[] options = { "Enter ID:", idField };
    int check = JOptionPane.showConfirmDialog(null, options, "Delete Student", JOptionPane.OK_CANCEL_OPTION);
    if (check == JOptionPane.OK_OPTION) {
      // get row index
      int row = -1;
      for (Student st : listStudent) {
        if (st.getID().equals(idField.getText())) {
          row = listStudent.indexOf(st);
          break;
        }
      }
      if (row == -1) {
        JOptionPane.showMessageDialog(null, "Student not found");
        return;
      }
      int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this student?",
          "Conform Delete Student", JOptionPane.YES_NO_OPTION);
      if (result == JOptionPane.YES_OPTION) {
        tableModel.removeRow(row);
        listStudent.remove(row);
        File file = new File("lib/Img/" + idField.getText() + ".jpg");
        file.delete();
        writeListStudents writeListStudent = new writeListStudents();
        writeListStudent.writeListStudent(listStudent);
      }
    }
  }
}
