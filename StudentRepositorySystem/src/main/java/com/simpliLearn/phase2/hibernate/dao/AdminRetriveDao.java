package com.simpliLearn.phase2.hibernate.dao;

import com.simpliLearn.phase2.hibernate.model.Class;
import com.simpliLearn.phase2.hibernate.model.Student;
import com.simpliLearn.phase2.hibernate.model.Subject;
import com.simpliLearn.phase2.hibernate.model.Teacher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class AdminRetriveDao {
 private DataSource dataSource;


 public AdminRetriveDao(DataSource datasource2) {
	 this.dataSource = datasource2;
}

public List<Student> getStudents() {
     List<Student> students = new ArrayList<Student>();
     Connection myConn = null;
     Statement myStmt = null;
     ResultSet myRs = null;

     try {
         myConn = this.dataSource.getConnection();
         String sql = "SELECT * FROM students";
         myStmt = myConn.createStatement();
         myRs = myStmt.executeQuery(sql);

         while(myRs.next()) {
             int id = myRs.getInt("id");
             String firstName = myRs.getString("fname");
             String lastName = myRs.getString("lname");
             int age = myRs.getInt("age");
             int aclass = myRs.getInt("class");
             Student tempStudent = new Student(id, firstName, lastName, age, aclass);
             students.add(tempStudent);
         }
     } catch (Exception var15) {
     } finally {
         this.close(myConn, myStmt, myRs);
     }

     return students;
 }

 public List<Teacher> getTeachers() {
     List<Teacher> teachers = new ArrayList<Teacher>();
     Connection myConn = null;
     Statement myStmt = null;
     ResultSet myRs = null;

     try {
         myConn = this.dataSource.getConnection();
         String sql = "SELECT * FROM teachers";
         myStmt = myConn.createStatement();
         myRs = myStmt.executeQuery(sql);

         while(myRs.next()) {
             int id = myRs.getInt("id");
             String firstName = myRs.getString("fname");
             String lastName = myRs.getString("lname");
             int age = myRs.getInt("age");
             Teacher temp = new Teacher(id, firstName, lastName, age);
             teachers.add(temp);
         }
     } catch (Exception var14) {
     } finally {
         this.close(myConn, myStmt, myRs);
     }

     return teachers;
 }

 public List<Subject> getSubjects() {
     List<Subject> subjects = new ArrayList<Subject>();
     Connection myConn = null;
     Statement myStmt = null;
     ResultSet myRs = null;

     try {
         myConn = this.dataSource.getConnection();
         String sql = "SELECT * FROM subjects";
         myStmt = myConn.createStatement();
         myRs = myStmt.executeQuery(sql);

         while(myRs.next()) {
             int id = myRs.getInt("id");
             String name = myRs.getString("name");
             String shortcut = myRs.getString("shortcut");
             Subject temp = new Subject(id, name, shortcut);
             subjects.add(temp);
         }
     } catch (Exception var13) {
     } finally {
         this.close(myConn, myStmt, myRs);
     }

     return subjects;
 }

 public List<Class> getClasses() {
     List<Class> classes = new ArrayList<Class>();
     Connection myConn = null;
     Statement myStmt = null;
     ResultSet myRs = null;

     try {
         myConn = this.dataSource.getConnection();
         String sql = "SELECT * FROM classes";
         myStmt = myConn.createStatement();
         myRs = myStmt.executeQuery(sql);

         while(myRs.next()) {
             int id = myRs.getInt("id");
             int section = myRs.getInt("section");
             int subject = myRs.getInt("subject");
             int teacher = myRs.getInt("teacher");
             String time = myRs.getString("time");
             Teacher tempTeacher = this.loadTeacher(teacher);
             Subject tempSubject = this.loadSubject(subject);
             String teacher_name = tempTeacher.getFname() + " " + tempTeacher.getLname();
             Class temp = new Class
            		 (id, section, teacher_name, 
            				 tempSubject.getName(), time);
             classes.add(temp);
         }
     } catch (Exception var18) {
     } finally {
         this.close(myConn, myStmt, myRs);
     }

     return classes;
 }

 public Teacher loadTeacher(int teacherId) {
     Teacher theTeacher = null;
     Connection myConn = null;
     Statement myStmt = null;
     ResultSet myRs = null;

     try {
         myConn = this.dataSource.getConnection();
         String sql = "SELECT * FROM teachers WHERE id = " + teacherId;
         myStmt = myConn.createStatement();

         int id;
         String fname;
         String lname;
         int age;
         for(myRs = myStmt.executeQuery(sql); myRs.next(); theTeacher = new Teacher(id, fname, lname, age)) {
             id = myRs.getInt("id");
             fname = myRs.getString("fname");
             lname = myRs.getString("lname");
             age = myRs.getInt("age");
         }
     } catch (Exception var14) {
     } finally {
         this.close(myConn, myStmt, myRs);
     }

     return theTeacher;
 }

 public Subject loadSubject(int subjectId) {
     Subject theSubject = null;
     Connection myConn = null;
     Statement myStmt = null;
     ResultSet myRs = null;

     try {
         myConn = this.dataSource.getConnection();
         String sql = "SELECT * FROM subjects WHERE id = " + subjectId;
         myStmt = myConn.createStatement();

         int id;
         String name;
         String shortcut;
         for(myRs = myStmt.executeQuery(sql); myRs.next(); theSubject = new Subject(id, name, shortcut)) {
             id = myRs.getInt("id");
             name = myRs.getString("name");
             shortcut = myRs.getString("shortcut");
         }
     } catch (Exception var13) {
     } finally {
         this.close(myConn, myStmt, myRs);
     }

     return theSubject;
 }

 public Class loadClass(int classId) {
     Class theClass = null;
     Connection myConn = null;
     Statement myStmt = null;
     ResultSet myRs = null;

     try {
         myConn = this.dataSource.getConnection();
         String sql = "SELECT * FROM clasess WHERE id = " + classId;
         myStmt = myConn.createStatement();
         myRs = myStmt.executeQuery(sql);

         while(myRs.next()) {
             int id = myRs.getInt("id");
             int section = myRs.getInt("section");
             int subject = myRs.getInt("subject");
             int teacher = myRs.getInt("teacher");
             String time = myRs.getString("time");
             Teacher tempTeacher = this.loadTeacher(teacher);
             this.loadSubject(subject);
             (new StringBuilder(String.valueOf(tempTeacher.getFname()))).append(" ").append(tempTeacher.getLname()).toString();
         }
     } catch (Exception var18) {
     } finally {
         this.close(myConn, myStmt, myRs);
     }

     return (Class)theClass;
 }

 public List<Student> loadClassStudents(int classId) {
     List<Student> students = new ArrayList<Student>();
     Connection myConn = null;
     Statement myStmt = null;
     ResultSet myRs = null;

     try {
         myConn = this.dataSource.getConnection();
         String sql = "SELECT * FROM students WHERE class = " + classId;
         myStmt = myConn.createStatement();
         myRs = myStmt.executeQuery(sql);

         while(myRs.next()) {
             int id = myRs.getInt("id");
             String firstName = myRs.getString("fname");
             String lastName = myRs.getString("lname");
             int age = myRs.getInt("age");
             int aclass = myRs.getInt("class");
             Student tempStudent = new Student(id, firstName, lastName, age, aclass);
             students.add(tempStudent);
         }
     } catch (Exception var16) {
     } finally {
         this.close(myConn, myStmt, myRs);
     }

     return students;
 }

 private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
     try {
         if (myRs != null) {
             myRs.close();
         }

         if (myStmt != null) {
             myStmt.close();
         }

         if (myConn != null) {
             myConn.close();
         }
     } catch (Exception var5) {
         var5.printStackTrace();
     }

 }
}
