import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        
        int countPhotos = (int)(Math.pow(2, n)) - 1;
        int diff = Math.abs(countPhotos - x);
        System.out.println(diff);
    }
}
