class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        preorder(root,out);
        return out;
    }
    private void inorder(TreeNode node,List<Integer> out){
            if(node == null){
                return;
            }
            preorder(node.left,out);
            out.add(node.val);
            preorder(node.right,out);
        }
}