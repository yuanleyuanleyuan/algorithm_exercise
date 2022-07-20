package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>1260</p>
 * <p><strong>标题：</strong>二维网格迁移</p>
 * <p><strong>时间：</strong>2022-07-20 09:30:05</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>给你一个 <code>m</code> 行 <code>n</code> 列的二维网格 <code>grid</code> 和一个整数 <code>k</code>。你需要将 <code>grid</code> 迁移 <code>k</code> 次。</p>
 * <p>每次「迁移」操作将会引发下述活动：</p>
 * <ul>
 * <li>位于 <code>grid[i][j]</code> 的元素将会移动到 <code>grid[i][j + 1]</code>。</li>
 * <li>位于 <code>grid[i][n - 1]</code> 的元素将会移动到 <code>grid[i + 1][0]</code>。</li>
 * <li>位于 <code>grid[m - 1][n - 1]</code> 的元素将会移动到 <code>grid[0][0]</code>。</li>
 * </ul>
 * <p>请你返回 <code>k</code> 次迁移操作后最终得到的 <strong>二维网格</strong>。</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/16/e1-1.png" style="height: 158px; width: 400px;" /></p>
 * <pre>
 * <code><strong>输入：</strong>grid</code> = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * <strong>输出：</strong>[[9,1,2],[3,4,5],[6,7,8]]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/16/e2-1.png" style="height: 166px; width: 400px;" /></p>
 * <pre>
 * <code><strong>输入：</strong>grid</code> = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * <strong>输出：</strong>[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 * <pre>
 * <code><strong>输入：</strong>grid</code> = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * <strong>输出：</strong>[[1,2,3],[4,5,6],[7,8,9]]
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li><code>m == grid.length</code></li>
 * <li><code>n == grid[i].length</code></li>
 * <li><code>1 <= m <= 50</code></li>
 * <li><code>1 <= n <= 50</code></li>
 * <li><code>-1000 <= grid[i][j] <= 1000</code></li>
 * <li><code>0 <= k <= 100</code></li>
 * </ul>
 *
 * <br><div><strong>Topics：</strong><div><li>数组</li><li>矩阵</li><li>模拟</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 */
class Shift2dGrid {
    public static void main(String[] args) {
        Solution solution = new Shift2dGrid().new Solution();
        List<List<Integer>> lists1 = solution.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
        List<List<Integer>> lists2 = solution.shiftGrid(new int[][]{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}}, 4);
        List<List<Integer>> lists3 = solution.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 9);
        List<List<Integer>> lists4 = solution.shiftGrid(new int[][]{{1}, {2}, {3}, {4}, {7}, {6}, {5}}, 23);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            List<List<Integer>> lists = new ArrayList<>(m);
            k = k % (m * n);
            int x, y;

            for (int i = 0; i < m; i++) {
                ArrayList<Integer> list = new ArrayList<>(n);
                for (int j = 0; j < n; j++) {
                    list.add(grid[(i - k / n - (k % n > j ? 1 : 0) + m) % m][(j - k % n + n) % n]);
                }
                lists.add(list);
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}