package editor.cn;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Question46FullPermutation {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        // 标记是否重复使用
        boolean[] used = new boolean[nums.length];

        backTrack(nums, track, used);
        return res;
    }

    private void backTrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 递归结束条件
        if (track.size() == nums.length) {
            // 把记录路径添加到res中
            res.add(new LinkedList<>(track));
            return;
        }

        // 进行递归前校验
        for (int i = 0; i < nums.length; i++) {
            // 排除nums中已经使用过的元素
            if (used[i]) continue;
            // 进行路径选择
            track.add(nums[i]);
            // 标记已经被选择
            used[i] = true;
            // 递归进入下层决策树
            backTrack(nums, track, used);
            // 退出决策树，进行撤销选择
            track.removeLast();
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
