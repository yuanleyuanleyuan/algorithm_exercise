package leetcode.editor.cn;

/**
 * <p><strong>来源：</strong>LeetCode</p>
 * <p><strong>编号：</strong>33</p>
 * <p><strong>标题：</strong>搜索旋转排序数组</p>
 * <p><strong>时间：</strong>2022-07-18 15:20:27</p>
 *
 * <p><strong>描述：</strong></p>
 * <p>整数数组 <code>nums</code> 按升序排列，数组中的值 <strong>互不相同</strong> 。</p>
 * <p>在传递给函数之前，<code>nums</code> 在预先未知的某个下标 <code>k</code>（<code>0 &lt;= k &lt; nums.length</code>）上进行了 <strong>旋转</strong>，使数组变为 <code>[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]</code>（下标 <strong>从 0 开始</strong> 计数）。例如， <code>[0,1,2,4,5,6,7]</code> 在下标 <code>3</code> 处经旋转后可能变为&nbsp;<code>[4,5,6,7,0,1,2]</code> 。</p>
 * <p>给你 <strong>旋转后</strong> 的数组 <code>nums</code> 和一个整数 <code>target</code> ，如果 <code>nums</code> 中存在这个目标值 <code>target</code> ，则返回它的下标，否则返回&nbsp;<code>-1</code>&nbsp;。</p>
 * <p>你必须设计一个时间复杂度为 <code>O(log n)</code> 的算法解决此问题。</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <pre>
 * <strong>输入：</strong>nums = [<code>4,5,6,7,0,1,2]</code>, target = 0
 * <strong>输出：</strong>4
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <pre>
 * <strong>输入：</strong>nums = [<code>4,5,6,7,0,1,2]</code>, target = 3
 * <strong>输出：</strong>-1</pre>
 *
 * <p><strong>示例 3：</strong></p>
 * <pre>
 * <strong>输入：</strong>nums = [1], target = 0
 * <strong>输出：</strong>-1
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 5000</code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * <li><code>nums</code> 中的每个值都 <strong>独一无二</strong></li>
 * <li>题目数据保证 <code>nums</code> 在预先未知的某个下标上进行了旋转</li>
 * <li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <br><div><strong>Topics：</strong><div><li>数组</li><li>二分查找</li></div></div>
 *
 * <p><strong>笔记：</strong></p>
 */
class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0) == 4);
        System.out.println(solution.search(new int[]{13,14,1,2,3,4,5,6,7,8,9,10}, 5) == 6);
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3) == -1);
        System.out.println(solution.search(new int[]{1}, 0) == -1);
        System.out.println(solution.search(new int[]{1}, 1) == 0);
        System.out.println(solution.search(new int[]{1, 3}, 2) == -1);
        System.out.println(solution.search(new int[]{5, 1, 2, 3, 4}, 1) == 1);
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8) == 4);
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5) == 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 比较好理解的写法，但是有点臃肿
        public int search1(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int mid;

            while (left < right) {
                mid = (left + right) / 2;
                if (nums[left] == target) return left;
                if (nums[right] == target) return right;
                if (nums[mid] == target) return mid;
                if (target < nums[left] && target > nums[right]) return -1;

                // 符合该条件即为已经确认区间为递增区间，直接二分查找即可
                if (nums[mid] > nums[left] && target > nums[left] && target < nums[mid]
                        || nums[mid] < nums[right] && target > nums[mid] && target < nums[right]) {
                    left = nums[mid] > nums[left] ? left : mid;
                    right = nums[mid] < nums[right] ? right : mid;
                    while (left < right) {
                        mid = (left + right) / 2;
                        if (nums[left] == target) return left;
                        if (nums[right] == target) return right;
                        if (nums[mid] == target) return mid;
                        if (nums[mid] > target) {
                            left++;
                            right = mid - 1;
                        } else {
                            right--;
                            left = mid + 1;
                        }
                    }
                } else {
                    left = nums[mid] > nums[left] ? mid + 1 : left + 1;
                    right = nums[mid] < nums[right] ? mid - 1 : right - 1;
                }
            }

            if (left == right) return nums[left] == target ? left : -1;

            return -1;
        }


        // 优化后
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int mid;

            while (left <= right) {
                mid = (left + right) / 2;
                if (nums[mid] == target) return mid;
                if (nums[left] <= nums[mid]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}