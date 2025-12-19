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
    TreeNode val1;
    TreeNode val2;
    TreeNode prev;
    private void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        if(prev!=null && (root.val<prev.val)){
            if(val1==null) {
                val1=prev;
            }
            val2=root;
        }
        prev=root;
        helper(root.right);
    }
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp=val2.val;
        val2.val=val1.val;
        val1.val=temp;
    }
}