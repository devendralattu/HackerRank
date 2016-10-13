import java.math.BigInteger;
import java.util.Scanner;

public class ModifiedFibonacci {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String sArr[] = s.split(" ");
		int t1 = Integer.parseInt(sArr[0]);
		int t2 = Integer.parseInt(sArr[1]);
		int n = Integer.parseInt(sArr[2]);

		BigInteger t1B = BigInteger.valueOf(t1);
		BigInteger t2B = BigInteger.valueOf(t2);
		BigInteger tnB = (t2B.multiply(t2B)).add(t1B);

		int tn = t1 + t2 * t2;
		for (int i = 3; i < n; i++) {
			t1B = t2B;
			t2B = tnB;
			tnB = (t2B.multiply(t2B)).add(t1B);
		}
		System.out.print(tnB);
	}
}
