package leetcode.editor.cn;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>29</p>
 * <p><strong>标题：</strong>两数相除</p>
 * <p><strong>时间：</strong>2022-07-15 13:20:36</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>给定两个整数，被除数&nbsp;<code>dividend</code>&nbsp;和除数&nbsp;<code>divisor</code>。将两数相除，要求不使用乘法、除法和 mod 运算符。</p>
 * <p>返回被除数&nbsp;<code>dividend</code>&nbsp;除以除数&nbsp;<code>divisor</code>&nbsp;得到的商。</p>
 * <p>整数除法的结果应当截去（<code>truncate</code>）其小数部分，例如：<code>truncate(8.345) = 8</code> 以及 <code>truncate(-2.7335) = -2</code></p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 * <pre>
 * <strong>输入:</strong> dividend = 10, divisor = 3
 * <strong>输出:</strong> 3
 * <strong>解释: </strong>10/3 = truncate(3.33333..) = truncate(3) = 3
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 * <pre>
 * <strong>输入:</strong> dividend = 7, divisor = -3
 * <strong>输出:</strong> -2
 * <strong>解释:</strong> 7/-3 = truncate(-2.33333..) = -2
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li>被除数和除数均为 32 位有符号整数。</li>
 * <li>除数不为&nbsp;0。</li>
 * <li>假设我们的环境只能存储 32 位有符号整数，其数值范围是 [&minus;2<sup>31</sup>,&nbsp; 2<sup>31&nbsp;</sup>&minus; 1]。本题中，如果除法结果溢出，则返回 2<sup>31&nbsp;</sup>&minus; 1。</li>
 * </ul>
 *
 * <br><div><strong>Topics：</strong><div><li>位运算</li><li>数学</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 * <p>愿天堂没有溢出</p>
 */
class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        System.out.println(solution.divide(10, 3) == 3);
        System.out.println(solution.divide(7, -3) == -2);
        System.out.println(solution.divide(Integer.MIN_VALUE, -1) == Integer.MAX_VALUE);
        System.out.println(solution.divide(Integer.MIN_VALUE, 1) == Integer.MIN_VALUE);
        System.out.println(solution.divide(Integer.MAX_VALUE, 2) == 1073741823);
        System.out.println(solution.divide(Integer.MIN_VALUE, 2) == -1073741824);
        System.out.println(solution.divide(Integer.MAX_VALUE, 3) == 715827882);
        System.out.println(solution.divide(1100540749, -1090366779) == -1);
        System.out.println(solution.divide(1530093783, 1493139203) == 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {

            // 特殊情况
            if (dividend == 0) return 0;
            if (divisor == 1) return dividend;
            if (dividend == divisor) return 1;
            if (divisor == Integer.MIN_VALUE) return 0;

            // 防止溢出
            if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

            // 都变为负数计算，也是防止溢出
            boolean b = (dividend ^ divisor) < 0;
            dividend = dividend < 0 ? dividend : ~dividend + 1;
            divisor = divisor < 0 ? divisor : ~divisor + 1;
            if (b) return ~divide(dividend, divisor) + 1;

            if (dividend > divisor) return 0;

            // 寻找divisor不溢出且最大的值
            int flag = 0;
            while (((divisor << (flag + 1)) < divisor) && (dividend < (divisor << flag + 1))) {
                flag++;
            }

            return (1 << flag) + divide((dividend - (divisor << flag)), divisor);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}