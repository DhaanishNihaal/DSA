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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new LinkedList<>();
        if(root == null){
            return out;
        }
        List<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean flag =true;
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> cur = new LinkedList<>();
            for(int i =0;i<size;i++){
                TreeNode k = que.poll();
                if(flag) cur.addLast(k.val);
                else cur.addFirst(k.val);
                if(k.left !=null) que.add(k.left);
                if(k.right !=null) que.add(k.right);
            }
            flag=!flag;
            out.add(cur);
        }


        return out;
    }
}