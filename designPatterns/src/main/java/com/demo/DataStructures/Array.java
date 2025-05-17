package com.demo.DataStructures;
import java.util.ArrayList;
import java.util.Arrays;
public class Array {
    public static void main(String[] args) {
        // Create an array
        String[] fruits = new String[3];
        // Add elements to the array
        fruits[0] = "Apple";
        fruits[1] = "Banana";
        fruits[2] = "Cherry";

        // Print the array
        System.out.println("Array: ");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        // print the array at once
       System.out.println("Array: " + Arrays.toString(fruits));

        // Print the length of the array
        System.out.println("Length of array: " + fruits.length);

        //initialize an array with values
        String[] vegetables = {"Carrot", "Potato", "Tomato"};
        //initialize an array with values of different data type
        Object[] mixedArray = {"Carrot", 1, 2.5, true};
        //initialize an array with values of arrray
        String[][] multiArray = {
                {"Carrot", "Potato"},
                {"Tomato", "Cabbage"}
        };
        // Print the multi-dimensional array
        System.out.println("Multi-dimensional array: ");
        for (String[] row : multiArray) {
            for (String item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        // initialize from arraylist
        ArrayList<String> list = new ArrayList<>();
        // Add elements to the array list
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        String[] arrayFromList = new String[list.size()];
        // Convert ArrayList to array
        list.toArray(arrayFromList);
        // Print the array
        System.out.println("Array from ArrayList: "+Arrays.toString(arrayFromList));


    }
}
