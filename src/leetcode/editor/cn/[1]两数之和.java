package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>1</p>
 * <p><strong>标题：</strong>两数之和</p>
 * <p><strong>时间：</strong>2022-06-29 17:05:18</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>给定一个整数数组 <code>nums</code>&nbsp;和一个整数目标值 <code>target</code>，请你在该数组中找出和为目标值<code>target</code>的那两个整数，并返回它们的数组下标。</p>
 * <p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。</p>
 * <p>你可以按任意顺序返回答案。</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <pre>
 * <strong>输入：</strong>nums = [2,7,11,15], target = 9
 * <strong>输出：</strong>[0,1]
 * <strong>解释：</strong>因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <pre>
 * <strong>输入：</strong>nums = [3,2,4], target = 6
 * <strong>输出：</strong>[1,2]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 * <pre>
 * <strong>输入：</strong>nums = [3,3], target = 6
 * <strong>输出：</strong>[0,1]
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * <li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
 * <li><strong>只会存在一个有效答案</strong></li>
 * </ul>
 *
 * <p><strong>进阶：</strong>你可以想出一个时间复杂度小于 <code>O(n<sup>2</sup>)</code> 的算法吗？</p>
 *
 * <br><div><strong>Topics：</strong><div><li>数组</li><li>哈希表</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 */
class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();

        int[] arr1 = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.equals(arr1, new int[]{0, 1}));

        int[] arr2 = solution.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.equals(arr2, new int[]{1, 2}));

        int[] arr3 = solution.twoSum(new int[]{3, 3}, 6);
        System.out.println(Arrays.equals(arr3, new int[]{0, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                Integer flag = map.get(nums[i]);
                if (flag != null) return new int[]{flag, i};
                map.put(target - nums[i], i);
            }

            return new int[2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}