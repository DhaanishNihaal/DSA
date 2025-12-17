class Solution {
    int result;
    int count=0;
    private void helper(TreeNode root,int k){
        if(root==null) return;
        if(root.left!=null) helper(root.left,k);
        count++;
        if(count==k){
            result=root.val;
            return;
        }
        if(root.right!=null) helper(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return result;
    }
}