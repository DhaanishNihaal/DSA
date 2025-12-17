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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        while(root!=null){
            if(root.left==null) {
                out.add(root.val);
                root=root.right;
            }
            else{
                TreeNode cur=root.left;
                while(cur.right!=null && cur.right!=root){
                    cur=cur.right;
                }
                if(cur.right==null){
                    out.add(root.val);
                    cur.right=root;
                    root=root.left;
                }
                else{
                    // cur.right=null;
                    root=root.right;
                }
            }
        }
        return out;
    }
   
}