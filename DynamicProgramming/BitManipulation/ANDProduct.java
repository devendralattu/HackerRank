/** 
https://www.hackerrank.com/challenges/and-product
**/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        ArrayList<Long> al = new ArrayList<Long>();
        for(int i = 0; i < t; i++){
            long a = in.nextLong();
            long b = in.nextLong();
            
            /*
            long aPow2 = (long) (Math.floor(Math.log10(a) / Math.log10(2)));

            long count = 1;
            long aPow = (long) Math.pow(2, aPow2 + count);
            long sum = a;
            while (aPow <= b) {
                sum = sum & aPow;
                if(sum == 0){
                    break;
                }
                count++;
                aPow = (long) Math.pow(2, aPow2 + count);
            }
            sum = sum & b;
            */
            
            long a2 = a + 1;
            long count = 1;
            long sum = a;
            while(a2 <= b){
                sum = sum & a2;
                a2 = a + (long) Math.pow(2, count++); 
            }
            sum = sum & b;
            al.add(sum);
        }
        
        for(long i : al){
            System.out.println(i);
        }
    }
}
