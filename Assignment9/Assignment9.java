// Assignment #: 9
//         Name: Shehzad Anwar
//    StudentID: 121575295
//      Lecture: Tu-Th 1:30-2:45
//  Description: Assignment 9 is a program which reads in a sequence of integers from standard input
//               until 0 is entered. The class consists of four recursive methods: findMin,countOdd
//               computeLargestEven and sumOfNumbersLargerThanFirst. findMin returns the smallest integer
//               in the array. countOdd returns the number of odd numbers in the array. computeLargestEven
//               returns the largest even number in the array. sumOfNumbersLargerThanFirst returns the sum
//               of all integers except the first integer of the array.

import java.io.*;
import java.lang.Math;

public class Assignment9 {

    public static void main(String[] args) throws IOException {
        int num = 0;
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(input);
        //BufferedReader to take input
        int[] values = new int[100];    //Stores 100 values

        do {
            values[num] = Integer.parseInt(read.readLine());
            num = num + 1;
        } while (values[num - 1] != 0);     //Loop to store values

        int minimum = findMin(values, 0, num);      //Uses recursive method to find min value
        int sum = sumOfNumbersLargerThanFirst(values, 0,num, values[0]);    //Stores the sum of values greater than the first
        int countOdd = countOddNumbers(values, 0, num);     //Counts the number of odd numbers in array and returns value

        int largestEven = computeLargestEven(values, 0, num);       //Computes and returns the largest even value

        System.out.println("The minimum number is " + minimum);
        System.out.println("The count of odd integers in the sequence is " + countOdd);
        System.out.println("The largest even integer in the sequence is " + largestEven);
        System.out.println("The sum of numbers larger than the first is " + sum);
    }


    public static int findMin(int[] numbers, int start, int end) {
        if (start == end)
        //Checks if only 1 element in the array
        {
            return numbers[start];
            //returns the element
        }
        else if (findMin(numbers, start, end - 1) < numbers[end])
        {
            return findMin(numbers, start, end - 1);
        }
        else {
            return numbers[end];
        }
    }

    public static int countOddNumbers(int[] elements, int start, int end) {
        if (start < end)    //Counts the odd numbers
        {
            return Math.abs(elements[start] % 2) + countOddNumbers(elements, start + 1, end);
        }
        return 0;
    }

    public static int computeLargestEven(int[] elements, int start, int end){
        if(start == end)
        {
            if(elements[start]%2==0)    //Checks the array for even numbers
            {
                return elements[start];
            }
            else{
                return 0;
            }
        }
        else if(elements[start]>computeLargestEven(elements,start+1,end)){
            if(elements[start]%2==0){
                return elements[start];
            }
            else{
                return computeLargestEven(elements,start+1,end);
            }
        }
        else{
            return computeLargestEven(elements,start+1,end);
        }
    }

    public static int sumOfNumbersLargerThanFirst(int[] elements,int start, int end, int firstElement){
        if(start == end){
            return elements[start];
        }
        else {
            if(elements[start] > firstElement){
                return sumOfNumbersLargerThanFirst(elements, start+1, end, firstElement)+elements[start];
            }
            else{
                return sumOfNumbersLargerThanFirst(elements, start+1, end, firstElement);
            }
        }
    }



}
