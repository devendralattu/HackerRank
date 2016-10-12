package artificial_intelligence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class PrincessBot {

	static void displayPathtoPrincess(int n, String[] grid) {

		int m_i = 0, m_j = 0, p_i = 0, p_j = 0;
		char cArr[] = grid[0].toCharArray();
		if (cArr[0] == 'p') {
			p_i = 0;
			p_j = 0;
		} else if (cArr[n - 1] == 'p') {
			p_i = 0;
			p_j = n - 1;
		}

		cArr = grid[n - 1].toCharArray();
		if (cArr[0] == 'p') {
			p_i = n - 1;
			p_j = 0;
		} else if (cArr[n - 1] == 'p') {
			p_i = n - 1;
			p_j = n - 1;
		}

		for (int i = 0; i < n; i++) {
			boolean found = false;
			cArr = grid[i].toCharArray();
			for (int j = 0; j < n; j++) {
				if (cArr[j] == 'm') {
					m_i = i;
					m_j = j;
					found = true;
					break;
				}
			}
			if (found) {
				break;
			}
		}

		Map<String, Integer> map = new HashMap<String, Integer>(4);
		int iDiff = p_i - m_i;
		int jDiff = p_j - m_j;
		if (jDiff == 0 && iDiff == 0) {
			System.out.print("No path found");
			return;
		}

		if (iDiff > 0) {
			map.put("DOWN", iDiff);
		} else if (iDiff < 0) {
			map.put("UP", -iDiff);
		}

		if (jDiff > 0) {
			map.put("RIGHT", jDiff);
		} else if (jDiff < 0) {
			map.put("LEFT", -jDiff);
		}

		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			String key = (String) pair.getKey();
			int value = (Integer) pair.getValue();
			for (int i = 0; i < value; i++) {
				System.out.println(key);
			}
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m;
		m = in.nextInt();
		in.nextLine();
		String grid[] = new String[m];
		for (int i = 0; i < m; i++) {
			grid[i] = in.next();
		}

		displayPathtoPrincess(m, grid);
	}
}
