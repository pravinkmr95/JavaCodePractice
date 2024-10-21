package LeetcodeJava;

public class SubtreeOfAnotherTree {
    public boolean isSameTree(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.val == root2.val && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right)){
            return true;
        }
        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null){
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val == subRoot.val && isSameTree(root, subRoot)){
            return true;
        }

        if (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(0);
        root1.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        System.out.println(subtreeOfAnotherTree.isSubtree(root1, root2));
    }
}
