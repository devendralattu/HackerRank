import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LonelyInteger {
     private static int lonelyInteger(int[] a) {
        int num = a[0];
        for(int i = 1; i < a.length; i++){
            num = num ^ a[i];
        } 
        return num;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }

}

/**
Consider an array of integers, where all but one of the integers occur in pairs. 
In other words, every element in occurs exactly twice except for one unique element.
Given , find and print the unique element.
**/
