package leetcode.editor.cn;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>67</p>
 * <p><strong>标题：</strong>二进制求和</p>
 * <p><strong>时间：</strong>2022-07-19 17:10:55</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>给你两个二进制字符串，返回它们的和（用二进制表示）。</p>
 * <p>输入为 <strong>非空 </strong>字符串且只包含数字&nbsp;<code>1</code>&nbsp;和&nbsp;<code>0</code>。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 * <pre><strong>输入:</strong> a = &quot;11&quot;, b = &quot;1&quot;
 * <strong>输出:</strong> &quot;100&quot;</pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 * <pre><strong>输入:</strong> a = &quot;1010&quot;, b = &quot;1011&quot;
 * <strong>输出:</strong> &quot;10101&quot;</pre>
 *
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li>每个字符串仅由字符 <code>&#39;0&#39;</code> 或 <code>&#39;1&#39;</code> 组成。</li>
 * <li><code>1 &lt;= a.length, b.length &lt;= 10^4</code></li>
 * <li>字符串如果不是 <code>&quot;0&quot;</code> ，就都不含前导零。</li>
 * </ul>
 *
 * <br><div><strong>Topics：</strong><div><li>位运算</li><li>数学</li><li>字符串</li><li>模拟</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 */
class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int la = a.length();
            int lb = b.length();
            int length = Math.max(la, lb) + 1;
            char[] arr = new char[length];
            char flag= '0';
            char a1, b1;

            for (int i = 0; i < length; i++) {
                a1 = i < la && a.charAt(la - i - 1) == '1' ? '1' : '0';
                b1 = i < lb && b.charAt(lb - i - 1) == '1' ? '1' : '0';
                arr[length - i - 1] = (char) (a1 ^ b1 ^ flag);
                flag = (char) ((a1 & b1) ^ (b1 & flag) ^ (a1 & flag));
            }
            return arr[0] == '1' ? new String(arr, 0, length) : new String(arr, 1, length - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}