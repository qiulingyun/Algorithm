package Test.Algorithm;

public class LongestIncreasingPath {

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		// M行N列
		final int M = matrix.length, N = matrix[0].length;
		int res = 0;
		int[][] dp = new int[M][N]; // Longest Path begin from each point
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				res = Math.max(res, dfs(matrix, i, j, dp));
			}
		}
		return res;
	}

	public int dfs(int[][] matrix, int i, int j, int[][] dp) {
		if (dp[i][j] > 0) {
			return dp[i][j];
		}
		
		final int M = matrix.length, N = matrix[0].length;
		int val = matrix[i][j];
		int pathML = 1;
		// up
		if (i - 1 >= 0 && matrix[i - 1][j] > val) {
			if (dp[i - 1][j] > 0) {
				pathML = Math.max(pathML, dp[i - 1][j] + 1);
			} else {
				pathML = Math.max(pathML, dfs(matrix, i - 1, j, dp) + 1);
			}
		}
		// down
		if (i + 1 < M && matrix[i + 1][j] > val) {
			if (dp[i + 1][j] > 0) {
				pathML = Math.max(pathML, dp[i + 1][j] + 1);
			} else {
				pathML = Math.max(pathML, dfs(matrix, i + 1, j, dp) + 1);
			}
		}
		// left
		if (j - 1 >= 0 && matrix[i][j - 1] > val) {
			if (dp[i][j - 1] > 0) {
				pathML = Math.max(pathML, dp[i][j - 1] + 1);
			} else {
				pathML = Math.max(pathML, dfs(matrix, i, j - 1, dp) + 1);
			}
		}
		// right
		if (j + 1 < N && matrix[i][j + 1] > val) {
			if (dp[i][j + 1] > 0) {
				pathML = Math.max(pathML, dp[i][j + 1] + 1);
			} else {
				pathML = Math.max(pathML, dfs(matrix, i, j + 1, dp) + 1);
			}
		}
		dp[i][j] = pathML;
		return pathML;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingPath obj = new LongestIncreasingPath();
		int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		System.out.println(obj.longestIncreasingPath(matrix));
	}

}
