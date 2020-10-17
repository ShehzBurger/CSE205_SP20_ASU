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

public class RoboticsCamp extends SummerCamp {
    //Instance Variables
    public double facilityFee = 0.0;
    public double competitionFee = 0.0;

    //Constructor
    public RoboticsCamp(String title, String location, double weeklyRate, int numberOfWeeks, double facilityFee, double competitionFee)
    {
        super(title, location, weeklyRate, numberOfWeeks);
        this.facilityFee = facilityFee;
        this.competitionFee = competitionFee;
    }

    public void computeTotalCosts()
    {
        super.totalCost = weeklyRate * numberOfWeeks + facilityFee + competitionFee;
    }

    public String toString()
    {
        String output = "\nRobotics Camp:" + super.toString() +
                "Facility Fee:\t\t" + super.dollar.format(facilityFee) + "\n" +
                "Competition Fee:\t" + super.dollar.format(competitionFee) + "\n";
        return output;
    }
}