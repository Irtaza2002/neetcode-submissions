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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addFirst(root);
        boolean flag = true;
        while(!dq.isEmpty()){
            int size = dq.size();
            if(flag){
                for(int i=0;i<size;i++){
                    TreeNode node = dq.pollFirst();
                    if(i==size-1){
                        res.add(node.val);
                    }
                    if(node.left != null){
                        dq.addLast(node.left);
                    }
                    if(node.right != null){
                        dq.addLast(node.right);
                    }
                }
                flag = false;
            }
            else{
                for(int i=0;i<size;i++){
                    TreeNode node = dq.pollFirst();
                    if(i==size-1){
                        res.add(node.val);
                    }
                    if(node.left != null){
                        dq.addLast(node.left);
                    }
                    if(node.right != null){
                        dq.addLast(node.right);
                    }
                }
                flag = true;
            }
        }
        return res;
    }
}
