package _02leetcode.day06.num116;

/**
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/14 22:08
 */
public class Solution {
    public Node connect(Node root) {
        // 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。
        if (root == null) return null;
        int level = 1, sum = 1;
        while (root.next != null) {
            if (level == sum) {
                Node levelFlag = new Node();
            }
        }


        return null;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
