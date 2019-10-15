package Other_Objects;

import Person_super.Student;
import java.util.ArrayList;

public class Class_Group{

    private String name;
    private ArrayList<Student> studentArrayList;




    public Class_Group(String name){
        this.name = name;
        this.studentArrayList = new ArrayList<>();
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
