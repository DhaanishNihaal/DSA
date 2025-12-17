class Solution {
    int findCeil(Node root, int x) {
        // code here
        int ceil=-1;
        while(root!=null){
            if(root.data>=x){
                ceil=root.data;
                root=root.left;
            }
            else{
                root=root.right;
            }
        }
        return ceil;
    }
}