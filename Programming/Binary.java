import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// find no. of 1's in a binary representation of a number
		int a = in.nextInt();
		int b = a, num = a;
		int c = 0;

		// method 1
		System.out.println("\nMethod 1");
		String str = "";
		while (a != 0) {
			c = c + (a & 1);
			str = (a & 1) + str;
			a = a >> 1;
		}

		System.out.println(str);
		System.out.println("c = " + c);

		// method 2
		System.out.println("\nMethod 2");
		c = 0;
		int reminder = 1;
		String str1 = "";
		while (b != 0) {
			reminder = b % 2;
			if (reminder == 1) {
				c++;
			}
			b = b / 2;
			str1 = reminder + str1;
		}

		System.out.println(str1);
		System.out.println("c = " + c);

		// find if number is power of 2
		System.out.println("\nMethod 1");
		System.out.println(Integer.toBinaryString(num) + " = " + num);
		System.out.println(Integer.toBinaryString(num - 1) + " = " + (num - 1));
		int addRes = (num & (num - 1));
		System.out.println(Integer.toBinaryString(addRes) + " = " + addRes);
		if ((num & num - 1) == 0) {
			System.out.println(num + " is power of 2.");
		} else {
			System.out.println(num + " is NOT power of 2.");
		}

		// method 2
		System.out.println("\nMethod 2");
		System.out.println("Binary num = " + Integer.toBinaryString(num));
		double d = Math.log(num) / Math.log(2);
		System.out.println("d = " + d);
		int di = (int) d;
		if (di == d) {
			System.out.println(num + " is power of 2.");
		} else {
			System.out.println(num + " is NOT power of 2.");
		}

		// method 3
		System.out.println("\nMethod 3");
		c = 0;
		b = num;
		while (b != 0) {
			reminder = b % 2;
			b = b / 2;
			if (reminder == 1) {
				c++;
			}
		}
		System.out.println("Number of 1's in " + num + " = " + c);
		if (c == 1 || num == 1) {
			System.out.println(num + " is power of 2.");
		} else {
			System.out.println(num + " is NOT power of 2.");
		}
	}

}
