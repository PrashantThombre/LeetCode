package array;

public class Solution10ValidSudoku {
	/*
	 * Link:
	 * https://leetcode.com/explore/interview/card/top-interview-questions-
	 * easy/92/array/770/
	 * 
	 * Problem Title: Rotate Image
	 */

	public void rotate(int[][] matrix) {
		// transpose
		transpose(matrix);

		// Flip Horizontally
		flip(matrix);

	}

	private void transpose(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				if (i == j) {
					continue;
				}
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	private void flip(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[0].length - j - 1];
				matrix[i][matrix[0].length - j - 1] = temp;
				System.out.print("=");
			}
		}
	}
}
