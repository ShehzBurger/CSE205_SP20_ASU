// Assignment #: 8
//         Name: Shehzad Anwar
//    StudentID: 1216575295
//      Lecture: 1:30PM TTh
//  Description: MemberNumberComparator is meant to compare the number of members for two clubs using a Comparator.

import java.util.Comparator;

public class MemberNumberComparator implements Comparator<Club> {

    public MemberNumberComparator(){

    }

    @Override
    public int compare(Club first, Club second) {   //Compares the Number of Members based on the given argument
        int firstNum = first.getNumberOfMembers();
        int secondNum = second.getNumberOfMembers();

        return firstNum - secondNum;
    }
}
