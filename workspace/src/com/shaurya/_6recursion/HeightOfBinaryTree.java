package com.shaurya._6recursion;

import com.shaurya._11tree.TreeDemo;
import com.shaurya._11tree.TreeNode;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        TreeDemo tree = new TreeDemo();
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        TreeNode root = new TreeNode(1, left, right);

        int height = solution(root);
        System.out.println(height);
    }

    private static int solution(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftH = solution(root.left);
        int rightH = solution(root.right);

        return 1 + Math.max(leftH,rightH);
    }
}
