class Solution {
    boolean isLeaf(Node node){
        if(node.right==null && node.left==null){
            return true;
        }
        else{
            return false;
        }
    }
    void addleaf(Node node,List<Integer> out){
        if(isLeaf(node))
        {
            out.add(node.data);
            return;
        }
        if(node.left!=null) addleaf(node.left,out);
        if(node.right!=null) addleaf(node.right,out);
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> out = new ArrayList<>();
        if(root==null){
            return out;
        }
        if(!isLeaf(root)) out.add(root.data);
        Node left = root.left;
        while(left!=null){
            if(!isLeaf(left)) out.add(left.data);
            if(left.left!=null){
                left = left.left;
            }
            else{
                left = left.right;
            }
        }
        addleaf(root,out);
        ArrayList<Integer> tmp = new ArrayList<>();
        Node right = root.right;
        while(right!=null){
            if(!isLeaf(right)) tmp.add(right.data);
            if(right.right!=null){
                right = right.right;
            }
            else{
                right = right.left;
            }
        }
        for(int i = tmp.size()-1;i>=0;i--){
            out.add(tmp.get(i));
        }
        return out;
        
    }
}