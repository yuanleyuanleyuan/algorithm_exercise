package leetcode.editor.cn;

import java.util.HashMap;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>873</p>
 * <p><strong>标题：</strong>最长的斐波那契子序列的长度</p>
 * <p><strong>时间：</strong>2022-07-09 18:43:38</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>如果序列 <code>X_1, X_2, ..., X_n</code> 满足下列条件，就说它是 <em>斐波那契式 </em>的：</p>
 * <ul>
 * <li><code>n >= 3</code></li>
 * <li>对于所有 <code>i + 2 <= n</code>，都有 <code>X_i + X_{i+1} = X_{i+2}</code></li>
 * </ul>
 * <p>给定一个<strong>严格递增</strong>的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。</p>
 * <p><em>（回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， <code>[3, 5, 8]</code> 是 <code>[3, 4, 5, 6, 7, 8]</code> 的一个子序列）</em></p>
 *
 * <p><strong>示例 1：</strong></p>
 * <pre>
 * <strong>输入: </strong>arr =<strong> </strong>[1,2,3,4,5,6,7,8]
 * <strong>输出: </strong>5
 * <strong>解释: </strong>最长的斐波那契式子序列为 [1,2,3,5,8] 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <pre>
 * <strong>输入: </strong>arr =<strong> </strong>[1,3,7,11,12,14,18]
 * <strong>输出: </strong>3
 * <strong>解释</strong>: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li><code>3 <= arr.length <= 1000</code></li>
 * <li>
 * <p><code>1 <= arr[i] < arr[i + 1] <= 10^9</code></p>
 * </li>
 * </ul>
 *
 * <br><div><strong>Topics：</strong><div><li>数组</li><li>哈希表</li><li>动态规划</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 */
class LengthOfLongestFibonacciSubsequence {
    public static void main(String[] args) {
        Solution solution = new LengthOfLongestFibonacciSubsequence().new Solution();
        System.out.println(solution.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}) == 5);
        System.out.println(solution.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}) == 3);
        System.out.println(solution.lenLongestFibSubseq(new int[]{1, 3, 5}) == 0);
        System.out.println(solution.lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50}) == 5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 没有思路，直接暴力
        public int lenLongestFibSubseq1(int[] arr) {

            int count = 0;
            int length = arr.length;

            // 记录数组最大值
            int max = arr[length - 1];

            // 准备一个map，存下标
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], i);
            }

            // 两两组合，遍历数组
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {

                    int flag = 0;
                    int a = arr[i];
                    int b = arr[j];
                    Integer index;

                    while ((a + b) <= max) {
                        index = map.get(a + b);
                        if (index == null) break;

                        a = b;
                        b = arr[index];
                        flag++;
                    }

                    count = Math.max(count, flag);

                }
            }

            return count == 0 ? count : count + 2;

        }

        // 使用动态规划
        public int lenLongestFibSubseq(int[] arr) {

            int count = 0;
            int length = arr.length;

            // 准备一个map，存下标
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], i);
            }

            // 准备一个数组，存长度
            int[][] countArr = new int[length][length];

            Integer index;
            for (int i = 2; i < length; i++) {
                for (int j = i - 1; j > 0 && arr[j] * 2 > arr[i]; j--) {
                    index = map.get(arr[i] - arr[j]);
                    if (index == null) continue;
                    countArr[j][i] = countArr[index][j] + 1;
                    count = Math.max(count, countArr[j][i]);
                }

            }

            return count == 0 ? count : count + 2;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}