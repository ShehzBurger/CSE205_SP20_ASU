// Assignment #: 5
// Arizona State University - CSE205
//         Name: Shehzad Anwar
//    StudentID: 1216575295
//      Lecture: TTh 1:30PM
//  Description: The Assignment 5 class displa ys a menu of choices
//               (add summer camp, search summer camp title,
//               list summer camps, quit, display menu) to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

public class MathCamp extends SummerCamp {
    //Instance Variables
    public boolean testTaking;

    //Constructor
    public MathCamp(String title, String location, double weeklyRate, int numberOfWeeks, String testTaking)
    {
        super(title, location, weeklyRate, numberOfWeeks);
        if (testTaking.equals("yes"))
        {
            this.testTaking = true;
        }
        else
        {
            this.testTaking = false;
        }
    }

    public void computeTotalCosts()
    {
        if (testTaking)
        {
            super.totalCost = weeklyRate * numberOfWeeks + 25;
        }
        else
        {
            super.totalCost = weeklyRate * numberOfWeeks;
        }
    }

    public String toString()
    {
        String output;
        if (testTaking)
        {
            output = "\nMath Camp:" + super.toString() +
                    "Test Taking:\t\t" + "yes" + "\n";
        }
        else
        {
            output = "\nMath Camp:" + super.toString() +
                    "Test Taking:\t\t" + "no" + "\n";
        }
        return output;
    }
}