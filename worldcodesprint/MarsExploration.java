package worldcodesprint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarsExploration {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		int N = S.length();

		List<Character> ll = new ArrayList<Character>();
		ll.add('S');
		ll.add('O');
		ll.add('S');

		int count = 0;

		for (int i = 0; i < N; i++) {
			if (ll.get(i % 3) != S.charAt(i)) {
				count++;
			}
		}

		System.out.println(count);
	}

}
