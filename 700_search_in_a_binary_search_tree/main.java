/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 //Minha solução
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        TreeNode result1 = null;
        TreeNode result2 = null;

        result1 = searchBST(root.left, val);
        if (result1 == null){
            result2 = searchBST(root.right, val);
        }

        if (result2 == null) return result1;
        else return result2;
    }
}