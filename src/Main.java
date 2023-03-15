/*
*AUTHOR: Edwin Savelson
*
* QUESTION:
* Given an array, select one element to hold and the rest increment by one
* Find the number of switches to make them all the same value
*
* COMMENTS:
* This was my attempt at using three pointers which is wildly inefficent; but because
* I didn't understand what the formula for making the digits the same was, this was my way of testing holding
* each index.
* I tested incrementing lowest to highest, the highest odd number, the highest even number, but ultimately I
* could not reach a solution
*  Wouldn't 4-1 be the farthest this would have to go?
* Do I need to bring the lowest value up to the highest value and continue that way?
* {1,2,3,4};
* ex.
* [1,2,4,5] hold 5
* [2,3,5,5] hold 4
* [3,4,5,6] hold 5
* [4,5,6,6] hold 5
* [5,6,7,7] hold 7
*
 */
import java.util.Arrays;

public class Main {

    //--------------INCORRECT SOLUTION--------------
    public static int findMinSwitch(int[] arr) {

        int count = 0;
        Arrays.sort(arr);
        for (int i = arr.length - 1; i > -1; i--) {// main pointer
            while ((i - 1 > -1) && arr[i] > arr[i - 1]) { //front pointer
                for (int j = 0; j < i; j++) {
                    arr[j]++;
                }
                if (i != arr.length - 1) {
                    for (int q = i + 1; q < arr.length; q++) {//pointer in front of main
                        arr[q]++;
                    }
                }
                count++;
            }
        }
        return count;
    }
    //--------------INCORRECT SOLUTION--------------

    //--------------CORRECT SOLUTION--------------
    public static int findNumSwitches(int[] arr) {
        //Formula is:
        // Sum of all values - (Lowest Value * Length of Array);
        int count = 0;
        int low = 0;
        int sum = 0;
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            low = Math.min(arr[i], low);
            sum += arr[i];
        }
        count = sum - (low * length);

        return count;
    }

    //--------------CORRECT SOLUTION--------------
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4};

        System.out.println(findNumSwitches(arr));
    }
}