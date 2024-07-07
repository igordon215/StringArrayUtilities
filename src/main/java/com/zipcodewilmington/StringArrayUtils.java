package com.zipcodewilmington;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        //variable pre declared in (String[] array)
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        //variable pre declared in (String[] array)
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        //declare (type)=int (variableName)=lastElement array=(input)(help method)
        int lastElement = array.length - 1;
        //.length this gets the total size of the array, capacity
        return array[lastElement];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        //.length-2 = minus the last two position because the index begins at zero.
        int getSecondToLastPosition = array.length - 2;
        return array[getSecondToLastPosition];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        //We have two input values given, array and value
        //We will have to compare the value against the array
        //.length checks the size of the array int.
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                //(Variable-Array).equals (string method)(variable-value) <-- if statement
                //A For loop is better to return true so that you continue..
                //..to check the rest of the array for the equal value
                return true;
            }
        }
        return false;
}

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        //create a new array labeled such, and it will contain the new array w/ length (w/ original array size)
        String[] reverseArray = new String[array.length];
        for (int i = array.length - 1, reverseArrayPosition = 0; i >= 0; i--, reverseArrayPosition++) {
            reverseArray[reverseArrayPosition] = array[i];
        }
        //for loop = int i = length of array -1 (last position)
        //we will be reading the array from right to left based on the for loop

        return reverseArray;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        String[] reverseArray = reverse(array);//the creation of an empty array to store the data within the for(loop)
        //if(array == reverseArray);
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(reverseArray[i])) { //! bang operator - states if its not true do this
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        boolean[] alphalist = new boolean[26]; // create a new boolean array w/ size 26
            for (String str : array) {// Iterate through each string in the array
            for (int i = 0; i < str.length(); i++) {// Iterate through each character in the current string
                char ch = Character.toLowerCase(str.charAt(i)); // Convert character to lowercase
                if ('a' <= ch && ch <= 'z') { //Checks if the current character ch is a lowercase letter.
                    alphalist[ch - 'a'] = true; // Mark the corresponding index in alphalist as true
                }
            }
        }
        // Check if all letters from 'a' to 'z' are present in at least one string
            for (boolean value : alphalist) {
                if (!value) {
                return false; // If any letter is missing, return false
            }
        }
                return true; // If all letters are present, return true
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        //need to return a counter = int
        //track it outside the for loop
        //for loop to check array
        //set condtion that if the array equals the value add to counter
        //return the counter
        int counter = 0;
        for(int i = 0; i<array.length; i++){
            if(array[i].equals(value)){
                counter++;
            }
        }
        return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        //Initializing a count to iterate  through an array to find occurrences of valueToRemove
        int count = 0;

        for (String str : array) {
            if (!str.equals(valueToRemove)) {
                count++;
            }
        }
        //create new array with adjusted size (from previous iteration based on count of non-matching elements)
        String[] resultArray = new String [count];
        int index = 0;

        //copy non-matching elements to newly created array
        for (String str : array) {
            if (!str.equals(valueToRemove)) {
                resultArray[index++] = str;
            }
        }

        return resultArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        String[] newArray = new String[array.length]; //creating a new string array with the length
        String value = ""; //hold an empty string
        int counter = 0;

        for(int i=0; i < array.length; i++){
            if(!array[i].equals(value)){
                value = array[i];
                newArray[counter] = value; //this line will update the array to the unique
                counter++; //we increase counter the new position of the new array - this keep tracks of the
                //position in the new array and how many uniques we have seen
            }
        }

        String[] finalArray = Arrays.copyOf(newArray, counter); //creates an array with only the unique
        //values and specific amount of space in the value
        return finalArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        String duplicates = array[0]; //container to hold the starting the position at 1

        for(int i=1; i < array.length; i++){
            //if we are going thru the array and we encounter a letter that is similar to the letter before;
            if(array[i].equals(array[i-1])){  //this is saying: if the last position is not equal to the current position
                duplicates += array[i];  //duplicate = duplicate + array[i] - if true, concat the duplicates
            }
            else{
                duplicates = duplicates + " " + array[i];  // this else method here tracks the ones that does not match and space them out
            }
            System.out.println("duplicate " + duplicates);
        }

        return duplicates.split(" ");//usage of the delimiter to, let the program does the spacing for us between the consecutive and the unique single character
    }


}
