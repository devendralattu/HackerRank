import java.util.Scanner;

public class MiddlePoint {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int a[] = new int[4];

		String str = "";
		while (N-- > 0) {
			int i = 0;
			int M = 4;
			while (M-- > 0) {
				a[i++] = in.nextInt();
			}

			int newX = 0;
			int newY = 0;

			if (a[2] >= a[0]) {
				if (a[3] > a[0]) {
					newY = a[3] + Math.abs(a[1] - a[3]);
				} else {
					newY = a[3] - Math.abs(a[1] - a[3]);
				}
				newX = a[2] + Math.abs(a[0] - a[2]);
			} else if (a[3] >= a[1]) {
				if (a[2] > a[0]) {
					newX = a[2] + Math.abs(a[0] - a[2]);
				} else {
					newX = a[2] - Math.abs(a[0] - a[2]);
				}
				newY = a[3] + Math.abs(a[1] - a[3]);
			} else if (a[2] < a[0] && a[3] < a[1]) {
				newX = a[2] - Math.abs(a[0] - a[2]);
				newY = a[3] - Math.abs(a[1] - a[3]);
			}

			str = str + newX + " " + newY + "\n";
		}
		System.out.println(str);
	}

}
