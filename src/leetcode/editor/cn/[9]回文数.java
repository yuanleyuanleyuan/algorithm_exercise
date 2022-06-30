package leetcode.editor.cn;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>9</p>
 * <p><strong>标题：</strong>回文数</p>
 * <p><strong>时间：</strong>2022-06-30 19:11:21</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>给你一个整数 <code>x</code> ，如果 <code>x</code> 是一个回文整数，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>
 * <p>回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。</p>
 * <ul>
 * <li>例如，<code>121</code> 是回文，而 <code>123</code> 不是。</li>
 * </ul>
 *
 * <p><strong>示例 1：</strong></p>
 * <pre>
 * <strong>输入：</strong>x = 121
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <pre>
 * <strong>输入：</strong>x = -121
 * <strong>输出：</strong>false
 * <strong>解释：</strong>从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 * <pre>
 * <strong>输入：</strong>x = 10
 * <strong>输出：</strong>false
 * <strong>解释：</strong>从右向左读, 为 01 。因此它不是一个回文数。
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li><code>-2<sup>31</sup>&nbsp;&lt;= x &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
 * </ul>
 *
 * <p><strong>进阶：</strong>你能不将整数转为字符串来解决这个问题吗？</p>
 *
 * <br><div><strong>Topics：</strong><div><li>数学</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 */
class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(!solution.isPalindrome(-121));
        System.out.println(!solution.isPalindrome(10));
        System.out.println(solution.isPalindrome(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x == 0) return true;
            if (x < 0 || x % 10 == 0) return false;

            int left = x;
            int right = 0;

            while (right < left) {
                right = right * 10 + left % 10;
                left /= 10;
            }

            return right == left || right / 10 == left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}