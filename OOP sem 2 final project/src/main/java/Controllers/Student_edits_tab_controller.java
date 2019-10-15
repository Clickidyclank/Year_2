package Controllers;

import Person_super.Student;

public class Student_edits_tab_controller {
    private General_controller general_controller;

    public Student_edits_tab_controller(General_controller general_controller) {

        this.general_controller = general_controller;


    }

    public void edit(String fname, String lname, String mname, String email, String DOB, int phoneNum,
                     String m1, String m2, String m3, String m4, String m5, String m6, int g1, int g2, int g3, int g4, int g5, int g6, Student student) {


        general_controller.getDatabase_controller().removeStudent(student);
        student.getName().setFname(fname);
        student.getName().setLname(lname);
        student.getName().setMname(mname);
        student.setDob(DOB);
        student.setEmail(email);
        student.setPhoneNum(phoneNum);
        student.getModules().get(0).setModule(m1);
        student.getModules().get(1).setModule(m2);
        student.getModules().get(2).setModule(m3);
        student.getModules().get(3).setModule(m4);
        student.getModules().get(4).setModule(m5);
        student.getModules().get(5).setModule(m6);
        student.getModules().get(0).setGrade(g1);
        student.getModules().get(0).setGrade(g2);
        student.getModules().get(0).setGrade(g3);
        student.getModules().get(0).setGrade(g4);
        student.getModules().get(0).setGrade(g5);
        student.getModules().get(0).setGrade(g6);


        general_controller.getDatabase_controller().addStudent(student);


    }


}
