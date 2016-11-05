/** 
Find unique ways to form a sum using coins.
eg: Amount 5 is formed from [1,2,5] by 4 ways
1,1,1,1,1
1,1,1,2
1,2,2
5
**/

import java.util.Scanner;

public class CoinChange {

	private static Scanner in;

	public static void main(String[] args) {

		in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[] coins = new int[M];
		for (int i = 0; i < M; i++) {
			coins[i] = in.nextInt();
		}
		System.out.println(max(coins, N));
	}

	public static int max(int[] coins, int N) {
		int[] numCoins = new int[N + 1];
		numCoins[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			
			int c = coins[i];
			for (int j = c; j < numCoins.length; j++) {
				numCoins[j] = numCoins[j] + numCoins[j - c];
			}
		}
		return numCoins[N];
	}

}
