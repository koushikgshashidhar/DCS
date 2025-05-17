package com.demo.DataStructures;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_list {

    public static void main(String[] args) {
        // Create an array list
        ArrayList<String> list = new ArrayList<>();
        // Add elements to the array list
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        // Print the array list
        System.out.println("Array List: " + list);
        //initialize an array list with values
        ArrayList<String> vegetables = new ArrayList<>(List.of("Carrot", "Potato", "Tomato"));
        //initialize an array list with values of different data type
        ArrayList<Object> mixedArray = new ArrayList<>(List.of("Carrot", 1, 2.5, true));
        //initialize an array list from values of array
        String[] array = {"Carrot", "Potato", "Tomato"};
        ArrayList<String> arrayListFromArray = new ArrayList<>(List.of(array));


        ArrayList<String> al = new ArrayList<>(List.of("Carrot", "Potato", "Tomato"));
        ArrayList<String> al2 = new ArrayList<>(Arrays.asList("Carrot", "Potato", "Tomato"));
        List<String> al3 = List.of("Carrot", "Potato", "Tomato");
        List<String> al4 = Arrays.asList("Carrot", "Potato", "Tomato");

    }
}
