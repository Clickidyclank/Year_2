package Person_super;

public class Person{

    private Name name;
    private String email;
    private int phoneNum;

    public Person (Name name, String email, int phoneNum){
        this.name = name;
        this.email=email;
        this.phoneNum=phoneNum;
    }


    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
}
