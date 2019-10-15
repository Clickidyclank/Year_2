package Tabs_view;

import Controllers.Add_remove_student_tab_controller;
import Controllers.General_controller;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Add_remove_student_tab_view extends Tab {

    private Add_remove_student_tab_controller student_tab_controller;

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
    private Label modules_label;

    private Button add;
    private Label space;
    private Button remove;


    public Add_remove_student_tab_view(General_controller general_controller) {

        this.student_tab_controller = new Add_remove_student_tab_controller(general_controller);

        this.fname = new TextField();
        this.lname = new TextField();
        this.mname = new TextField();
        this.email = new TextField();
        this.dob = new TextField();
        this.phoneNum = new TextField();
        this.m1 = new TextField();
        this.m2 = new TextField();
        this.m3 = new TextField();
        this.m4 = new TextField();
        this.m5 = new TextField();
        this.m6 = new TextField();
        this.classGroup = new TextField();
        this.classGroup_label = new Label("Class group");

        this.space = new Label();

        this.fname_label = new Label("First name:");
        this.lname_label = new Label("Last name:");
        this.mname_label = new Label("Middle name:");
        this.email_label = new Label("Email:");
        this.dob_label = new Label("Date of birth:");
        this.phoneNum_label = new Label("Phone number:");
        this.modules_label = new Label("Enter modules bellow:");

        this.add = new Button("Add");
        this.remove = new Button("Remove");


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

        grid.add(classGroup_label, 0, 6);
        grid.add(classGroup, 1, 6);


        grid.add(modules_label, 0, 7);


        grid.add(m1, 0, 8);
        grid.add(m2, 1, 8);
        grid.add(m3, 0, 9);
        grid.add(m4, 1, 9);
        grid.add(m5, 0, 10);
        grid.add(m6, 1, 10);


        grid.add(add, 0, 14);
        grid.add(remove, 0, 15);

        this.setText("Add/Remove Student");

        this.setContent(grid);


        add.setOnAction(event -> {
            student_tab_controller.Add_student(
                    fname.getText(), lname.getText(),
                    mname.getText(), email.getText(),
                    dob.getText(), classGroup.getText(),
                    Integer.parseInt(phoneNum.getText()),
                    m1.getText(), m2.getText(),
                    m3.getText(), m4.getText(),
                    m5.getText(), m6.getText());

            fname.clear();
            lname.clear();
            mname.clear();
            email.clear();
            dob.clear();
            classGroup.clear();
            phoneNum.clear();
            m1.clear();
            m2.clear();
            m3.clear();
            m4.clear();
            m5.clear();
            m6.clear();
        });

        remove.setOnAction(event -> {
            student_tab_controller.Remove_student(
                    fname.getText(), lname.getText(),
                    mname.getText(), email.getText(),
                    dob.getText(), classGroup.getText(),
                    Integer.parseInt(phoneNum.getText()),
                    m1.getText(), m2.getText(),
                    m3.getText(), m4.getText(),
                    m5.getText(), m6.getText());

            fname.clear();
            lname.clear();
            mname.clear();
            email.clear();
            dob.clear();
            classGroup.clear();
            phoneNum.clear();
            m1.clear();
            m2.clear();
            m3.clear();
            m4.clear();
            m5.clear();
            m6.clear();
        });


    }

}

