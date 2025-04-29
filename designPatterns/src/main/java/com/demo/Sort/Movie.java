package com.demo.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Movie  implements Comparable<Movie> {
     private String title;
     private double rating;
     private int year;


        public Movie(String title, double rating, int year) {
            this.title = title;
            this.rating = rating;
            this.year = year;
        }

        public String getTitle() {
            return title;
        }

        public double getRating() {
            return rating;
        }

        public int getYear() {
            return year;
        }

        @Override
        public int compareTo(Movie other) {
            return Double.compare(this.rating, other.rating);
        }


}

class SortYear implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        return Integer.compare(m1.getYear(), m2.getYear());
    }
}

class Test
{
    public static void main(String[] args) {

        Movie movie1 = new Movie("Inception", 8.8, 2010);
        Movie movie2 = new Movie("The Dark Knight", 9.0, 2008);
        Movie movie3 = new Movie("Interstellar", 8.6, 2014);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

       for (Movie movie : movies) {
            System.out.println("original :"+movie.getTitle() + " - " + movie.getRating());
       }

       Collections.sort(movies);
       for (Movie movie : movies) {
            System.out.println("sorted by rating :"+movie.getTitle() + " - " + movie.getRating());
       }

       Collections.sort(movies, new SortYear());
       for (Movie movie : movies) {
            System.out.println("sorted by year :"+movie.getTitle() + " - " + movie.getYear());
       }

        // Sort the movies by rating
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
               return m1.getTitle().compareTo(m2.getTitle());
            }
        });

        // Print the sorted movies
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " - " + movie.getRating());
        }
    }
}