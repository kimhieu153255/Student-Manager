package controller;

import java.io.*;
import java.util.List;

import model.Student;

public class writeListStudents {
  public void writeListStudent(List<Student> listStudent) {
    File file = new File("bin/Input.bin");
    try {
      if (!file.exists()) {
        new File("bin/").mkdirs();
        file.createNewFile();
      }
      FileOutputStream fos = new FileOutputStream("bin/Input.bin");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(listStudent);
      oos.close();
      fos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
