package LeetcodeJava;

import java.util.*;

public class BinaryTreeFromInorderPostOrder {
    public HashMap<Integer, Integer> inorderMap;
    public int postOrderIndex;

    public TreeNode buildTreeUtil(int[] postorder, int start, int end){
        if (start > end){
            return null;
        }
        int rootVal = postorder[postOrderIndex];
        postOrderIndex--;
        TreeNode root = new TreeNode(rootVal);
        root.right = buildTreeUtil(postorder, inorderMap.get(rootVal)+1, end);
        root.left = buildTreeUtil(postorder, start, inorderMap.get(rootVal)-1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        postOrderIndex = postorder.length-1;
        return buildTreeUtil(postorder, 0, postorder.length-1);
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
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        BinaryTreeFromInorderPostOrder binaryTreeFromInorderPostOrder = new BinaryTreeFromInorderPostOrder();
        TreeNode root = binaryTreeFromInorderPostOrder.buildTree(inorder, postorder);
        System.out.println(binaryTreeFromInorderPostOrder.levelOrder(root));
    }
}
