public class MultiArray {

	private static int count = 0;

	public static void main(String[] args) {

		int[] lengthOfDimentions = { 2, 4, 3 };
		int[] res = new int[lengthOfDimentions.length];

		iterateRecursive(0, lengthOfDimentions, res);
		//iterateForward(lengthOfDimentions);

		System.out.println("\ncount = " + count);
	}

	static void iterateForward(int[] lengthOfDimentions) {
		if (lengthOfDimentions == null || lengthOfDimentions.length == 0) {
			return;
		}

		int n = lengthOfDimentions.length;
		int[] indices = new int[n];
		int i = n - 1;

		while (i >= 0) {
			print(indices);

			for (i = n - 1; i >= 0; i--) {
				// set the index
				indices[i]++;

				if (indices[i] < lengthOfDimentions[i]) {
					break;
				}

				// reset the index
				indices[i] = 0;
			}
		}
	}

	static void iterateRecursive(int d, int lengthOfDimentions[], int res[]) {
		if (d >= res.length) { // stop clause
			print(res);
			return;
		}
		for (int i = 0; i < lengthOfDimentions[d]; i++) {
			res[d] = i;
			iterateRecursive(d + 1, lengthOfDimentions, res);
		}
	}

	static void print(int res[]) {
		count++;
		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + ", ");
		System.out.println();
	}
}


/*
0, 0, 0, 
0, 0, 1, 
0, 0, 2, 
0, 1, 0, 
0, 1, 1, 
0, 1, 2, 
0, 2, 0, 
0, 2, 1, 
0, 2, 2, 
0, 3, 0, 
0, 3, 1, 
0, 3, 2, 
1, 0, 0, 
1, 0, 1, 
1, 0, 2, 
1, 1, 0, 
1, 1, 1, 
1, 1, 2, 
1, 2, 0, 
1, 2, 1, 
1, 2, 2, 
1, 3, 0, 
1, 3, 1, 
1, 3, 2, 

count = 24
*/
