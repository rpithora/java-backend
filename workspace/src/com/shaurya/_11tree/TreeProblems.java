package com.shaurya._11tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeProblems {
    private static TreeNode buildTree(Integer[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < arr.length; i++) {
            TreeNode parent = queue.poll();

            if (parent == null)
                continue;

            if (arr[i] != null) {
                parent.left = new TreeNode(arr[i]);
                queue.offer(parent.left);
            }
            if (arr[++i] != null) {
                parent.right = new TreeNode(arr[i]);
                queue.offer(parent.right);
            }

        }
        return root;
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeProblems problem = new TreeProblems();
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = buildTree(arr);
        System.out.println(root);

        problem.inOrder(root);
        System.out.println();
        problem.levelOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode parent = queue.poll();

                if (parent == null)
                    continue;

                if (parent.left != null)
                    queue.offer(parent.left);
                if (parent.right != null)
                    queue.offer(parent.right);

                System.out.print(parent.data + " ");
            }
            System.out.println();
        }
    }
}
