import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CounterGame {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			BigInteger n = in.nextBigInteger();
			BigInteger one = new BigInteger("1");
			BigInteger two = new BigInteger("2");
			
			boolean player = true;

			while (n.compareTo(one) != 0) {
				int count = getExpPowerCount(n, one);

				if (n.compareTo(two.pow(count)) == 0) {
					n = n.divide(two);
				} else {
					n = n.subtract(two.pow(count));
				}
				player = !player;
			}
			if (player) {
				System.out.println("Richard");
			} else {
				System.out.println("Louise");
			}
		}
	}

	private static int getExpPowerCount(BigInteger n, BigInteger one) {
		int count = 0;
		while (n.compareTo(one) == 1) {
			n = n.shiftRight(1);
			count++;
		}
		return count;
	}
}


/**
Louise and Richard play a game. They have a counter set to N. Louise gets the first turn and the turns alternate thereafter. In the game, they perform the following operations.

    If N is not a power of 2, reduce the counter by the largest power 2 of less than N.
    If N is a power of 2, reduce the counter by half of N.
    The resultant value is the new N which is again used for subsequent operations.

The game ends when the counter reduces to 1, i.e., N == 1, and the last person to make a valid move wins.

Given N, your task is to find the winner of the game.

If they set counter to 1, Richard wins, because its Louise' turn and she cannot make a move.


Input:
6
137438953472
17592186044416
12538990046817067955
8
10705863057888060538
5944858545393724888

Output:
Louise
Richard
Louise
Louise
Richard
Louise
**/
