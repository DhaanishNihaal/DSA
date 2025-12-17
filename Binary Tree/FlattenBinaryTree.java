class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode node=cur.left;
                while(node.right!=null){
                    node=node.right;
                }
                node.right=cur.right;
                cur.right=cur.left;
                cur.left=null;
            }
            cur=cur.right;
        }
    }
}