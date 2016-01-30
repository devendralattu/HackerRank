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

		Map<Integer, Integer> b = new HashMap<Integer, Integer>();

		int c[] = new int[N];
		int i = 0, ci = 0;

		// read space station cities
		if (M <= 0) {
			System.out.println(0);
			return;
		}

		for (i = 0; i < M; i++) {
			int key = in.nextInt();
			b.put(key, 0);
		}

		// start from non space cities
		int p1 = 0, p2 = 0;
		for (i = 0; i < N; i++) {
			int p1Count = 0, p2Count = 0;
			p1 = p2 = i;
			boolean p1Stopped = true, p2Stopped = true;

			if (b.containsKey(i)) {
				c[i] = 0;
			} else {
				while (!(b.containsKey(p1) || b.containsKey(p2))) {
					if (p1 > 0 && p1Stopped) {
						p1--;
						p1Count++;
					} else {
						p1Stopped = false;
					}
					if (p2 < N && p2Stopped) {
						p2++;
						p2Count++;
					} else {
						p2Stopped = false;
					}
				}
				if (p1Stopped && p2Stopped) {
					c[i] = min(p1Count, p2Count);
				} else {
					c[i] = max(p1Count, p2Count);
				}
			}
		}

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

	public static int max(int p1Count, int p2Count) {
		return (p1Count < p2Count) ? p2Count : p1Count;
	}
}
