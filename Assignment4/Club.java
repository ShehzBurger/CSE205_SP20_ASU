public class Club {
    //Instance Variables
    private String clubName;             //Club Name
    private int numberOfMembers;         //No. of Members
    private String university;           //University
    private President currentPresident;  //President

    //Constructor
    public Club(){
        clubName = new String("?");
        university = new String("?");
        numberOfMembers = 0;
        currentPresident = new President();
    }

    //Accessors
    public String getClubName(){
        return clubName;
    }

    public int getNumberOfMembers(){
        return numberOfMembers;
    }

    public String getUniversity(){
        return university;
    }

    public President getCurrentPresident(){
        return currentPresident;
    }

    //Mutators
    public void setClubName(String a){
        clubName = a;
    }

    public void setNumberOfMembers(int a){
        numberOfMembers = a;
    }

    public void setUniversity(String uni){
        university = uni;
    }

    public void setCurrentPresident(String firstName, String lastName, String academicLevel){
        currentPresident.setFirstName(firstName);
        currentPresident.setLastName(lastName);
        currentPresident.setAcademicLevel(academicLevel);
    }

    public String toString(){
        String output = "\nClub Name:\t\t"+getClubName()+"\n"+
                "Number Of Members:\t"+getNumberOfMembers()+"\n"+
                "University:\t\t"+getUniversity()+"\n"+
                "President:\t\t"+getCurrentPresident()+"\n\n";
        return output;
    }
}
