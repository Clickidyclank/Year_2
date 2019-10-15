package Controllers;

public class Create_class_tab_controller {

    private General_controller general_controller;

    public Create_class_tab_controller(General_controller general_controller) {
        this.general_controller = general_controller;
    }

    public void createClass(String Class_group_name){

        general_controller.getDatabase_controller().createClass(Class_group_name);



    }

}
