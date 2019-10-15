package Person_super;

public class Teacher extends Person{

    private Name name;
    private String degree;

    public Teacher(Name name, String email, int phoneNum,String degree){
        super(name, email, phoneNum);
        this.degree=degree;
    }


    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }


    @Override
    public String toString() {

        return super.getName().toString() + "\n"+this.degree;
    }
}
