// Assignment #: 8
//         Name: Shehzad Anwar
//    StudentID: 1216575295
//      Lecture: 1:30PM TTh
//  Description: ClubManagement is meant to organize the information that is inputted and make sure that everything is formatted correctly.
import java.io.Serializable;

public class ClubManagement implements Serializable {
    private Club[] clubList; //List of clubs
    private int numberOfClubs;  //Number of Clubs
    private int maxSize;    //Maximum Size

    public ClubManagement(int sizemax){
        this.maxSize = sizemax;
        clubList = new Club[maxSize];
        for(int i = 0; i<this.maxSize; i++){
            clubList[i] = null;
        }
        numberOfClubs = 0;
    }

    public int clubExists (String name, String university) {
        //Goes through the array to check if an object with the same name and university exists
        for(int i = 0; i<this.numberOfClubs; i++){
            if(clubList[i].getClubName().equals(name) && clubList[i].getUniversity().equals(university)) {
                return i;
            }
        }
        return -1;
    }

    public int currentPresidentExists (String firstName, String lastName, String academicLevel) {
        for(int i = 0; i < numberOfClubs; i++){
            //Goes through the array to check if an identical object exists
            if(clubList[i].getCurrentPresident().getFirstName().equals(firstName) && clubList[i].getCurrentPresident().getLastName().equals(lastName) && clubList[i].getCurrentPresident().getAcademicLevel().equals(academicLevel)){
                return i;
            }
        }
        return -1;
    }

    public boolean addClub (String clubName, int numberOfClubs, String uni, String firstName, String lastName, String academicLvl) {
        //Checks if array is at capacity
        if(currentPresidentExists(firstName,lastName,academicLvl) != -1 || numberOfClubs ==maxSize) {
            return false;
        }
        else{
            //Create a Club Object, assign it a President
                clubList[this.numberOfClubs] = new Club(clubName, uni, numberOfClubs);
                clubList[this.numberOfClubs].setCurrentPresident(firstName, lastName, academicLvl);
                this.numberOfClubs++;
                return true;
            }
    }

    boolean removeClub (String clubName, String university) {
        //If the song doesn't exist, do nothing
        if(clubExists(clubName, university)==-1){
            return false;
        }else{
            //If it does, get the index its located at
            int index = clubExists(clubName, university);
            //If it is at the end of the array, set to null
            if(index == numberOfClubs){
                clubList[index] = null;
            }else{
                //Go through rest of array and shift down an index if it does not meet arguments
                for(int i = index; i<numberOfClubs-1;i++){
                    if(clubList[i+1] == null){
                        clubList[i] = null;
                    }else{
                        clubList[i].copy(clubList[i+1]);
                    }
                }
            }
            numberOfClubs--;
            return true;
        }
    }

    public void sortByClubNames(){
        Sorts.sort(clubList, numberOfClubs, new ClubNameComparator());
    } //Sorts by Club Names
    public void sortByMemberNumbers(){
        Sorts.sort(clubList, numberOfClubs, new MemberNumberComparator());
    } //Sorts by Member Numbers
    public void sortByCurrentPresidents(){
        Sorts.sort(clubList, numberOfClubs, new CurrentPresidentComparator());
    } //Sorts by Current Presidents

    public String listClubs(){
        String haha="\n";
        if(numberOfClubs>0){
            for(int i=0; i<this.numberOfClubs; i++){
                Club club = this.clubList[i];
                haha += club.toString();
            }
        }
        else{
            return "\nno clubs\n\n";
        }
        return haha+"\n";
    }

    public void closeClubManagement() {
        for(int i=0; i<numberOfClubs; i++) {
            clubList[i] = null;
        }
        numberOfClubs = 0;
    }

    public Club[] getClubList() {
        return clubList;
    }

    public void setClubList (Club[] clubList) {
        this.clubList = clubList;
    }

}
