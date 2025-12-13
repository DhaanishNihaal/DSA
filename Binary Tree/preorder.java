class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        preorder(root,out);
        return out;
    }
    private void preorder(TreeNode node,List<Integer> out){
            if(node == null){
                return;
            }
            out.add(node.val);
            preorder(node.left,out);
            preorder(node.right,out);
        }
}