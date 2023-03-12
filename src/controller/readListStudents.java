package controller;

import java.io.*;
import java.util.*;

import model.Student;

public class readListStudents {
  public List<Student> readList() {
    // Path to file
    String filePath = "bin/Input.bin";
    List<Student> students = new ArrayList<>();
    // Read data from file
    if (!new File(filePath).exists())
      return null;
    try (FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
      while (fis.available() > 0) {
        students = (List<Student>) ois.readObject();
      }
      ois.close();
      fis.close();
      return students;
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }
}
