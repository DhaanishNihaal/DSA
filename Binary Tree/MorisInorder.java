class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur=root;
        ArrayList<Integer> arr=new ArrayList<>();
        while(cur!=null){
            if(cur.left==null){
                arr.add(cur.val);
                cur=cur.right;
            }
            else{
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                }
                else{
                    arr.add(cur.val);
                    prev.right=null;//not compulsory just to restore the tree
                    cur=cur.right;
                }
            }
        }
        return arr;
    }
}