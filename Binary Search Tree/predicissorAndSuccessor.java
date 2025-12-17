class Solution {
    Node findCeil(Node root, int x) {
        // code here
        Node ceil= null;
        while(root!=null){
            if(root.data>x){
                ceil=root;
                root=root.left;
            }
            else{
                root=root.right;
            }
        }
        return ceil;
    }
    public static Node floor(Node root, int x) {
        // code here
        Node ceil=null;
        while(root!=null){
            if(root.data<x){
                ceil=root;
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
        return ceil;
    }
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node> arr=new ArrayList<>();
        arr.add(floor(root,key));
        arr.add(findCeil(root,key));
        return arr;
    }
}