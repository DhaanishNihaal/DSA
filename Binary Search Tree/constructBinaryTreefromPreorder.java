class Solution {
    int idx=0;
    private TreeNode helper(int[] preorder,long x,long y){
        if(idx>=preorder.length || preorder[idx]<x || preorder[idx]>y) return null;
        TreeNode root=new TreeNode(preorder[idx]);
        idx++;
        root.left=helper(preorder,x,root.val);
        root.right=helper(preorder,root.val,y);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}