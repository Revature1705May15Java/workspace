package com.ex.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.ex.pojos.Student;

/**
 * StudentSerializer is currently used in place of this class.
 * 
 * @author Eric Christie
 *
 */
public class Serializer {

  public static void writeArrayList(String bytestream, ArrayList<Serializable> list) {
    try (ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream(bytestream/* , true */));) {
      oos.writeObject(list);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void writeObject(String bytestream, Serializable obj) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream));) {
      oos.writeObject(obj);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // static void writeAllObjects(String bytestream, )

  static void appendObject(String bytestream, Serializable obj) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream, true));) {
      oos.writeObject(obj);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static ArrayList<Serializable> readArrayList(String bytestream) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));) {
      @SuppressWarnings("unchecked")
      ArrayList<Serializable> list = (ArrayList<Serializable>) ois.readObject(); // how
                                                                                 // to
                                                                                 // I
                                                                                 // check
                                                                                 // the
                                                                                 // cast?
      System.out.println(list);
      return list;
    } catch (IOException | ClassNotFoundException e) { // this will have to be
                                                       // changed if we want to
      e.printStackTrace();
      return null;
    }
  }

  static Serializable readNextObject(String bytestream) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));) {
      Object obj = ois.readObject();
      Student s = (Student) obj;
      System.out.println(s);
      return s;
    } catch (IOException | ClassNotFoundException e) { // this will have to be
                                                       // changed if we want to
      e.printStackTrace();
      return null;
    }
  }

  // static ArrayList<Serializable> readAllObjects(String bytestream) {
  // try (ObjectInputStream ois = new ObjectInputStream(new
  // FileInputStream(bytestream));) {
  // int remainingBytes =
  // } catch (IOException e) {
  // e.printStackTrace();
  // }
  // }

  // public static void main(String[] args) {
  // String bytestream = "src/com/ex/serialization/bytestream.txt";
  //
  // ArrayList<Student> students = new ArrayList<Student>();
  // for (int i = 0; i < 10; i++) {
  // String fname = "Student" + i;
  // String lname = "S" + i;
  // String email = fname + "." + lname + "@email.com";
  // students.add(new Student(fname, lname, email, i));
  // }
  //
  //
  //
  //// writeObject(bytestream, o);
  //// readObject(bytestream);
  // }

}
