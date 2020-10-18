// Assignment #: 8
//         Name: Shehzad Anwar
//    StudentID: 1216575295
//      Lecture: 1:30PM TTh
//  Description: Sorts is meant to be a class that sorts the given inputs alphabetically.

import java.util.Arrays;
import java.util.Comparator;
public class Sorts {
    public static void sort(Club[] clubList, int size, Comparator<Club> comparator) {
        //Selection Sort
        for(int i = 0; i<size-1; i++){
            int minIndex = i;
            for(int j = i+1; j<size; j++){
                if(comparator.compare(clubList[j], clubList[minIndex]) < 0){
                    minIndex = j;
                }
            }
            Club temp = new Club("","",0);
            temp.copy(clubList[minIndex]);
            clubList[minIndex].copy(temp);
            clubList[i].copy(temp);
        }
    }
}

