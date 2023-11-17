package _02leetcode.day08.num2736;

import java.util.*;

/**
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/17 22:28
 */
public class Demo1 {

    // 用Map
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {

        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }

        // 第一个是数据的索引，第二个是两个之和的数据
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(i, nums1[i] + nums2[i]);
        }

        // 将Map的entry集合转换为List
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // 使用Collections.sort()方法对List进行排序，传入一个Comparator
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                // 按照值进行降序排序
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // 创建一个新的有序Map
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // sortedMap是已经通过值降序之后的map
        // 值是和

        Set<Map.Entry<Integer, Integer>> entries = sortedMap.entrySet();

        for (int i = 0; i < queries.length; i++) {
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (nums1[entry.getKey()] >= queries[i][0] && nums2[entry.getKey()] >= queries[i][1]) {
                    res[i] = Math.max(res[i], nums1[entry.getKey()] + nums2[entry.getKey()]);
                    break;
                }
            }
        }

        return res;
    }

}
