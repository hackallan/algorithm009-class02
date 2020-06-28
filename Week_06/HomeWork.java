package structure.work06;

/**
 * func：
 *
 * @Author： allanQin
 * @Date: 2020/6/23 11:23re
 */
public class HomeWork {


    /**
     * 198. 打家劫舍
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int[] a = new int[n];

        a[0] = nums[0];
        a[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(a[0], a[1]);

        for (int i = 2; i < n; i++) {
            a[i] = Math.max(a[i - 1], a[i - 2] + nums[i]);
            res = Math.max(res, a[i]);
        }

        return res;

    }

    /**
     * 回文子串
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int N =s.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }


    /**
     * 最小路径和
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }

}
