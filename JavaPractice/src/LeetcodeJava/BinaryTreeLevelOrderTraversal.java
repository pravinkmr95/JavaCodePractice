package LeetcodeJava;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null){
            return output;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> row = new ArrayList<>();
            for (int i=0; i<queueSize; i++){
                TreeNode top = queue.poll();
                row.add(top.val);
                if (top.left != null){
                    queue.offer(top.left);
                }
                if (top.right != null){
                    queue.offer(top.right);
                }
            }
            output.add(row);
        }
        return output;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        System.out.println(binaryTreeLevelOrderTraversal.levelOrder(root));
    }
}
