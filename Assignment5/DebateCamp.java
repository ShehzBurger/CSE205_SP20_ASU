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

public class DebateCamp extends SummerCamp {
    //Instance Variables
    public double materialFee = 0.0;
    public boolean groupDiscount;

    //Constructor
    public DebateCamp(String title, String location, double weeklyRate, int numberOfWeeks, double materialFee, String groupDiscount)
    {
        super(title, location, weeklyRate, numberOfWeeks);
        this.materialFee = materialFee;
        if (groupDiscount.equals("yes"))
        {
            this.groupDiscount = true;
        }
        else
        {
            this.groupDiscount = false;
        }
    }

    public void computeTotalCosts()
    {
        if (groupDiscount)
        {
            super.totalCost = weeklyRate * numberOfWeeks * 0.9 + materialFee;
        }
        else
        {
            super.totalCost = weeklyRate * numberOfWeeks + materialFee;
        }
    }

    public String toString()
    {
        String output;
        if (groupDiscount)
        {
            output = "\nDebate Camp:" + super.toString() +
                    "Material Fee:\t\t" + super.dollar.format(materialFee) + "\n" +
                    "Group Discount:\t\t" + "yes" + "\n";
        }
        else
        {
            output = "\nDebate Camp:" + super.toString() +
                    "Material Fee:\t\t" + super.dollar.format(materialFee) + "\n" +
                    "Group Discount:\t\t" + "no" + "\n";
        }
        return output;
    }
}