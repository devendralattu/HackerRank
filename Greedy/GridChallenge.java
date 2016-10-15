/** https://www.hackerrank.com/challenges/grid-challenge **/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GridChallenge {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.next()); // test cases

		for (int i = 0; i < t; i++) {

			String check = in.next();
			int n = 0;
			while(!isInteger(check)){
				check = in.next();
			}
			n = Integer.parseInt(check);
			
			// no need for further calculation for matrix of size 1
			if (n == 1) {
				sb.append("YES\n");
				check = in.next();
				continue;
			}

			char cMat[][] = new char[n][n];

			for (int j = 0; j < n; j++) {
				String s = in.next();
				while(isBlank(s)){
					s = in.next();
				}
				cMat[j] = s.toCharArray();
			}

			// min-max storing array
			int arr[] = new int[n * 2];
			for (int a = 0; a < n; a++) {
				int min = Integer.MAX_VALUE;
				int max = Integer.MIN_VALUE;

				for (int b = 0; b < n; b++) {
					if ((int) cMat[a][b] > max) {
						max = (int) cMat[a][b];
					}
					if ((int) cMat[a][b] < min) {
						min = (int) cMat[a][b];
					}
				}

				// save min and max in array
				arr[a * 2] = min;
				arr[(a * 2) + 1] = max;
			}

			// check if max element is less than or equal to next min...
			boolean cond = false;
			for (int m = 0; m < arr.length - 2; m++) {
				if (arr[m] > arr[m + 2]) {
					cond = true;
					break;
				}
			}
			if (cond) {
				sb.append("NO\n");
			} else {
				sb.append("YES\n");
			}
		}

		System.out.print(sb.toString());
	}

	private static boolean isBlank(String s) {
		if(s.length() == 0){
			return true;
		}
		return false;
	}

	private static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
