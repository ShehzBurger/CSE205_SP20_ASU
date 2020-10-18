// Assignment #:
//         Name:
//    StudentID:
//      Lecture:
//  Description: The President class describes a President.
//               It also provides their accessor, mutator methods,
//               and toString method.

import java.io.Serializable;

public class President implements Serializable
{
    private String firstName; //First name of Pres
    private String lastName;  //Last name of Pres
    private String academicLevel;  //Academic Level of Pres

    //Constructor method to initialize instance variables.
    public President(String fName, String lName, String academicLevel)
    {
        firstName = fName;
        lastName= lName;
        this.academicLevel = academicLevel;
    }

    public void copy(President other){
        this.firstName = other.getFirstName();
        this.lastName = other.getLastName();
        this.academicLevel = other.getAcademicLevel();
    }

    //Accessor method for first name
    public String getFirstName()
    {
        return firstName;
    }

    //Accessor method for last name
    public String getLastName()
    {
        return lastName;
    }

    //Accessor method for academic level
    public String getAcademicLevel()
    {
        return academicLevel;
    }

    //modifier method for first name
    public void setFirstName(String someFirstName)
    {
        firstName = someFirstName;
    }

    //modifier method for last name
    public void setLastName(String someLastName)
    {
        lastName = someLastName;
    }

    //modifier method for academic level
    public void setAcademicLevel(String someAcademicLevel)
    {
        academicLevel = someAcademicLevel;
    }

    //This method return a string containing the attribute information of a President
    public String toString()
    {
        String result;

        result = lastName + "," + firstName + "(" + academicLevel + ")";

        return result;
    }

}
