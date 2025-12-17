class Solution {
    public static int floor(Node root, int x) {
        // code here
        int ceil=-1;
        while(root!=null){
            if(root.data<=x){
                ceil=root.data;
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
        return ceil;
        
    }
}