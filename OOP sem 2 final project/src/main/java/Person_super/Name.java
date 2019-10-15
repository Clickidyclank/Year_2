package Person_super;

public class Name {

    private String fname,lname,mname;

    public Name(String fname,String lname, String mname){
        this.fname=fname;
        this.lname=lname;
        this.mname=mname;
    }

    public Name(String fname,String lname){
        this.fname=fname;
        this.lname=lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Override
    public String toString() {

        return this.fname + " "+ this.mname+" "+this.lname;
    }
}
