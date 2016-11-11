/** https://www.hackerrank.com/challenges/maxsubarray **/
/** 
    Contiguous subarray
    Non-contiguous (not necessarily contiguous) subarray.
**/

import java.util.Scanner;

public class MaxSubarray {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);

		System.out.println("Number of test cases =");
		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			StringBuilder sb = new StringBuilder();
			System.out.println("Enter size of array " + (i + 1) + " =");
			int n = in.nextInt();

			int arr[] = new int[n];

			// enter all elements
			System.out.println("Enter " + n + " number of elements");
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}

			int currentMax = arr[0];
			int totalMax = arr[0];

			for (int j = 1; j < n; j++) {
				currentMax = getMax(arr[j], currentMax + arr[j]);
				totalMax = getMax(currentMax, totalMax);
			}
			sb.append(totalMax + " ");

			int sumPos = 0;
			int maxNeg = arr[0];
			boolean flag = true; // check if array has all negative elements
			for (int j = 0; j < n; j++) {
				if (arr[j] >= 0) {
					sumPos = sumPos + arr[j];
					flag = false;
				}
				maxNeg = getMax(maxNeg, arr[j]);
			}

			if (!flag) { // some non negative elements in array
				sb.append(sumPos);
			} else { // all neg elements in array
				sb.append(maxNeg);
			}

			System.out.println(sb.toString());
		}

	}

	private static int getMax(int num1, int num2) {
		return (num1 > num2) ? num1 : num2;
	}

}
