package LeetcodeJava;


public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return root;
        }
        if (root == p || root == q){
            return root;
        }
        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);
        if (leftLca != null && rightLca != null){
            return root;
        }
        if (leftLca != null){
            return leftLca;
        } else {
            return rightLca;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        System.out.println(binaryTreeLevelOrderTraversal.levelOrder(root));
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode lca = lowestCommonAncestor.lowestCommonAncestor(root, root.left, root.right);
        System.out.println(lca.val);

        lca = lowestCommonAncestor.lowestCommonAncestor(root, root.left, root.left.right);
        System.out.println(lca.val);

    }
}
