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

import java.text.*;
import java.util.*;

public abstract class SummerCamp {

    //Instance Variables
    protected String title;
    protected String location;
    protected double weeklyRate;
    protected int numberOfWeeks;
    protected double totalCost;
    protected Locale locale = new Locale("en", "US");
    protected NumberFormat dollar = NumberFormat.getCurrencyInstance(locale);

    //Constructor
    public SummerCamp(String title, String location, double weeklyRate, int numberOfWeeks)
    {
        this.title = title;
        this.location = location;
        this.weeklyRate = weeklyRate;
        this.numberOfWeeks = numberOfWeeks;
        totalCost = 0.0;
    }

    //Accessor for Camp Title
    public String getCampTitle(){return title;}

    //Mutator for computeTotalCosts
    public abstract void computeTotalCosts();

    //toString
    public String toString()
    {
        String output = "\nCamp Title:\t\t" + title + "\n" +

                "Location:\t\t" + location + "\n" +

                "Weekly Rate:\t\t" + dollar.format(weeklyRate) + "\n" +

                "Weeks:\t\t\t" + numberOfWeeks + "\n" +

                "Total Cost:\t\t" + dollar.format(totalCost) + "\n";
        return output;
    }
}