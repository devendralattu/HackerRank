package dynamic_programming;

/** 
Find unique ways to form a sum using coins.
eg: Amount 10 is formed from [2, 5, 3, 6] by 5 ways
2,2,2,2,2
2,2,3,3
2,2,6
2,3,5
5,5
**/

import java.util.Scanner;

public class CoinsChange {

	private static Scanner in;

	public static void main(String[] args) {

		in = new Scanner(System.in);
		System.out.println("Enter amount to make = ");
		int amount = in.nextInt();

		System.out.println("Enter number of coins = ");
		int n = in.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		long combinations[] = new long[amount + 1];
		combinations[0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = arr[i]; j <= amount; j++) { //j < combinations.length => fill every possible combination for that denomination
				combinations[j] = combinations[j] + combinations[j - arr[i]];
			}
		}

		System.out.println("Number of possible ways = " + combinations[amount]);
	}

}
