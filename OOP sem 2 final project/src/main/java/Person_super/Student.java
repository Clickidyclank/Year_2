package Person_super;

import Other_Objects.Class_Group;
import Other_Objects.Module_Grade;

import java.util.ArrayList;

public class Student extends Person {


    private Class_Group class_group;
    private String dob;
    private ArrayList<Module_Grade> modules;

    public Student(Name name, String email, int phoneNum, String dob, Class_Group class_group) {
        super(name,email,phoneNum);
        this.class_group = class_group;
        this.dob = dob;
        this.modules = new ArrayList<>();


    }


    public Class_Group getClass_group() {
        return class_group;
    }

    public void setClass_group(Class_Group class_group) {
        this.class_group = class_group;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public ArrayList<Module_Grade> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module_Grade> modules) {
        this.modules = modules;
    }

    public void addModule(Module_Grade module){
        modules.add(module);
    }

    @Override
    public String toString() {

        return super.getName().toString() + "\n"+this.getDob()+"\n"+this.getClass_group();
    }
}
