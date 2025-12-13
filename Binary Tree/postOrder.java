class Solution {
    private void postorder(TreeNode root,List<Integer> lis){
        if(root!=null){
            postorder(root.left,lis);
            postorder(root.right,lis);
            lis.add(root.val);
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> out=new ArrayList<>();
        postorder(root,out);
        return out;
    }
}