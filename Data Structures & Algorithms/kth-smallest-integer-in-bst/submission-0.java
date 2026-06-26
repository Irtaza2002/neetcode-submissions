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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        bfs(root, inorder);
        return inorder.get(k-1);
    }
    private void bfs(TreeNode node, List<Integer> inorder){
        if(node == null){
            return;
        }
        bfs(node.left, inorder);
        inorder.add(node.val);
        bfs(node.right, inorder);
    }
}
