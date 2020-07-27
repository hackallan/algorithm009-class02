package structure.work07;

/**
 * func：
 *
 * @Author： allanQin
 * @Date: 2020/7/5 21:58
 */
public class HomeWork {

    /**
     * 爬楼梯
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        return climb_stairs(n);

    }


    public int climb_stairs(int n)
    {

        if( n==1 ) {
            return 1;
        }

        if(n ==2 ) {
            return 2;
        }

        int[] array = new int[n+1];
        array[1] = 1;
        array[2] =2;
        for ( int i=3;i<n+1;i++) {
            array[i] = array[i-1] + array[i-2];
        }
        return array[n];
    }

    private int row;

    private int column;

    /**
     * 岛屿数量
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        int count = 0;
        row = grid.length;
        if (row == 0) return 0;

        column = grid[0].length;
        //遍历每个点，看看是否是陆地，如果是陆地，那么将其周围是陆地的地方全设置为0，也就不用遍历除非遇到下个岛屿情况
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
            }


        }

        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= row || j >= column || grid[i][j] != '1') return;

        //如果该点为1 ，也就是陆地将其致为0。那么它的上下左右也都致为0，包括它的邻居的邻居递归下去
        grid[i][j] = '0';

        DFSMarking(grid, i, j - 1);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i + 1, j);

    }
}
