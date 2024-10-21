package LeetcodeJava;

public class BinaryTreeMaximumPathSum {
    public int maxSum=Integer.MIN_VALUE;

    public int maxPathUtil(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftGain = Math.max(maxPathUtil(root.left), 0);
        int rightGain = Math.max(maxPathUtil(root.right), 0);
        int sum = root.val + leftGain + rightGain;
        this.maxSum = Math.max(this.maxSum, sum);
        return root.val + Math.max(leftGain, rightGain);
    }
    public int maxPathSum(TreeNode root) {
        maxPathUtil(root);
        return this.maxSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        System.out.println(binaryTreeMaximumPathSum.maxPathSum(root));
    }
}
