package com.shaurya._11tree;

import java.util.*;

public class TreeDemo {

    public TreeNode root;
    //AVL Tree is a Balanced Binary Tree (ABS(leftHeight - rightHeight) <=1)
    int fun_call = 0;

    public static void main(String[] args) {

        System.out.println("SHREYA");
        System.out.println("SHAURYA");

        TreeDemo tree = new TreeDemo();
        /*TreeNode n1 = tree.new TreeNode(8, tree.new TreeNode(9), null);
        //TreeNode n2 = tree.new TreeNode(4, n1, null);
                             1
                           /  \
                         2     3
                       /  \  /  \
                     4    5 6    7
        */
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        TreeNode root = new TreeNode(1, left, right);

        TreeNode l = tree.search(root, 4);
        System.out.println(":::::::::::: FOUND :::::::::::: " + l.value);
        System.out.println("In Order : ");
        tree.inOrder(root); //LeftRootRight
        System.out.println();
        System.out.println("Pre Order : ");
        tree.preOrder(root); //RootLeftRight
        System.out.println();
        System.out.println("Post Order : ");
        tree.postOrder(root); //LeftRightRoot
        System.out.println();
        System.out.println("Level Order : ");
        tree.levelOrder(root);
        System.out.println("Tree Height : " + tree.height(root));
        System.out.println("Binary Tree is AVL Tree ? " + (tree.isBalanced(root) == -1 ? "No" : "Yes"));
        System.out.println("Function call : " + tree.fun_call);
        int arr[] = {Integer.MIN_VALUE};
        TreeNode root1 = new TreeNode(2, new TreeNode(-1), null);
        System.out.println("Max Sum : " + tree.maxSumPath(root1, arr));
        System.out.println(arr[0]);
        System.out.println(tree.isSameTree(root, root));
        tree.zigzag(root);
        tree.zigzagDq(root);
        tree.zigzagWithoutReverseApi(root);
        tree.topView(root);
        tree.bottomView(root);
        tree.leftView(root);
        tree.leftViewRec(root);
        tree.rightView(root);
        tree.rightViewRec(root);
        tree.kDistanceTreeNode(root, root.left, 3);
        tree.burnTree(root, root.left.left);
        ArrayList<Integer> al = new ArrayList<>();
        tree.printPath(root, al, 7);
        System.out.println(al);
        TreeNode node = tree.lowestCommonAncestors(root, 5, 6);
        System.out.println("LCA ::: " + node == null ? "Not Found" : node.value);
        System.out.println("Total No. of Nodes : " + tree.countNodes(root));
    }

    private TreeNode search(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (root.value == value) {
            System.out.println("found");
            return root;
        } else {
            TreeNode found = search(root.left, value);
            if (found == null) {
                found = search(root.right, value);
            }
            return found;
        }
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> op = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                l.add(queue.poll().value);
            }
            op.add(l);
        }
        System.out.println(op);
    }

    public void zigzag(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> op = new ArrayList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                l.add(queue.poll().value);
            }

            if (flag) {
                op.add(l);
                flag = false;
            } else {
                Collections.reverse(l);
                op.add(l);
                flag = true;
            }
        }
        System.out.println(op);
    }

    public void zigzagDq(TreeNode root) {
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        List<List<Integer>> op = new ArrayList<>();
        dq.offer(root);
        boolean flag = false;
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> level = new ArrayList<>();
            if (flag) {
                for (int i = 0; i < size; i++) {
                    TreeNode temp = dq.pollFirst();
                    if (temp.left != null) {
                        dq.offerLast(temp.left);
                    }
                    if (temp.right != null) {
                        dq.offerLast(temp.right);
                    }
                    level.add(temp.value);
                }
                flag = false;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode temp = dq.pollLast();
                    if (temp.right != null) {
                        dq.offerFirst(temp.right);
                    }
                    if (temp.left != null) {
                        dq.offerFirst(temp.left);
                    }
                    level.add(temp.value);
                }
                flag = true;
            }
            op.add(level);
        }
        System.out.println();
        System.out.println(op);
    }

    public void zigzagWithoutReverseApi(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> op = new ArrayList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> l = new ArrayList<>();
            if (flag) {
                for (int i = 0; i < level; i++) {
                    TreeNode temp = queue.pollFirst();
                    if (temp.left != null) {
                        queue.offerLast(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offerLast(temp.right);
                    }
                    l.add(temp.value);
                }
                flag = false;
            } else {
                for (int i = 0; i < level; i++) {
                    TreeNode temp = queue.pollLast();
                    if (temp.right != null) {
                        queue.offerFirst(temp.right);
                    }
                    if (temp.left != null) {
                        queue.offerFirst(temp.left);
                    }
                    l.add(temp.value);
                }
                flag = true;
            }
            op.add(l);
        }
        System.out.println("without inbuilt api : " + op);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh, rh);
    }

    public int isBalanced(TreeNode root) {
        ++fun_call;
        if (root == null) {
            return 0;
        }

        int lh = isBalanced(root.left);
        if (lh == -1) return -1; // Without this check, THis method scan the whole tree total 19 function calls,
        int rh = isBalanced(root.right);
        if (rh == -1) return -1;// with this check in place total function calls 9

        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }

    public int diameter(TreeNode root, int diameter[]) {
        if (root == null) {
            return 0;
        }
        int lH = diameter(root.left, diameter);
        int rH = diameter(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lH + rH);

        return 1 + Math.max(lH, rH);
    }

    public int maxSumPath(TreeNode root, int max[]) {
        if (root == null) {
            return 0;
        }
        int lSum = Math.max(maxSumPath(root.left, max), 0);
        int rSum = Math.max(maxSumPath(root.right, max), 0);

        max[0] = Math.max(max[0], lSum + rSum + root.value);
        return Math.max(lSum, rSum) + root.value;
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        return root1.value == root2.value
                && isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }

    public List<Integer> topView(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> topView = new ArrayList<>();
        Map<Integer, Integer> tMap = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                Pair ele = q.poll();
                TreeNode temp = ele.getTreeNode();
                int id = ele.getId();
                if (temp.left != null) {
                    q.offer(new Pair(id - 1, temp.left));
                }
                if (temp.right != null) {
                    q.offer(new Pair(id + 1, temp.right));
                }
                if (!tMap.containsKey(id)) tMap.put(id, temp.value);
            }
        }
        for (Map.Entry<Integer, Integer> entry : tMap.entrySet()) {
            topView.add(entry.getValue());
        }
        System.out.println(topView);
        return topView;
    }

    public List<Integer> bottomView(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> bottomView = new ArrayList<>();
        Map<Integer, Integer> tMap = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                Pair ele = q.poll();
                TreeNode temp = ele.getTreeNode();
                int id = ele.getId();
                if (temp.left != null) {
                    q.offer(new Pair(id - 1, temp.left));
                }
                if (temp.right != null) {
                    q.offer(new Pair(id + 1, temp.right));
                }
                tMap.put(id, temp.value); // The last element will replace the old entries.
            }
        }
        for (Map.Entry<Integer, Integer> entry : tMap.entrySet()) {
            bottomView.add(entry.getValue());
        }
        System.out.println(bottomView);
        return bottomView;
    }

    public List<Integer> leftView(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> leftView = new ArrayList<>();
        while (!q.isEmpty()) {
            int level = q.size();
            int j = 0;
            for (int i = 0; i < level; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
                if (j == 0) leftView.add(temp.value);
                j = 1;
            }
        }
        System.out.println(leftView);
        return leftView;
    }

    public void leftViewRec(TreeNode root) {
        List<Integer> leftView = new ArrayList<>();
        leftView(root, leftView, 0);
        System.out.println("Left View : " + leftView);
    }

    public void leftView(TreeNode TreeNode, List<Integer> leftView, int level) {
        if (null == TreeNode) return;
        if (leftView.size() == level) leftView.add(TreeNode.value);
        leftView(TreeNode.left, leftView, level + 1);
        leftView(TreeNode.right, leftView, level + 1);
    }

    public void rightViewRec(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        rightView(root, rightView, 0);
        System.out.println("Right View : " + rightView);
    }

    public void rightView(TreeNode TreeNode, List<Integer> rightView, int level) {
        if (null == TreeNode) return;
        if (rightView.size() == level) rightView.add(TreeNode.value);
        rightView(TreeNode.right, rightView, level + 1);
        rightView(TreeNode.left, rightView, level + 1);
    }

    public List<Integer> rightView(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> rightView = new ArrayList<>();
        while (!q.isEmpty()) {
            int level = q.size();
            int j = 0;
            for (int i = 0; i < level; i++) {
                TreeNode temp = q.poll();
                if (temp.right != null) q.offer(temp.right);
                if (temp.left != null) q.offer(temp.left);
                if (j == 0) rightView.add(temp.value);
                j = 1;
            }
        }
        System.out.println(rightView);
        return rightView;
    }

    public List<Integer> kDistanceTreeNode(TreeNode root, TreeNode targetTreeNode, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        getParent(root, parentMap);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(targetTreeNode);
        visited.put(targetTreeNode, true);
        int curr_level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (curr_level == k) break;
            ++curr_level;
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (null != current.left && null == visited.get(current.left)) {
                    q.offer(current.left);
                    visited.put(current.left, true);
                }
                if (null != current.right && null == visited.get(current.right)) {
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                if (null != parentMap.get(current) && null == visited.get(parentMap.get(current))) {
                    q.offer(parentMap.get(current));
                    visited.put(parentMap.get(current), true);
                }
            }
        }
        while (!q.isEmpty()) {
            result.add(q.poll().value);
        }
        System.out.println("From TreeNode : " + targetTreeNode.value + " , " + k + " distance TreeNodes are " + result);
        return result;
    }

    private void getParent(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                TreeNode current = q.poll();
                if (null != current.left) {
                    parentMap.put(current.left, current);
                    q.offer(current.left);
                }
                if (null != current.right) {
                    parentMap.put(current.right, current);
                    q.offer(current.right);
                }
            }
        }
    }

    public int burnTree(TreeNode root, TreeNode targetTreeNode) {
        int max = 0;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        getParent(root, parentMap);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(targetTreeNode);
        visited.put(targetTreeNode, true);
        while (!q.isEmpty()) {
            int size = q.size();
            int f = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (null != current.left && null == visited.get(current.left)) {
                    f = 1;
                    q.offer(current.left);
                    visited.put(current.left, true);
                }
                if (null != current.right && null == visited.get(current.right)) {
                    f = 1;
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                if (null != parentMap.get(current) && null == visited.get(parentMap.get(current))) {
                    f = 1;
                    q.offer(parentMap.get(current));
                    visited.put(parentMap.get(current), true);
                }
            }
            if (f == 1) max++;
        }
        System.out.println(max);
        return max;
    }

    public boolean printPath(TreeNode root, ArrayList<Integer> ans, int value) {
        if (root == null) {
            return false;
        }
        ans.add(root.value);
        if (root.value == value) {
            return true;
        }
        if (printPath(root.left, ans, value) || printPath(root.right, ans, value)) {
            return true;
        }
        ans.remove(ans.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestors(TreeNode root, int p, int q) {
        if (root == null || root.value == p || root.value == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestors(root.left, p, q);
        TreeNode right = lowestCommonAncestors(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    private int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private int getRightHeight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    // Count Node in Complete Binary Tree
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lH = getLeftHeight(root);
        int rH = getRightHeight(root);
        if (lH == rH) {
            return (int) Math.pow(2, lH) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    public class Pair {
        private TreeNode TreeNode;
        private int id;

        public Pair(int id, TreeNode TreeNode) {
            this.id = id;
            this.TreeNode = TreeNode;
        }

        public int getId() {
            return id;
        }

        public TreeNode getTreeNode() {
            return TreeNode;
        }
    }
}
