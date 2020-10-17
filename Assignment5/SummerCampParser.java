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

public class SummerCampParser {
    public static SummerCamp parseStringToSummerCamp(String lineToParse)
    {
        String[] type = lineToParse.split(":", 7);
        //type = ["DebateCamp", "Intro", "WGHL101", "30.50", "6", "9.50", "no"]
        if(type[0].equals ("DebateCamp"))
        {
            return new DebateCamp(type[1],type[2],Double.parseDouble(type[3]),Integer.parseInt(type[4]),Double.parseDouble(type[5]),type[6]);
        }
        else if (type[0].equals ("RoboticsCamp"))
        {
            return new RoboticsCamp(type[1],type[2],Double.parseDouble(type[3]),Integer.parseInt(type[4]),Double.parseDouble(type[5]),Double.parseDouble(type[6]));
        }
        else
        {
            return new MathCamp(type[1],type[2],Double.parseDouble(type[3]),Integer.parseInt(type[4]),type[5]);
        }
    }
}