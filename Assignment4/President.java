public class President {
    //Instance Variables
    private String firstName;
    private String lastName;
    private String academicLevel;

    //Constructor
    public President(){
        firstName = new String("?");
        lastName = new String("?");
        academicLevel = new String("?");
    }

    //Accessors
    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAcademicLevel(){
        return academicLevel;
    }

    //Mutators
    public void setFirstName(String a){
        firstName = a;
    }

    public void setLastName(String b){
        lastName = b;
    }

    public void setAcademicLevel(String c) {
        academicLevel = c;
    }

    public String toString() {
        String output = getLastName()+","+getFirstName()+"("+getAcademicLevel()+")";
        return output;
    }
}
