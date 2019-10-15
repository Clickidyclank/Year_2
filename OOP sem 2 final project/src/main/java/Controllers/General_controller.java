package Controllers;

import Other_Objects.Class_Group;
import Person_super.Teacher;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class General_controller {

    private Database_controller database_controller;
    private ObservableList<Class_Group> class_groupObservableList;
    private ObservableList<Teacher> teacherObservableList;
    private Stage stage;

    public General_controller(Stage stage) {
        this.stage=stage;

        database_controller = new Database_controller();

        class_groupObservableList = database_controller.loadClassGroups();
        teacherObservableList = database_controller.loadTeachers();
    }


    public Database_controller getDatabase_controller() {
        return database_controller;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setDatabase_controller(Database_controller database_controller) {
        this.database_controller = database_controller;
    }

    public ObservableList<Class_Group> getClass_groupObservableList() {
        return class_groupObservableList;
    }

    public void setClass_groupObservableList(ObservableList<Class_Group> class_groupObservableList) {
        this.class_groupObservableList = class_groupObservableList;
    }

    public ObservableList<Teacher> getTeacherObservableList() {
        return teacherObservableList;
    }

    public void setTeacherObservableList(ObservableList<Teacher> teacherObservableList) {
        this.teacherObservableList = teacherObservableList;
    }
}
