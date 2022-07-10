package leetcode.editor.cn;

import java.util.Arrays;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>741</p>
 * <p><strong>标题：</strong>摘樱桃</p>
 * <p><strong>时间：</strong>2022-07-10 14:29:28</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>一个N x N的网格<code>(grid)</code>&nbsp;代表了一块樱桃地，每个格子由以下三种数字的一种来表示：</p>
 * <ul>
 * <li>0 表示这个格子是空的，所以你可以穿过它。</li>
 * <li>1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。</li>
 * <li>-1 表示这个格子里有荆棘，挡着你的路。</li>
 * </ul>
 * <p>你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：</p>
 * <ul>
 * <li>从位置&nbsp;(0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；</li>
 * <li>当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；</li>
 * <li>当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；</li>
 * <li>如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。</li>
 * </ul>
 *
 * <p><strong>示例 1:</strong></p>
 * <pre>
 * <strong>输入:</strong> grid =
 * [[0, 1, -1],
 * [1, 0, -1],
 * [1, 1,  1]]
 * <strong>输出:</strong> 5
 * <strong>解释：</strong>
 * 玩家从（0,0）点出发，经过了向下走，向下走，向右走，向右走，到达了点(2, 2)。
 * 在这趟单程中，总共摘到了4颗樱桃，矩阵变成了[[0,1,-1],[0,0,-1],[0,0,0]]。
 * 接着，这名玩家向左走，向上走，向上走，向左走，返回了起始点，又摘到了1颗樱桃。
 * 在旅程中，总共摘到了5颗樱桃，这是可以摘到的最大值了。
 * </pre>
 *
 * <p><strong>说明:</strong></p>
 * <ul>
 * <li><code>grid</code> 是一个&nbsp;<code>N</code> * <code>N</code> 的二维数组，N的取值范围是<code>1 &lt;= N &lt;= 50</code>。</li>
 * <li>每一个&nbsp;<code>grid[i][j]</code> 都是集合&nbsp;<code>{-1, 0, 1}</code>其中的一个数。</li>
 * <li>可以保证起点&nbsp;<code>grid[0][0]</code>&nbsp;和终点&nbsp;<code>grid[N-1][N-1]</code>&nbsp;的值都不会是 -1。</li>
 * </ul>
 *
 * <br><div><strong>Topics：</strong><div><li>数组</li><li>动态规划</li><li>矩阵</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 * <p>用例三直接给我上了一课，单独走两次是不可行的</p>
 */
class CherryPickup {
    public static void main(String[] args) {
        Solution solution = new CherryPickup().new Solution();
        System.out.println(solution.cherryPickup(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}) == 5);
        System.out.println(solution.cherryPickup(new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}}) == 0);
        System.out.println(solution.cherryPickup(new int[][]{{1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1}}) == 15);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 用例三直接给我上了一课，单独走两次是不可行的
        public int cherryPickup1(int[][] grid) {

            int length = grid.length;
            int count;
            int[][] arr = new int[length][length];

            // 先填充右下两条边
            arr[length - 1][length - 1] = grid[length - 1][length - 1];
            for (int j = length - 2; j >= 0; j--) {
                arr[length - 1][j] = grid[length - 1][j] == -1 ? -1 : grid[length - 1][j] + arr[length - 1][j + 1];
                arr[j][length - 1] = grid[j][length - 1] == -1 ? -1 : grid[j][length - 1] + arr[j + 1][length - 1];
            }
            // 再填充内部
            for (int i = length - 2; i >= 0; i--) {
                arr[i][i] = grid[i][i] == -1 || (arr[i + 1][i] == -1 && arr[i][i + 1] == -1) ? -1 : grid[i][i] + Math.max(arr[i + 1][i], arr[i][i + 1]);
                for (int j = i - 1; j >= 0; j--) {
                    arr[i][j] = grid[i][j] == -1 || (arr[i][j + 1] == -1 && arr[i + 1][j] == -1) ? -1 : grid[i][j] + Math.max(arr[i][j + 1], arr[i + 1][j]);
                    arr[j][i] = grid[j][i] == -1 || (arr[j][i + 1] == -1 && arr[j + 1][i] == -1) ? -1 : grid[j][i] + Math.max(arr[j][i + 1], arr[j + 1][i]);
                }
            }


            // 没有可经过的路径，或者摘到的数目为0
            if (arr[0][0] < 1) return 0;

            count = arr[0][0];

            // 清空完摘到的樱桃
            grid[0][0] = 0;
            for (int i = 0, j = 0; !(i == length - 1 && j == length - 1); ) {
                if (i == length - 1) {
                    j++;
                    grid[i][j] = 0;
                    continue;
                }
                if (j == length - 1) {
                    i++;
                    grid[i][j] = 0;
                    continue;
                }

                if (arr[i + 1][j] > arr[i][j + 1]) {
                    i++;
                } else {
                    j++;
                }

                grid[i][j] = 0;

            }


            // 再走一遍
            arr[length - 1][length - 1] = grid[length - 1][length - 1];
            for (int j = length - 2; j >= 0; j--) {
                arr[length - 1][j] = grid[length - 1][j] == -1 ? -1 : grid[length - 1][j] + arr[length - 1][j + 1];
                arr[j][length - 1] = grid[j][length - 1] == -1 ? -1 : grid[j][length - 1] + arr[j + 1][length - 1];
            }
            for (int i = length - 2; i >= 0; i--) {
                arr[i][i] = grid[i][i] == -1 || (arr[i + 1][i] == -1 && arr[i][i + 1] == -1) ? -1 : grid[i][i] + Math.max(arr[i + 1][i], arr[i][i + 1]);
                for (int j = i - 1; j >= 0; j--) {
                    arr[i][j] = grid[i][j] == -1 || (arr[i][j + 1] == -1 && arr[i + 1][j] == -1) ? -1 : grid[i][j] + Math.max(arr[i][j + 1], arr[i + 1][j]);
                    arr[j][i] = grid[j][i] == -1 || (arr[j][i + 1] == -1 && arr[j + 1][i] == -1) ? -1 : grid[j][i] + Math.max(arr[j][i + 1], arr[j + 1][i]);
                }
            }


            return count + arr[0][0];

        }

        // 太难了，直接答案走起了
        public int cherryPickup2(int[][] grid) {

            int length = grid.length;

            int[][][] arr = new int[length * 2 - 1][length][length];
            for (int i = 0; i < length * 2 - 1; ++i) {
                for (int j = 0; j < length; ++j) {
                    Arrays.fill(arr[i][j], Integer.MIN_VALUE);
                }
            }

            arr[0][0][0] = grid[0][0];

            int y1, y2, flag;
            for (int k = 1; k < length * 2 - 1; k++) {
                for (int x1 = Math.max(k - length + 1, 0); x1 <= Math.min(k, length - 1); x1++) {
                    y1 = k - x1;
                    if (grid[x1][y1] == -1) continue;

                    for (int x2 = x1; x2 <= Math.min(k, length - 1); x2++) {

                        y2 = k - x2;
                        if (grid[x2][y2] == -1) continue;

                        flag = arr[k - 1][x1][x2];

                        if (x1 > 0) {
                            flag = Math.max(flag, arr[k - 1][x1 - 1][x2]);
                        }
                        if (x2 > 0) {
                            flag = Math.max(flag, arr[k - 1][x1][x2 - 1]);
                        }
                        if (x1 > 0 && x2 > 0) {
                            flag = Math.max(flag, arr[k - 1][x1 - 1][x2 - 1]);
                        }

                        if (x1 == x2) {
                            arr[k][x1][x2] = flag + grid[x1][y1];
                        } else {
                            arr[k][x1][x2] = flag + grid[x1][y1] + grid[x2][y2];
                        }

                    }
                }
            }


            return Math.max(arr[length * 2 - 2][length - 1][length - 1], 0);

        }

        // 另一个答案
        public int cherryPickup(int[][] grid) {
            int length = grid.length;
            int[][] arr = new int[length][length];
            for (int i = 0; i < length; ++i) {
                Arrays.fill(arr[i], Integer.MIN_VALUE);
            }
            arr[0][0] = grid[0][0];
            for (int k = 1; k < length * 2 - 1; k++) {
                for (int x1 = Math.min(k, length - 1); x1 >= Math.max(k - length + 1, 0); x1--) {
                    for (int x2 = Math.min(k, length - 1); x2 >= x1; x2--) {
                        int y1 = k - x1, y2 = k - x2;
                        if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                            arr[x1][x2] = Integer.MIN_VALUE;
                            continue;
                        }
                        int flag = arr[x1][x2]; // 都往右
                        if (x1 > 0) {
                            flag = Math.max(flag, arr[x1 - 1][x2]); // 往下，往右
                        }
                        if (x2 > 0) {
                            flag = Math.max(flag, arr[x1][x2 - 1]); // 往右，往下
                        }
                        if (x1 > 0 && x2 > 0) {
                            flag = Math.max(flag, arr[x1 - 1][x2 - 1]); // 都往下
                        }

                        if (x1 == x2) {
                            arr[x1][x2] = flag + grid[x1][y1];
                        } else {
                            arr[x1][x2] = flag + grid[x1][y1] + grid[x2][y2];
                        }

                    }
                }
            }

            return Math.max(arr[length - 1][length - 1], 0);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}