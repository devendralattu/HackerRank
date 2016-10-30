package hackerrank;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PopsicleStickMountains {

	private static Map<Integer, BigInteger> map;

	private static BigInteger zero = new BigInteger("0");
	private static BigInteger one = new BigInteger("1");
	private static BigInteger two = new BigInteger("2");

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int trips = in.nextInt();

		for (int t = 0; t < trips; t++) {
			int n = in.nextInt();

			map = new HashMap<Integer, BigInteger>();
			map.put(1, one); // setting value for 2 as "1". We are using n/2
								// thus key is also 1.

			BigInteger totalCount = zero;
			// this formula requires n to start from 1 for value n = 2.
			
			n = n / 2;
			int num = 1;
			while (num <= n) {
				BigInteger count = getCount(num);
				totalCount = totalCount.add(count);
				num++;
			}

			System.out.println(totalCount);
		}

	}

	private static BigInteger getCount(int n) {
		// formula: (2*n)! / [(n+1)! * n!]
		// logic: 10! / (6! * 5!) = (10*9*8*7)/[(5*4) * 3!] = (2*9*2*7 / 3!)
		// loop will run for (2*n - n+1) times and second part of denominator
		// will be calculated as factorial and divided.

		if (map.containsKey(n)) {
			return map.get(n);
		}

		int diff = n - 1;
		BigInteger product = one;

		int j = 1;
		for (int i = 0; i < diff; i++) {
			if (i % 2 == 0) {
				product = product.multiply(two);
			} else {
				BigInteger numerator = BigInteger.valueOf((2 * n) - i);
				product = product.multiply(numerator);

				if (j < diff) {
					BigInteger denominator = BigInteger.valueOf(j + 1);
					product = product.divide(denominator);
					j++;
				}
			}
		}

		map.put(n, product);
		return product;
	}
}
