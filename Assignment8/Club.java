// Assignment #: 8
//         Name: Shehzad Anwar
//    StudentID: 1216575295
//      Lecture: 1:30PM TTh
//  Description: The class Club represents a Club.

import java.io.Serializable;

public class Club implements Serializable
{
    private String clubName;
    private int numberOfMembers;
    private String university;
    private President currentPresident;

    //Constructor to initialize all member variables
    public Club(String clubName, String university, int numberOfMembers)
    {
        this.clubName = clubName;
        this.university = university;
        this.numberOfMembers = numberOfMembers;
        currentPresident = null;
    }

    public void copy(Club other){   //Copy value of Clubs
        this.clubName = other.clubName;
        this.university = other.university;
        this.numberOfMembers = other.numberOfMembers;
        //If the object doesn't have a President, create one.
        if (this.currentPresident == null){
            this.currentPresident = new President("","","");
        }
        this.currentPresident.copy(other.getCurrentPresident());
    }

    //Accessor method for club name
    public String getClubName()
    {
        return clubName;
    }

    //Accessor method for university
    public String getUniversity()
    {
        return university;
    }

    //Accessor method for number of members
    public int getNumberOfMembers()
    {
        return numberOfMembers;
    }

    //Accessor method for current president
    public President getCurrentPresident()
    {
        return currentPresident;
    }

    //Modifier method for club name
    public void setClubName(String someClubName)
    {
        this.clubName = someClubName;
    }

    //Modifier method for university
    public void setUniversity(String someUniversity)
    {
        this.university = someUniversity;
    }

    //Modifier method for number of members
    public void setNumberOfMembers(int someNumber)
    {
        this.numberOfMembers = someNumber;
    }

    //Modifier method for current president
    public void setCurrentPresident(String fname, String lname, String level)
    {
        this.currentPresident = new President(fname, lname, level);
    }

    //toString() method returns a string containing its name, number of members, university
    //and current president
    public String toString()
    {
        String result = "\nClub Name:\t\t" + clubName
                + "\nNumber Of Members:\t" + numberOfMembers
                + "\nUniversity:\t\t" + university
                + "\nPresident:\t\t"
                + currentPresident.toString() + "\n\n";
        return result;
    }
}
