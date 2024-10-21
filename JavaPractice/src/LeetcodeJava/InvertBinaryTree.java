package LeetcodeJava;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public void levelOrder(TreeNode root){
        if (root == null){
            return;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i=0; i<n; i++){
                TreeNode top = queue.poll();
                System.out.print(top.val + " ");
                if (top.left != null){
                    queue.offer(top.left);
                }
                if (top.right != null){
                    queue.offer(top.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        invertBinaryTree.levelOrder(root);
        root = invertBinaryTree.invertTree(root);
        invertBinaryTree.levelOrder(root);
    }
}
