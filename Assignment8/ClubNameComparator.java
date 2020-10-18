// Assignment #: 8
//         Name: Shehzad Anwar
//    StudentID: 1216575295
//      Lecture: 1:30PM TTh
//  Description: ClubNameComparator compares the club names.

import java.util.Comparator;

public class ClubNameComparator implements Comparator<Club> {   //Compares the Club Names based on the given arguments
    @Override
    public int compare(Club first, Club second) {
        int tempName=-1;

        tempName=first.getClubName().compareTo(second.getClubName());
        if (tempName==0) {
            String clubName1 = String.valueOf(first.getClubName());
            String clubName2 = String.valueOf(second.getClubName());
            tempName = clubName1.compareTo(clubName2);
            return tempName;
        }
        //if names aren't the same
        else{
            return tempName;
        }
    }
}
