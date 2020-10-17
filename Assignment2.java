// Assignment #: 2
// Arizona State University - CSE205
//         Name: Shehzad Anwar
//    StudentID: 1216575295
//      Lecture: 1:30PM
//  Description: This class reads an unspecified number of integers from standard input,
//  performs calculations on the inputted numbers, and outputs the
//  results of those calculations to standard output.
import java.util.*;

public class Assignment2 {
    public static void main(String []args)
    { //declare variables and initializing
        Scanner s = new Scanner(System.in); // Scanner reads the input
        int min = 0;            //variable for min
        int count_odd = 0;      //variable for odd count
        int posint = 0;         //variable for number of positive integers
        int largesteven = 0;    //variable for largest even integer
        int num = s.nextInt();  //variable to hold value of input

        while(num != 0) {       //will break once 0 is entered
            if (num < min) {
                min = num;
            }
            if (num > 0) {
                posint += num;
            }
            if (num % 2 != 0) {
                count_odd++;
            }
            if (num % 2 == 0 && num > largesteven) {
                largesteven = num;
            }
            num = s.nextInt();
        }//end of while-loop
        System.out.println("The minimum integer is "+min);
        System.out.println("The count of odd integers in the sequence is "+count_odd);
        System.out.println("The largest even integer in the sequence is "+largesteven);
        System.out.println("The sum of positive integers is "+posint);
        }//end main
}//end class


