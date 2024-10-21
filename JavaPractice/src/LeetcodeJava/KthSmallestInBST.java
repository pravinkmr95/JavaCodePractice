package LeetcodeJava;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestInBST {
    public int result;
    public int counter=0;
    public void kthSmallestUtil(TreeNode root, int k){
        if (root == null){
            return;
        }
        kthSmallest(root.left, k);
        counter++;
        if (k == counter){
            result = root.val;
        }
        kthSmallest(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestUtil(root, k);
        return result;
    }

    public int kthSmallestIterative(TreeNode root, int k){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        int counter = 0;
        int output = 0;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode top = stack.poll();
            counter++;
            if (counter == k){
                output = top.val;
                break;
            }
            curr = top.right;
        }
        return output;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        KthSmallestInBST kthSmallestInBST = new KthSmallestInBST();
        System.out.println(kthSmallestInBST.kthSmallest(root, 1));

        System.out.println(kthSmallestInBST.kthSmallestIterative(root, 1));
    }
}
