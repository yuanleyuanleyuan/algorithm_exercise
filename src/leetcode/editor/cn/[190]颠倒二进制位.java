package leetcode.editor.cn;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>190</p>
 * <p><strong>标题：</strong>颠倒二进制位</p>
 * <p><strong>时间：</strong>2022-07-19 18:47:03</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>颠倒给定的 32 位无符号整数的二进制位。</p>
 *
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li>请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。</li>
 * <li>在 Java 中，编译器使用<a href="https://baike.baidu.com/item/二进制补码/5295284" target="_blank">二进制补码</a>记法来表示有符号整数。因此，在 <strong>示例 2</strong>&nbsp;中，输入表示有符号整数 <code>-3</code>，输出表示有符号整数 <code>-1073741825</code>。</li>
 * </ul>
 *
 * <p><strong>示例 1：</strong></p>
 * <pre>
 * <strong>输入：</strong>n = 00000010100101000001111010011100
 * <strong>输出：</strong>964176192 (00111001011110000010100101000000)
 * <strong>解释：</strong>输入的二进制串 <strong>00000010100101000001111010011100 </strong>表示无符号整数<strong> 43261596</strong><strong>，
 * </strong> 因此返回 964176192，其二进制表示形式为 <strong>00111001011110000010100101000000</strong>。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <pre>
 * <strong>输入：</strong>n = 11111111111111111111111111111101
 * <strong>输出：</strong>3221225471 (10111111111111111111111111111111)
 * <strong>解释：</strong>输入的二进制串 <strong>11111111111111111111111111111101</strong> 表示无符号整数 4294967293，
 * &nbsp; 因此返回 3221225471 其二进制表示形式为 <strong>10111111111111111111111111111111 。</strong></pre>
 *
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li>输入是一个长度为 <code>32</code> 的二进制字符串</li>
 * </ul>
 *
 * <p><strong>进阶</strong>: 如果多次调用这个函数，你将如何优化你的算法？</p>
 *
 * <br><div><strong>Topics：</strong><div><li>位运算</li><li>分治</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 */
class ReverseBits {
    public static void main(String[] args) {
        Solution solution = new ReverseBits().new Solution();
        System.out.println(solution.reverseBits(43261596));
        System.out.println(solution.reverseBits(-3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // 正常思路
        public int reverseBits1(int n) {
            int m = 0;
            for (int i = 0; i < 32; i++) {
                m = m | (n & 1) << (31 - i);
                n = n >> 1;
            }
            return m;
        }

        // 答案真的太骚了
        public int reverseBits(int n) {
            int m1 = 0x55555555; // 01010101010101010101010101010101
            int m2 = 0x33333333; // 00110011001100110011001100110011
            int m4 = 0x0f0f0f0f; // 00001111000011110000111100001111
            int m8 = 0x00ff00ff; // 00000000111111110000000011111111
            n = (n >>> 1) & m1 | (n & m1) << 1;
            n = (n >>> 2) & m2 | (n & m2) << 2;
            n = (n >>> 4) & m4 | (n & m4) << 4;
            n = (n >>> 8) & m8 | (n & m8) << 8;
            return n >>> 16 | n << 16;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}