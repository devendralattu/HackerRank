/** https://www.hackerrank.com/contests/walmart-codesprint-algo/challenges/fibonacci-sum-1 **/

package hackerrank;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonancci {

	private static Map<BigInteger, BigInteger> map;
	private static BigInteger zero = new BigInteger("0");
	private static BigInteger one = new BigInteger("1");
	private static BigInteger two = new BigInteger("2");
	private static BigInteger seven = new BigInteger("7");
	private static BigInteger modVal = new BigInteger("10").pow(9).add(seven);

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Number of queries = ");
		int queries = in.nextInt();

		System.out.println("modVal = " + modVal);

		for (int q = 0; q < queries; q++) {

			map = new HashMap<BigInteger, BigInteger>();
			map.put(one, one);
			map.put(two, one);

			System.out.println("Enter n = ");
			int sizeN = in.nextInt();
			BigInteger arr[] = new BigInteger[sizeN];

			for (int n = 0; n < sizeN; n++) {
				arr[n] = new BigInteger(in.nextInt() + "");
			}

			BigInteger fiboSum = zero;

			for (int i = 0; i < sizeN; i++) {
				BigInteger sum = zero;
				for (int j = i; j < sizeN; j++) {

					sum = sum.add(arr[j]);
					fiboSum = fiboSum.add(calcFibo(sum));
				}
			}
			fiboSum = fiboSum.mod(modVal);
			System.out.println("fiboSum % modVal = ");
			System.out.println(fiboSum);

		}

	}

	private static BigInteger calcFibo(BigInteger n) {
		if (map.containsKey(n)) {
			return map.get(n);
		}

		map.put(n.subtract(one), calcFibo(n.subtract(one)));
		map.put(n.subtract(two), calcFibo(n.subtract(two)));

		BigInteger newVal = map.get(n.subtract(one)).add(map.get(n.subtract(two)));
		map.put(n, newVal);

		return newVal;
	}

}
