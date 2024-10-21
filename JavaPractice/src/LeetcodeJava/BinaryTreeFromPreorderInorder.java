package LeetcodeJava;

import java.util.*;

public class BinaryTreeFromPreorderInorder {
    public HashMap<Integer, Integer> inorderMap;
    public int preOrderIndex;

    public TreeNode buildTreeUtil(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd){
            return null;
        }
        int rootVal = preorder[preOrderIndex];
        TreeNode root = new TreeNode(rootVal);
        preOrderIndex++;
        root.left = buildTreeUtil(preorder, inStart, inorderMap.get(rootVal)-1);
        root.right = buildTreeUtil(preorder, inorderMap.get(rootVal) + 1, inEnd);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }
        inorderMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return buildTreeUtil(preorder, 0, inorder.length-1);
    }

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
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BinaryTreeFromPreorderInorder binaryTreeFromPreorderInorder = new BinaryTreeFromPreorderInorder();
        TreeNode root = binaryTreeFromPreorderInorder.buildTree(preorder, inorder);
        System.out.println(binaryTreeFromPreorderInorder.levelOrder(root));
    }
}
