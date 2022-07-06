package leetcode.editor.cn;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>268</p>
 * <p><strong>标题：</strong>丢失的数字</p>
 * <p><strong>时间：</strong>2022-07-06 18:58:16</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>给定一个包含 <code>[0, n]</code>&nbsp;中&nbsp;<code>n</code>&nbsp;个数的数组 <code>nums</code> ，找出 <code>[0, n]</code> 这个范围内没有出现在数组中的那个数。</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <pre>
 * <strong>输入：</strong>nums = [3,0,1]
 * <strong>输出：</strong>2
 * <b>解释：</b>n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <pre>
 * <strong>输入：</strong>nums = [0,1]
 * <strong>输出：</strong>2
 * <b>解释：</b>n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。</pre>
 *
 * <p><strong>示例 3：</strong></p>
 * <pre>
 * <strong>输入：</strong>nums = [9,6,4,2,3,5,7,0,1]
 * <strong>输出：</strong>8
 * <b>解释：</b>n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。</pre>
 *
 * <p><strong>示例 4：</strong></p>
 * <pre>
 * <strong>输入：</strong>nums = [0]
 * <strong>输出：</strong>1
 * <b>解释：</b>n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。</pre>
 *
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li><code>n == nums.length</code></li>
 * <li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= nums[i] &lt;= n</code></li>
 * <li><code>nums</code> 中的所有数字都 <strong>独一无二</strong></li>
 * </ul>
 *
 * <p><strong>进阶：</strong>你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?</p>
 *
 * <br><div><strong>Topics：</strong><div><li>位运算</li><li>数组</li><li>哈希表</li><li>数学</li><li>二分查找</li><li>排序</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 */
class MissingNumber {
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}) == 2);
        System.out.println(solution.missingNumber(new int[]{0, 1}) == 2);
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}) == 8);
        System.out.println(solution.missingNumber(new int[]{0}) == 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 第一想到的方法，求和，可以解决，但是可能会有溢出问题
        public int missingNumber1(int[] nums) {
            int length = nums.length;
            int num = 0;
            for (int i = 0; i < length; i++) {
                num += nums[i];
            }
            return length * (length + 1) / 2 - num;
        }


        // 优秀解法，使用异或
        public int missingNumber(int[] nums) {
            int length = nums.length;
            int flag = length;
            for (int i = 0; i < length; i++) {
                flag = flag ^ i ^ nums[i];
            }
            return flag;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}