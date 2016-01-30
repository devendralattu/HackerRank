package worldcodesprint;

import java.util.Scanner;

public class TwoPluses {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();

		char c[][] = new char[N][M];
		in.nextLine();
		String str[] = new String[M];
		for (int i = 0; i < N; i++) {
			str[i] = in.nextLine();
			c[i] = str[i].toCharArray();
		}

		// max matrix;
		int max[][] = new int[N - 2][M - 2];
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				max[i][j] = 1;
			}
		}

		int maxNum = 1, secondMax = 1;
		int countB = 0, countG = 0;
		for (int i = 1; i < N; i++) {
			// left-right-top-bottom pointers;
			int l = 0, r = 0, t = 0, b = 0;
			for (int j = 1; j < M; j++) {
				if (c[i][j] != 'B') {
					countG++;

					l = j - 1;
					r = j + 1;
					t = i - 1;
					b = i + 1;
					while (true) {
						if (l < 0 || r >= M || t < 0 || b >= N) {
							break;
						} else {
							if (c[i][l] == 'G' && c[i][r] == 'G' && c[t][j] == 'G' && c[b][j] == 'G') {
								max[i - 1][j - 1] = max[i - 1][j - 1] + 4;
								max = updateMaxArrayFields(max, i - 1, j - 1, N - 2, M - 2);
								l--;
								r++;
								t--;
								b++;
							} else {
								break;
							}

							// find maxNum and second max
							if (max[i - 1][j - 1] > maxNum) {
								secondMax = maxNum;
								maxNum = max[i - 1][j - 1];
							} else if (max[i - 1][j - 1] > secondMax) {
								secondMax = max[i - 1][j - 1];
							}
						}
					}

				}
			}
		}

		countB = (N * M) - countG;
		int maxOccupied = maxNum;
		int leftOver = countG - maxOccupied;
		if (leftOver <= 0) {
			maxNum = secondMax = 0;
		}

		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				System.out.print(max[i][j]);
			}
			System.out.println();
		}

		int multiplicationResult = maxNum * secondMax;
		System.out.println(multiplicationResult);

	}

	private static int[][] updateMaxArrayFields(int[][] max, int i, int j, int n, int m) {
		int maxCurrVal = max[i][j];
		if (i - 1 >= 0) {
			max[i - 1][j] = maxCurrVal;
		}
		if (i + 1 < n) {
			max[i + 1][j] = maxCurrVal;
		}
		if (j - 1 >= 0) {
			max[i][j - 1] = maxCurrVal;
		}
		if (j + 1 < m) {
			max[i][j + 1] = maxCurrVal;
		}
		return max;
	}

}
/*
 * Sample Input 6 6 BGBBGB GGGGGG BGBBGB GGGGGG BGBBGB BGBBGB
 * 
 * Output 5115 1111 5115 1111 25
 */
