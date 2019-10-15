package Other_Objects;

public class Module_Grade {

    private String module;
    private int grade;


    public Module_Grade(String module,int grade){
        this.module=module;
        this.grade=grade;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
