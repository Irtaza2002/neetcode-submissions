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

class Solution {
    public int goodNodes(TreeNode root) {
        int[] res = {0};
        if(root == null){
            return res[0];
        }
        res[0]++;
        int largest = root.val;
        dfs(root.left, largest, res);
        dfs(root.right, largest, res);
        return res[0];
    }
    private void dfs(TreeNode node, int largest, int[] res){
        if(node == null){
            return;
        }
        if(node.val>=largest){
            res[0]++;
            largest = node.val;
        }
        dfs(node.left, largest, res);
        dfs(node.right, largest, res);
    }
}
