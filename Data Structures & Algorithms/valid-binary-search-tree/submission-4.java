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
    public boolean isValidBST(TreeNode root) {
        List<Integer> Inorder = new ArrayList<>();
        bfs(root, Inorder);
        for(int i=1;i<Inorder.size();i++){
            if(Inorder.get(i)<=Inorder.get(i-1)){
                return false;
            }
        }
        return true;
    }
    private void bfs(TreeNode node, List<Integer> Inorder){
        if(node == null){
            return;
        }
        bfs(node.left, Inorder);
        Inorder.add(node.val);
        bfs(node.right, Inorder);
    }
}
