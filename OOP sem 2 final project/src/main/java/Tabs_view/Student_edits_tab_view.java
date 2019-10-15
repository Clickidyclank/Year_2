package Tabs_view;

import Controllers.General_controller;
import Controllers.Student_edits_tab_controller;
import Person_super.Student;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Student_edits_tab_view extends Tab {



    private TextField fname;
    private Label fname_label;

    private TextField lname;
    private Label lname_label;

    private TextField mname;
    private Label mname_label;

    private TextField dob;
    private Label dob_label;

    private TextField email;
    private Label email_label;

    private TextField phoneNum;
    private Label phoneNum_label;

    private TextField classGroup;
    private Label classGroup_label;

    private TextField m1;
    private TextField m2;
    private TextField m3;
    private TextField m4;
    private TextField m5;
    private TextField m6;
    private TextField g1;
    private TextField g2;
    private TextField g3;
    private TextField g4;
    private TextField g5;
    private TextField g6;
    private Label modules_label;

    private Button edit;
    private Label space;
    private Button remove;

    private Student_edits_tab_controller student_edits_tab_controller;


    public Student_edits_tab_view(General_controller general_controller, Student student) {

        this.student_edits_tab_controller  = new Student_edits_tab_controller(general_controller);
        this.fname = new TextField(student.getName().getFname());
        this.lname = new TextField(student.getName().getLname());
        this.mname = new TextField(student.getName().getMname());
        this.email = new TextField(student.getEmail());
        this.dob = new TextField(student.getDob());
        this.phoneNum = new TextField(String.valueOf(student.getPhoneNum()));
        this.m1 = new TextField(student.getModules().get(0).getModule());
        this.m2 = new TextField(student.getModules().get(1).getModule());
        this.m3 = new TextField(student.getModules().get(2).getModule());
        this.m4 = new TextField(student.getModules().get(3).getModule());
        this.m5 = new TextField(student.getModules().get(4).getModule());
        this.m6 = new TextField(student.getModules().get(5).getModule());
        this.g1 = new TextField(String.valueOf(student.getModules().get(0).getGrade()));
        this.g2 = new TextField(String.valueOf(student.getModules().get(1).getGrade()));
        this.g3 = new TextField(String.valueOf(student.getModules().get(2).getGrade()));
        this.g4 = new TextField(String.valueOf(student.getModules().get(3).getGrade()));
        this.g5 = new TextField(String.valueOf(student.getModules().get(4).getGrade()));
        this.g6 = new TextField(String.valueOf(student.getModules().get(5).getGrade()));
        this.classGroup = new TextField(student.getClass_group().getName());
        this.classGroup_label = new Label("Class group");

        this.space = new Label();

        this.fname_label = new Label("First name:");
        this.lname_label = new Label("Last name:");
        this.mname_label = new Label("Middle name:");
        this.email_label = new Label("Email:");
        this.dob_label = new Label("Date of birth:");
        this.phoneNum_label = new Label("Phone number:");
        this.modules_label = new Label("Enter modules bellow:");

        this.edit = new Button("Edit");


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(0);
        grid.setHgap(15.0D);

        grid.add(fname_label, 0, 0);
        grid.add(fname, 1, 0);

        grid.add(lname_label, 0, 1);
        grid.add(lname, 1, 1);

        grid.add(mname_label, 0, 2);
        grid.add(mname, 1, 2);

        grid.add(email_label, 0, 3);
        grid.add(email, 1, 3);

        grid.add(dob_label, 0, 4);
        grid.add(dob, 1, 4);

        grid.add(phoneNum_label, 0, 5);
        grid.add(phoneNum, 1, 5);

        grid.add(modules_label, 0, 7);


        grid.add(m1, 1, 8);
        grid.add(g1,2,8);

        grid.add(m2, 1, 9);
        grid.add(g2,2,9);

        grid.add(m3, 1, 10);
        grid.add(g3,2,10);

        grid.add(m4, 1, 11);
        grid.add(g4,2,11);

        grid.add(m5, 1, 12);
        grid.add(g5,2,12);

        grid.add(m6, 1, 13);
        grid.add(g6,2,13);




        grid.add(edit, 0, 14);


        this.setText("Edit");

        this.setContent(grid);

        edit.setOnAction(event -> {

            student_edits_tab_controller.edit(
                    fname.getText(), lname.getText(),
                    mname.getText(), email.getText(),
                    dob.getText(),
                    Integer.parseInt(phoneNum.getText()),
                    m1.getText(), m2.getText(),
                    m3.getText(), m4.getText(),
                    m5.getText(), m6.getText(),
                    Integer.parseInt(g1.getText()),Integer.parseInt(g2.getText()),
                    Integer.parseInt(g3.getText()),Integer.parseInt(g4.getText()),
                    Integer.parseInt( g5.getText()),Integer.parseInt(g6.getText()),student);


        });




    }

}

