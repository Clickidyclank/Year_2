package Tabs_view;

import Controllers.General_controller;
import Controllers.Teacher_edits_tab_controller;
import Person_super.Teacher;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Teacher_edits_tab_view extends Tab {


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


    private Label degrees_label;
    private TextField degrees;

    private Button edit;


    private Teacher_edits_tab_controller teacher_edits_tab_controller;


    public Teacher_edits_tab_view(General_controller general_controller, Teacher teacher) {

        this.degrees = new TextField(teacher.getDegree());
        this.degrees_label = new Label("Degree");

        this.teacher_edits_tab_controller = new Teacher_edits_tab_controller(general_controller);
        this.fname = new TextField(teacher.getName().getFname());
        this.lname = new TextField(teacher.getName().getLname());
        this.mname = new TextField(teacher.getName().getMname());
        this.email = new TextField(teacher.getEmail());

        this.phoneNum = new TextField(String.valueOf(teacher.getPhoneNum()));

        this.fname_label = new Label("First name:");
        this.lname_label = new Label("Last name:");
        this.mname_label = new Label("Middle name:");
        this.email_label = new Label("Email:");
        this.dob_label = new Label("Date of birth:");
        this.phoneNum_label = new Label("Phone number:");

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


        grid.add(phoneNum_label, 0, 5);
        grid.add(phoneNum, 1, 5);

        grid.add(degrees_label,0,6);
        grid.add(degrees,1,6);






        grid.add(edit, 0, 14);


        this.setText("Edit");

        this.setContent(grid);

        edit.setOnAction(event -> {

            teacher_edits_tab_controller.edit(
                    fname.getText(), lname.getText(),
                    mname.getText(), email.getText(),
                    Integer.parseInt(phoneNum.getText()),
                    degrees.getText(),teacher);


        });


    }

}

