package Controllers;

import Other_Objects.Class_Group;
import Other_Objects.Module_Grade;
import Person_super.Name;
import Person_super.Student;

public class Add_remove_student_tab_controller {
    private General_controller general_controller;

    public Add_remove_student_tab_controller(General_controller general_controller) {

        this.general_controller = general_controller;


    }


    public void Add_student(String fname, String lname, String mname, String email, String DOB, String class_group_name, int phoneNum,
                            String m1, String m2, String m3, String m4, String m5, String m6) {


        for (Class_Group class_group : general_controller.getClass_groupObservableList()) {

            if (class_group.getName().equals(class_group_name)) {
                Name name = new Name(fname, lname, mname);
                Student student = new Student(name, email, phoneNum, DOB, class_group);

                student.getModules().add(new Module_Grade(m1, 0));
                student.getModules().add(new Module_Grade(m2, 0));
                student.getModules().add(new Module_Grade(m3, 0));
                student.getModules().add(new Module_Grade(m4, 0));
                student.getModules().add(new Module_Grade(m5, 0));
                student.getModules().add(new Module_Grade(m6, 0));

                general_controller.getDatabase_controller().addStudent(student);
                class_group.getStudentArrayList().add(student);
            }
        }


    }

    public void Remove_student(String fname, String lname, String mname, String email, String DOB, String class_group_name, int phoneNum,
                               String m1, String m2, String m3, String m4, String m5, String m6) {


        for (Class_Group class_group : general_controller.getClass_groupObservableList())
            if (class_group.getName().equals(class_group_name)) {

                if (class_group.getName().equals(class_group_name)) {
                    Name name = new Name(fname, lname, mname);
                    Student student = new Student(name, email, phoneNum, DOB, class_group);

                    student.getModules().add(new Module_Grade(m1, 0));
                    student.getModules().add(new Module_Grade(m2, 0));
                    student.getModules().add(new Module_Grade(m3, 0));
                    student.getModules().add(new Module_Grade(m4, 0));
                    student.getModules().add(new Module_Grade(m5, 0));
                    student.getModules().add(new Module_Grade(m6, 0));

                    general_controller.getDatabase_controller().removeStudent(student);
                    class_group.getStudentArrayList().remove(student);
                }


            }
    }
}
