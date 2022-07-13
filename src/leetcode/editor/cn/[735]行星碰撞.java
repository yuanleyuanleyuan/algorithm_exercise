package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>735</p>
 * <p><strong>标题：</strong>行星碰撞</p>
 * <p><strong>时间：</strong>2022-07-13 10:52:38</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>给定一个整数数组 <code>asteroids</code>，表示在同一行的行星。</p>
 * <p>对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。</p>
 * <p>找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <pre>
 * <strong>输入：</strong>asteroids = [5,10,-5]
 * <strong>输出：</strong>[5,10]
 * <b>解释：</b>10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <pre>
 * <strong>输入：</strong>asteroids = [8,-8]
 * <strong>输出：</strong>[]
 * <b>解释：</b>8 和 -8 碰撞后，两者都发生爆炸。</pre>
 *
 * <p><strong>示例 3：</strong></p>
 * <pre>
 * <strong>输入：</strong>asteroids = [10,2,-5]
 * <strong>输出：</strong>[10]
 * <b>解释：</b>2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。</pre>
 *
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li><code>2 &lt;= asteroids.length&nbsp;&lt;= 10<sup>4</sup></code></li>
 * <li><code>-1000 &lt;= asteroids[i] &lt;= 1000</code></li>
 * <li><code>asteroids[i] != 0</code></li>
 * </ul>
 *
 * <br><div><strong>Topics：</strong><div><li>栈</li><li>数组</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 */
class AsteroidCollision {
    public static void main(String[] args) {
        Solution solution = new AsteroidCollision().new Solution();
        System.out.println(Arrays.equals(solution.asteroidCollision(new int[]{5, 10, -5}), new int[]{5, 10}));
        System.out.println(Arrays.equals(solution.asteroidCollision(new int[]{8, -8}), new int[0]));
        System.out.println(Arrays.equals(solution.asteroidCollision(new int[]{10, 2, -5}), new int[]{10}));
        System.out.println(Arrays.equals(solution.asteroidCollision(new int[]{-2, -1, 1, 2}), new int[]{-2, -1, 1, 2}));
        System.out.println(Arrays.equals(solution.asteroidCollision(new int[]{-2, -2, 1, -2}), new int[]{-2, -2, -2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {

            LinkedList<Integer> linkedList = new LinkedList<>();

            for (int i = 0; i < asteroids.length; i++) {
                if (linkedList.isEmpty() || linkedList.getLast() < 0 || asteroids[i] > 0) {
                    linkedList.addLast(asteroids[i]);
                    continue;
                }

                if (linkedList.getLast() <= asteroids[i] * -1) {
                    if (linkedList.getLast() < asteroids[i] * -1) i--;
                    linkedList.removeLast();
                }

            }

            return linkedList.stream().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}