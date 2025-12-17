/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s=new StringBuilder();
        Deque<TreeNode> que=new LinkedList<>();
        if(root==null) return "";
        que.add(root);
        while(!que.isEmpty()){
            TreeNode cur=que.removeFirst();
            if(cur==null) s.append("#,");
            else{
                s.append(cur.val).append(",");
                que.add(cur.left);
                que.add(cur.right);
            }
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] str=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        int i=1;
        Deque<TreeNode> que= new ArrayDeque<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode cur=que.removeFirst();
            if(!str[i].equals("#")){
                TreeNode leftNode=new TreeNode(Integer.parseInt(str[i]));
                cur.left=leftNode;
                que.add(leftNode);
            }
                i++;
            if(!str[i].equals("#")){
                TreeNode rightNode=new TreeNode(Integer.parseInt(str[i]));
                cur.right=rightNode;
                que.add(rightNode);
            }
                i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));