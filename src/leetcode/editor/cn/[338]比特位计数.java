package leetcode.editor.cn;

import java.util.Arrays;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>338</p>
 * <p><strong>标题：</strong>比特位计数</p>
 * <p><strong>时间：</strong>2022-07-07 21:49:24</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>给你一个整数 <code>n</code> ，对于&nbsp;<code>0 &lt;= i &lt;= n</code> 中的每个 <code>i</code> ，计算其二进制表示中 <strong><code>1</code> 的个数</strong> ，返回一个长度为 <code>n + 1</code> 的数组 <code>ans</code> 作为答案。</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <pre>
 * <strong>输入：</strong>n = 2
 * <strong>输出：</strong>[0,1,1]
 * <strong>解释：</strong>
 * 0 --&gt; 0
 * 1 --&gt; 1
 * 2 --&gt; 10
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <pre>
 * <strong>输入：</strong>n = 5
 * <strong>输出：</strong>[0,1,1,2,1,2]
 * <strong>解释：</strong>
 * 0 --&gt; 0
 * 1 --&gt; 1
 * 2 --&gt; 10
 * 3 --&gt; 11
 * 4 --&gt; 100
 * 5 --&gt; 101
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li><code>0 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <p><strong>进阶：</strong></p>
 * <ul>
 * <li>很容易就能实现时间复杂度为 <code>O(n log n)</code> 的解决方案，你可以在线性时间复杂度 <code>O(n)</code> 内用一趟扫描解决此问题吗？</li>
 * <li>你能不使用任何内置函数解决此问题吗？（如，C++ 中的&nbsp;<code>__builtin_popcount</code> ）</li>
 * </ul>
 *
 * <br><div><strong>Topics：</strong><div><li>位运算</li><li>动态规划</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 */
class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
        System.out.println(Arrays.equals(solution.countBits(2), new int[]{0, 1, 1}));
        System.out.println(Arrays.equals(solution.countBits(5), new int[]{0, 1, 1, 2, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 我的解法
        public int[] countBits1(int n) {
            int[] arr = new int[n + 1];
            int flag;
            for (int i = 0; i <= n; i++) {
                flag = i;
                arr[i] = 0;
                while (flag > 0) {
                    // 每次取最后一个比特位，然后相加
                    arr[i] += flag & 1;
                    flag = flag >>> 1;
                }
            }
            return arr;
        }

        // 另外一种复杂度更小的，位运算解法，Brian Kernighan 算法
        public int[] countBits2(int n) {
            int[] arr = new int[n + 1];
            int flag;
            for (int i = 0; i <= n; i++) {
                flag = i;
                arr[i] = 0;
                while (flag > 0) {
                    // 该运算将 x 的二进制表示的最后一个 1 变成 0
                    // 把x写作A1B（其中A为随意值，B为若干个0）这时x-1的值是A0C，所以x&(x-1) = A0B
                    flag &= (flag - 1);
                    arr[i]++;
                }
            }
            return arr;
        }

        // 优秀解法，动态规划——最高有效位
        public int[] countBits3(int n) {
            int[] arr = new int[n + 1];
            int flag = 0;
            arr[0] = 0;
            for (int i = 1; i <= n; i++) {
                if ((i & (i - 1)) == 0) flag = i;
                arr[i] = arr[i - flag] + 1;
            }
            return arr;
        }

        // 优秀解法，动态规划——最低有效位
        public int[] countBits4(int n) {
            int[] arr = new int[n + 1];
            arr[0] = 0;
            for (int i = 1; i <= n; i++) {
                arr[i] = arr[i >>> 1] + (i & 1);
            }
            return arr;
        }

        // 优秀解法，动态规划——最低设置位
        public int[] countBits(int n) {
            int[] arr = new int[n + 1];
            arr[0] = 0;
            for (int i = 1; i <= n; i++) {
                arr[i] = arr[i & (i - 1)] + 1;
            }
            return arr;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}