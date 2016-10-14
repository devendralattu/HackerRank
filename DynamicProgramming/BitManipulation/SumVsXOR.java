import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SumVsXOR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long num = n;
        long count = 0;
        while(n != 0){
            if(n%2 == 0){
                //last bit is 0;
                count++;
            }
            n = n >> 1;
        }
        System.out.print((long)Math.pow(2, count));
    }
}

/**
Given an integer n, find x each such that:
0 <= x <= n
n + x = n ^ x
where ^ denotes the bitwise XOR operator. 
Then print an integer denoting the total number of x's satisfying the criteria above.
**/
