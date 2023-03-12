import java.util.List;

import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.EmptyBorder;

import controller.*;
import model.Student;
import renderer.*;

public class App extends JPanel implements ActionListener {
  private DefaultTableModel tableModel;
  private List<Student> listStudent;
  private JTable studentTable;
  private JTextField imageField, IDField;

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Add")) {
      System.out.println("Add");
      IDField = new JTextField();
      JTextField nameField = new JTextField();
      JTextField markField = new JTextField();

      imageField = new JTextField();
      imageField.setEditable(false);
      JButton btnSelectImg = new JButton("Select Image");
      btnSelectImg.addActionListener(this);
      btnSelectImg.setActionCommand("Selector");

      JTextField addressField = new JTextField();
      JTextField noteField = new JTextField();
      Object[] inputs = { "Student ID:", IDField, "Name:", nameField, "Mark:", markField, "Avatar:", imageField,
          btnSelectImg, "Address", addressField, "Note", noteField };
      addStudent addStudent = new controller.addStudent();
      addStudent.addStudent(inputs, tableModel, listStudent);
    }
    if (e.getActionCommand().equals("Selector")) {
      getIMG getIMG = new getIMG();
      getIMG.getIMG(imageField, IDField);
    }
    if (e.getActionCommand().equals("Edit")) {
      System.out.println("Edit");
      // display selected row GUI
      IDField = new JTextField();
      Object[] options = { "Enter ID:", IDField };
      int check = JOptionPane.showConfirmDialog(null, options, "Edit Student", JOptionPane.OK_CANCEL_OPTION);
      if (check == JOptionPane.OK_OPTION) {
        // get row index
        int row = -1;
        for (Student st : listStudent) {
          if (st.getID().equals(IDField.getText())) {
            row = listStudent.indexOf(st);
            break;
          }
        }
        if (row == -1) {
          JOptionPane.showMessageDialog(null, "Student not found");
          return;
        }
        // get selected row data
        JTextField IDField = new JTextField(studentTable.getValueAt(row, 0).toString());
        JTextField nameField = new JTextField(studentTable.getValueAt(row, 1).toString());
        JTextField markField = new JTextField(studentTable.getValueAt(row, 2).toString());
        imageField = new JTextField(studentTable.getValueAt(row, 3).toString());
        imageField.setEditable(false);
        JButton btnSelectImg = new JButton("Select Image");
        btnSelectImg.addActionListener(this);
        btnSelectImg.setActionCommand("Selector");

        JTextField addressField = new JTextField(studentTable.getValueAt(row, 4).toString());
        JTextField noteField = new JTextField(studentTable.getValueAt(row, 5).toString());
        Object[] inputs = { "Student ID:", IDField, "Name:", nameField, "Mark:",
            markField, "Avatar:", imageField,
            btnSelectImg, "Address", addressField, "Note", noteField };

        editStudent editStudent = new editStudent();
        editStudent.editStudent(inputs, tableModel, listStudent, row);
      }
    }
    if (e.getActionCommand().equals("Delete")) {
      System.out.println("Delete");
      deleteStudent deleteStudent = new controller.deleteStudent();
      deleteStudent.deleteStudent(listStudent, tableModel);
    }
    if (e.getActionCommand().equals("Export")) {
      System.out.println("Export");
      exportStudents exportStudent = new exportStudents();
      exportStudent.exportStudent(studentTable);
    }
    if (e.getActionCommand().equals("Import")) {
      System.out.println("Import");
      importStudents importStudent = new importStudents();
      listStudent = importStudent.importStudent(tableModel);
    }
  }

  public App() {
    setLayout(new BorderLayout());
    JPanel bottomPanel = new JPanel();
    JPanel listJPanel = new JPanel();

    // set center panel
    listJPanel.setLayout(new BorderLayout());
    String[] columnNames = { "Student ID", "Name", "Mark", "Avatar", "Address", "Note" };
    tableModel = new DefaultTableModel(columnNames, 0);

    // rendering Student list to table
    listStudent = new readListStudents().readList();
    if (listStudent != null) {
      for (Student student : listStudent) {
        Object[] data = { student.getID(), student.getName(), student.getMark(), student.getAvatar(),
            student.getAddress(), student.getNote() };
        tableModel.addRow(data);
      }
    }

    // set center align for cell in table
    studentTable = new JTable(tableModel);
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    studentTable.setDefaultRenderer(Object.class, centerRenderer);

    // encrease row height
    Dimension d = studentTable.getPreferredSize();
    studentTable.getTableHeader().setPreferredSize(new Dimension(d.width, studentTable.getRowHeight() * 4));

    // set row sorter
    studentTable.setAutoCreateRowSorter(true);
    // Disable direct editing on cells
    studentTable.setEnabled(false);
    // Disable column reordering
    studentTable.getTableHeader().setReorderingAllowed(false);
    studentTable.setRowHeight(100);
    // Change imageFile to
    studentTable.getColumnModel().getColumn(3).setCellRenderer(new ImageCellRenderer());
    JScrollPane scrollPane = new JScrollPane(studentTable);
    listJPanel.add(scrollPane, BorderLayout.CENTER);

    // set bottom panel
    JButton btnDelete = new JButton("Delete");
    btnDelete.addActionListener(this);
    btnDelete.setActionCommand("Delete");

    JButton btnEdit = new JButton("Edit");
    btnEdit.addActionListener(this);
    btnEdit.setActionCommand("Edit");

    JButton btnAdd = new JButton("Add");
    btnAdd.addActionListener(this);
    btnAdd.setActionCommand("Add");

    JButton btnExport = new JButton("Export");
    btnExport.addActionListener(this);
    btnExport.setActionCommand("Export");

    JButton btnImport = new JButton("Import");
    btnImport.addActionListener(this);
    btnImport.setActionCommand("Import");

    bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
    bottomPanel.add(btnDelete);
    bottomPanel.add(Box.createHorizontalStrut(10));
    bottomPanel.add(btnEdit);
    bottomPanel.add(Box.createHorizontalStrut(10));
    bottomPanel.add(btnAdd);
    bottomPanel.add(Box.createHorizontalStrut(10));
    bottomPanel.add(btnExport);
    bottomPanel.add(Box.createHorizontalStrut(10));
    bottomPanel.add(btnImport);
    JPanel wrFooter = new JPanel();
    wrFooter.setLayout(new FlowLayout());
    wrFooter.add(bottomPanel);

    // set main panel
    listJPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
    add(wrFooter, BorderLayout.PAGE_END);
    add(listJPanel, BorderLayout.CENTER);

  }

  private static void createAndShowGui() {
    JFrame.setDefaultLookAndFeelDecorated(true);

    JFrame frame = new JFrame("Student Management");
    frame.setPreferredSize(new Dimension(900, 600));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    App newContainPane = new App();
    newContainPane.setOpaque(true);
    frame.setContentPane(newContainPane);

    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    createAndShowGui();
  }
}
