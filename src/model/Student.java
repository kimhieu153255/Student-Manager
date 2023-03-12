package model;

import java.io.*;

public class Student implements Serializable {
  private static final long serialVersionUID = 1L;
  private String ID; // student ID
  private String Name; // Student name
  private float mark; // Everage mark
  private String avatar; // Avatar
  private String address; // Address
  private String note; // Note

  public Student(String ID, String Name, float mark, String avatar, String address, String note) {
    this.ID = ID;
    this.Name = Name;
    this.mark = mark;
    this.avatar = avatar;
    this.address = address;
    this.note = note;
  }

  public String getID() {
    return ID;
  }

  public String getName() {
    return Name;
  }

  public float getMark() {
    return mark;
  }

  public String getAvatar() {
    return avatar;
  }

  public String getAddress() {
    return address;
  }

  public String getNote() {
    return note;
  }
}
