package LeetcodeJava;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){}

    TreeNode(int num){
        val = num;
        left = null;
        right = null;
    }

    TreeNode(int num, TreeNode l, TreeNode r){
        val = num;
        left = l;
        right = r;
    }

    public String toString(){
        return "(" + this.val + ")";
    }
}
