package leetcode.editor.cn;

import java.util.Arrays;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>2335</p>
 * <p><strong>标题：</strong>装满杯子需要的最短总时长</p>
 * <p><strong>时间：</strong>2022-07-20 16:49:49</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>现有一台饮水机，可以制备冷水、温水和热水。每秒钟，可以装满 <code>2</code> 杯 <strong>不同</strong> 类型的水或者 <code>1</code> 杯任意类型的水。</p>
 * <p>给你一个下标从 <strong>0</strong> 开始、长度为 <code>3</code> 的整数数组 <code>amount</code> ，其中 <code>amount[0]</code>、<code>amount[1]</code> 和 <code>amount[2]</code> 分别表示需要装满冷水、温水和热水的杯子数量。返回装满所有杯子所需的 <strong>最少</strong> 秒数。</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <pre><strong>输入：</strong>amount = [1,4,2]
 * <strong>输出：</strong>4
 * <strong>解释：</strong>下面给出一种方案：
 * 第 1 秒：装满一杯冷水和一杯温水。
 * 第 2 秒：装满一杯温水和一杯热水。
 * 第 3 秒：装满一杯温水和一杯热水。
 * 第 4 秒：装满一杯温水。
 * 可以证明最少需要 4 秒才能装满所有杯子。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <pre><strong>输入：</strong>amount = [5,4,4]
 * <strong>输出：</strong>7
 * <strong>解释：</strong>下面给出一种方案：
 * 第 1 秒：装满一杯冷水和一杯热水。
 * 第 2 秒：装满一杯冷水和一杯温水。
 * 第 3 秒：装满一杯冷水和一杯温水。
 * 第 4 秒：装满一杯温水和一杯热水。
 * 第 5 秒：装满一杯冷水和一杯热水。
 * 第 6 秒：装满一杯冷水和一杯温水。
 * 第 7 秒：装满一杯热水。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 * <pre><strong>输入：</strong>amount = [5,0,0]
 * <strong>输出：</strong>5
 * <strong>解释：</strong>每秒装满一杯冷水。
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li><code>amount.length == 3</code></li>
 * <li><code>0 &lt;= amount[i] &lt;= 100</code></li>
 * </ul>
 *
 * <br><div><strong>Topics：</strong><div><li>贪心</li><li>数组</li><li>堆（优先队列）</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 * <p>之前思路一直有问题，后知后觉，发现要用最大的值先找平两个小值，再均分给两个小值，才行</p>
 */
class MinimumAmountOfTimeToFillCups {
    public static void main(String[] args) {
        Solution solution = new MinimumAmountOfTimeToFillCups().new Solution();
        System.out.println(solution.fillCups(new int[]{1,4,2}) == 4);
        System.out.println(solution.fillCups(new int[]{5,4,4}) == 7);
        System.out.println(solution.fillCups(new int[]{5,0,0}) == 5);
        System.out.println(solution.fillCups(new int[]{4,7,9}) == 10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fillCups(int[] amount) {
            Arrays.sort(amount);
//            return amount[0] + amount[1] <= amount[2] ? amount[2] : (amount[0] + amount[1] + amount[2] + 1) / 2;
            return Math.max(amount[2], (amount[0] + amount[1] + amount[2] + 1) / 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}