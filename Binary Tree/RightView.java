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
 public class RightView{
    TreeNode node;
    int level;

    RightView(TreeNode node,int level){
        this.node = node;
        this.level = level;
    }

 }
class Solution {
    private void dfs(TreeNode node,int level,List<Integer> out){
            if(node == null) return;
            if(level == out.size()) out.add(node.val);
            if(node.right!=null) dfs(node.right,level+1,out);
            if(node.left!=null) dfs(node.left,level+1,out);
        }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        // if(root==null){
        //     return out;
        // }
        // Deque<Pair> st = new ArrayDeque<>();
        // int max_level = 0;
        // st.addFirst(new Pair(root,1));
        // while(!st.isEmpty()){
        //     Pair p = st.removeLast();
        //     TreeNode node = p.node;
        //     int level = p.level;
        //     if(level>max_level){
        //         out.add(node.val);
        //         max_level = level;
        //     }
        //     if(node.left!=null) st.addLast(new Pair(node.left,level+1));       
        //     if(node.right!=null) st.addLast(new Pair(node.right,level+1));
        // }
        if(root==null) return out;
        // out.add(root.val);
        dfs(root,0,out);
        return out;
    }
}