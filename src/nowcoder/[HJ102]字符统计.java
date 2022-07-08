package nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p><strong>来源：</strong>牛客</p>
 * <p><strong>编号：</strong>HJ102</p>
 * <p><strong>标题：</strong>字符统计</p>
 * <p><strong>时间：</strong>2022-07-08 14:49:15</p>
 *
 * <p><strong>描述：</strong></p>
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
 *
 * <p><strong>数据范围：</strong></p>
 * 字符串长度满足<code> 1 <= str.length <= 1000 </code>
 *
 * <p><strong>输入描述：</strong></p>
 * 一个只包含小写英文字母和数字的字符串。
 *
 * <p><strong>输出描述：</strong></p>
 * 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
 *
 * <p><strong>示例 1：</strong></p>
 * <pre>
 * <strong>输入：</strong>aaddccdc
 * <strong>输出：</strong>cda
 * <strong>解释：</strong>样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a.
 * </pre>
 *
 * <div><strong>Topics：</strong><div><li>字符串</li><li>排序</li><li>哈希</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 */
class CharacterStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        // 0-9，对应ASCII码值48-57；a-z，对应ASCII码值97-122
        char[] arr1 = str.toCharArray();
        // 数字10个，小写字母26个，一共36个
        int[] arr2 = new int[36];

        // 题里要求按照ASCII码由小到大排序，所以需要定义一个常数（大于122且小于1048均可）用来保证升序排列
        int flag = 150;

        // 遍历字符串，对数组2进行填充
        for (char c : arr1) {
            if (c < 58) {
                arr2[c - 48] += arr2[c - 48] == 0 ? flag - c : 1000;
            } else {
                arr2[c - 87] += arr2[c - 87] == 0 ? flag - c : 1000;
            }
        }

        // 数组2排序
        Arrays.sort(arr2);

        // 按顺序输出
        StringBuilder s = new StringBuilder();
        for (int i = arr2.length - 1; i >= 0; i--) {
            if (arr2[i] == 0) break;
            s.append((char) (flag - arr2[i] % 1000));
        }

        System.out.println(s);

    }


}
