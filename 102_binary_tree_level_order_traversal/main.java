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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> view = new ArrayList<>();
        if (root == null) return view;
        q.add(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> subView = new ArrayList<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode node = q.remove();
                subView.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                boolean isLevelEnd = i == levelSize - 1;
                if (isLevelEnd) view.add(subView);
            }
        }
        return view;
    }
}