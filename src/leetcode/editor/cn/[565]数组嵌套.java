package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>565</p>
 * <p><strong>标题：</strong>数组嵌套</p>
 * <p><strong>时间：</strong>2022-07-17 14:36:45</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>索引从<code>0</code>开始长度为<code>N</code>的数组<code>A</code>，包含<code>0</code>到<code>N - 1</code>的所有整数。找到最大的集合<code>S</code>并返回其大小，其中 <code>S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }</code>且遵守以下的规则。</p>
 * <p>假设选择索引为<code>i</code>的元素<code>A[i]</code>为<code>S</code>的第一个元素，<code>S</code>的下一个元素应该是<code>A[A[i]]</code>，之后是<code>A[A[A[i]]]...</code> 以此类推，不断添加直到<code>S</code>出现重复的元素。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 * <pre>
 * <strong>输入:</strong> A = [5,4,0,3,1,6,2]
 * <strong>输出:</strong> 4
 * <strong>解释:</strong>
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 * <ol>
 * <li><code>N</code>是<code>[1, 20,000]</code>之间的整数。</li>
 * <li><code>A</code>中不含有重复的元素。</li>
 * <li><code>A</code>中的元素大小在<code>[0, N-1]</code>之间。</li>
 * </ol>
 *
 * <br><div><strong>Topics：</strong><div><li>深度优先搜索</li><li>数组</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 * <p>没注意到元素大小在<code>[0, N-1]</code>之间这个条件，直接暴力超时了，实际上有了这个条件，把数组看成有向图的话，就可以判断一定有环，且最大的环就是答案</p>
 */
class ArrayNesting {
    public static void main(String[] args) {
        Solution solution = new ArrayNesting().new Solution();
        System.out.println(solution.arrayNesting(new int[]{5,4,0,3,1,6,2}) == 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 超时了
        public int arrayNesting1(int[] nums) {
            int max = 0;
            int length = nums.length;
            int[] arr = new int[length];
            Arrays.fill(arr,Integer.MIN_VALUE);

            for (int i = 0; i < length; i++) {
                int j = i;
                int count = 0;
                HashMap<Integer, Integer> map = new HashMap<>();
                while (j < length && !map.containsKey(j)){
                    count++;
                    map.put(j,nums[j]);
                    j = nums[j];
                    if(arr[j] >= 0) arr[i] = count + arr[j];
                }
                arr[i] = count;
                max = Math.max(max,arr[i]);
            }
            return max;
        }

        // 看了答案大彻大悟
        public int arrayNesting(int[] nums) {
            int max = 0;
            int length = nums.length;

            for (int i = 0; i < length; i++) {
                int count = 0;
                while (nums[i] < length){
                    int num = nums[i];
                    nums[i] = length;
                    i = num;
                    count++;
                }
                max = Math.max(max,count);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}