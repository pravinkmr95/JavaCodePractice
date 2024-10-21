package LeetcodeJava;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SameTree sameTree = new SameTree();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println(sameTree.isSameTree(root1, root2));

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(2);
        System.out.println(sameTree.isSameTree(root3, root4));
    }
}
