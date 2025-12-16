/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentmap = new HashMap<>();
        HashSet<TreeNode> vis= new HashSet<>();
        Deque<TreeNode> que=new ArrayDeque<>();
        que.add(root);
        while(!que.isEmpty()){
            int n=que.size();
            for(int i=0;i<n;i++){
                TreeNode cur=que.poll();
                if(cur.left!=null){
                    que.add(cur.left);
                    parentmap.put(cur.left,cur);
                }
                if(cur.right!=null){
                    que.add(cur.right);
                    parentmap.put(cur.right,cur);
                }
            }
        }
        que.add(target);
        vis.add(target);
        int currLevel=0;
        while(currLevel++<k && !que.isEmpty()){
            int n=que.size();
            for(int i=0;i<n;i++){
                TreeNode cur=que.poll();
                if(cur.left!=null && !vis.contains(cur.left)){
                    que.add(cur.left);
                    vis.add(cur.left);
                } 
                if(cur.right!=null && !vis.contains(cur.right)){
                    que.add(cur.right);
                    vis.add(cur.right);
                }
                if(parentmap.containsKey(cur) && !vis.contains(parentmap.get(cur))){
                    que.add(parentmap.get(cur));
                    vis.add(parentmap.get(cur));
                } 
            }
        }
        ArrayList<Integer> out=new ArrayList<>();
        while(!que.isEmpty()){
            out.add(que.poll().val);
        }
        return out;
    }
}