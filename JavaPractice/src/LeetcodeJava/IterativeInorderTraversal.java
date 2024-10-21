package LeetcodeJava;

import java.util.ArrayDeque;
import java.util.Deque;

public class IterativeInorderTraversal {
    public void iterativeInorder(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode top = stack.poll();
            System.out.print(top.val + " ");
            curr = top.right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        IterativeInorderTraversal iterativeInorderTraversal = new IterativeInorderTraversal();
        iterativeInorderTraversal.iterativeInorder(root);
    }
}
