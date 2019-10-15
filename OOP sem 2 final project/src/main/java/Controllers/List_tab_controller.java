package Controllers;

import Person_super.Person;
import Person_super.Student;
import Person_super.Teacher;
import Tabs_view.Listing_tab_view;
import Tabs_view.Student_edits_tab_view;
import Tabs_view.Teacher_edits_tab_view;

public class List_tab_controller {


    private General_controller general_controller;
    private Listing_tab_view listing_tab_view;

    public List_tab_controller(General_controller general_controller,Listing_tab_view listing_tab_view) {
        this.listing_tab_view = listing_tab_view;
        this.general_controller = general_controller;

    }



    public void edit(Person person){

        if(person instanceof Teacher){
            Teacher_edits_tab_view teacher_edits_tab_view =new Teacher_edits_tab_view(general_controller,(Teacher)person);
            listing_tab_view.getTabPane().getTabs().add(teacher_edits_tab_view);

        }
        else {
            Student_edits_tab_view student_edits_tab_view = new Student_edits_tab_view(general_controller,(Student)person);
            listing_tab_view.getTabPane().getTabs().add(student_edits_tab_view);
        }
    }


}
