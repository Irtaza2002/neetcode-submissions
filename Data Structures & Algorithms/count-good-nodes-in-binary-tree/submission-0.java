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
//     public int goodNodes(TreeNode root) {
//         int[2] res = {0,0};
//         if(root == null){
//             return res.get(0);
//         }
//         res[1] = root.val;
//         dfs(root.left, res);
//         dfs(root.right, res);
//         return res.get(0);
//     }
//     private void dfs(TreeNode node, int[] res){
//         if(node == null){
//             return;
//         }
//         if(node.val>res[1]){
//             res[0]++;
//             res[1] = node.val;
//         }
//         dfs(node.left, res);
//         dfs(node.right, res);
//     }
// }
public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxVal) {
        if (node == null) {
            return 0;
        }

        int res = (node.val >= maxVal) ? 1 : 0;
        maxVal = Math.max(maxVal, node.val);
        res += dfs(node.left, maxVal);
        res += dfs(node.right, maxVal);
        return res;
    }
}