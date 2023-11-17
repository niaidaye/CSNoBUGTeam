package _02leetcode.day08.num2736;

import java.util.Arrays;

/**
 * 给你两个长度为 n 、下标从 0 开始的整数数组 nums1 和 nums2 ，另给你一个下标从 1 开始的二维数组 queries ，其中 queries[i] = [xi, yi] 。
 * 对于第 i 个查询，在所有满足 nums1[j] >= xi 且 nums2[j] >= yi 的下标 j (0 <= j < n) 中，找出 nums1[j] + nums2[j] 的 最大值 ，如果不存在满足条件的 j 则返回 -1 。
 * 返回数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 *
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/17 21:12
 */
public class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        // 这个数组用来装返回的数据
        int[] res = new int[queries.length];

        // 设置一个装nums1和nums2的数组
        int[][] combined = new int[nums1.length][2];
        for (int i = 0; i < combined.length; i++) {
            // 每一行都装[nums1[i],nums2[i]];
            combined[i] = new int[]{nums1[i], nums2[i]};
        }
        // 按照nums1[i]进行从大到小排序
        Arrays.sort(combined, (o1, o2) -> o2[0] - o1[0]);

        // queries按照第一列进行从大到小排序
        Arrays.sort(queries, (o1, o2) -> o2[0] - o1[0]);

        int i = 0, j = 0, n = nums1.length;
        for (int k = 0; k < queries.length; k++) {
            int xi = queries[k][0];
            int yi = queries[k][1];
            res[k] = -1;

            // 因为现在combined数组是按照第一列从大到小排序的，所以检查一下小于他的那一行中最大的。
            while (i < n && combined[i][0] >= xi) {
                i++;
            }
            j = i;
            while (j < n) {
                if (combined[j][1] >= yi) {
                    i++;
                    j++;
                    continue;
                }
                res[k] = Math.max(res[k], combined[j][0] + combined[j][1]);
            }
        }

        return res;
    }
}
