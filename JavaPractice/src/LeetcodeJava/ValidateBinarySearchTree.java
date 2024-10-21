package LeetcodeJava;

import java.util.LinkedHashMap;

public class ValidateBinarySearchTree {
    public boolean isValidBSTUtil(TreeNode root, Integer minRange, Integer maxRange){
        if (root == null){
            return true;
        }
        if ((minRange != null && root.val <= minRange) || (maxRange != null && root.val >= maxRange)){
            return false;
        }
        return  (isValidBSTUtil(root.left, minRange, root.val) && isValidBSTUtil(root.right, root.val, maxRange));
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, null, null);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left  =  new TreeNode(1);
        root.right = new TreeNode(3);
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST(root));
 //       System.out.println(Integer.MIN_VALUE + "   " + Integer.MAX_VALUE);
 //       LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
//        linkedHashMap.put(1, 1);
//        linkedHashMap.put(2,2);
//        System.out.println(linkedHashMap);
////        linkedHashMap.put(1,3);
////        System.out.println(linkedHashMap);
    }
}
