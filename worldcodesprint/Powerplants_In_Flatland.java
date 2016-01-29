/*
 * https://www.hackerrank.com/contests/worldcodesprint/challenges/powerplants-in-flatland
 */

package worldcodesprint;

import java.util.*;

public class Powerplants_In_Flatland {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int a[] = new int[N];

		Map<Integer, Integer> b = new HashMap<Integer, Integer>();
		
		int c[] = new int[N];
		int i = 0, ci = 0;
		
		// read space station cities
		while (M-- > 0) {
			int key = in.nextInt();
			b.put(key, 0);
		}
		
		// allocate cities from 0 to N - 1
		for (i = 0; i < N; i++) {
			a[i] = i;
		}
		// start from non space cities
		int p1 = 0, p2 = 0;
		for (i = 0; i < N; i++) {
			int p1Count = 0, p2Count = 0;
			p1 = p2 = i;
			while (!(b.containsKey(a[p1]) || b.containsKey(a[p2]))) {
				if (p1 > 0) {
					p1--;
					p1Count++;
				}
				if (p2 < N) {
					p2++;
					p2Count++;
				}
			}
			c[i] = min(p1Count, p2Count);
		}

		for (i = 0; i < N; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();

		int max = getMax(c);
		System.out.println(max);
	}

	public static int getMax(int[] c) {
		int len = c.length;
		int max = 0;
		for (int i = 0; i < len; i++) {
			if (c[i] > max) {
				max = c[i];
			}
		}
		return max;
	}

	public static int min(int p1Count, int p2Count) {
		return (p1Count > p2Count) ? p2Count : p1Count;
	}
}
