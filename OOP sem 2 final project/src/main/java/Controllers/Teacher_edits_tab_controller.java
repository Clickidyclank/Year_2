package Controllers;

import Person_super.Teacher;

public class Teacher_edits_tab_controller {

    private General_controller general_controller;

public Teacher_edits_tab_controller(General_controller general_controller){
    this.general_controller = general_controller;
}


    public void edit(String fname, String lname, String mname, String email, int phoneNum, String degree,Teacher teacher){

        general_controller.getDatabase_controller().removeTeacher(teacher);
        teacher.getName().setFname(fname);
        teacher.getName().setLname(lname);
        teacher.getName().setMname(mname);
        teacher.setEmail(email);
        teacher.setDegree(degree);
        teacher.setPhoneNum(phoneNum);



        general_controller.getDatabase_controller().addTeacher(teacher);


    }
}
