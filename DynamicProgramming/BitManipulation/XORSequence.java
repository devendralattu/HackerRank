/**
https://www.hackerrank.com/challenges/xor-se
**/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Q = in.nextInt();
		ArrayList<Long> al = new ArrayList<Long>();
		for (int a0 = 0; a0 < Q; a0++) {
			long L = in.nextLong();
			long R = in.nextLong();

			long l = L / 4;
			long r = R / 4;

			long xorSum = 0;
			if (r - l <= 1) {
				xorSum = calXORSum(L, R, xorSum);
			} else {
				if ((r - l - 1) % 2 == 0) {
					xorSum = 0;
				} else {
					xorSum = 2;
				}

				xorSum = calXORSum(L, l * 4 + 3, xorSum);
				xorSum = calXORSum(r * 4, R, xorSum);
			}

			al.add(xorSum);
		}

		for (long a : al) {
			System.out.println(a);
		}
	}

	private static long calXORSum(long start, long end, long xorSum) {

		for (long i = start; i <= end; i++) {
			
            if(i % 4 == 0){
                xorSum = xorSum ^ i;
            }else if(i % 4 == 1){
                xorSum = xorSum ^ 1;
            }else if(i % 4 == 2){
				xorSum = xorSum ^ (i / 4) * 4 + 3;                
            }else if(i % 4 == 3){
                xorSum = xorSum ^ 0;
            }
		}
		return xorSum;
	}
}
