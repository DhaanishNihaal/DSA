/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    int minc=0;
    int maxc=0;
   void preorder(Node root,int row,int col,HashMap<Integer,int[]> mp){
       if(root!=null){
           if(!mp.containsKey(col) || row>=mp.get(col)[1]){
               mp.put(col,new int[]{root.data,row});
           }
           minc=Math.min(minc,col);
           maxc=Math.max(maxc,col);
           preorder(root.left,row+1,col-1,mp);
           preorder(root.right,row+1,col+1,mp);
       }
   }
    public ArrayList<Integer> topView(Node root) {
        // code here
        HashMap<Integer,int[]> mp= new HashMap<>();
        preorder(root,0,0,mp);
        ArrayList<Integer> left = new ArrayList<>();
        for(int i=minc;i<=maxc;i++){
            left.add(mp.get(i)[0]);
        }
        return left;
    }
    
}

//bfs approach;
/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    public class Pair{
        Node node;
        int left;
        int right;
        Pair(Node node,int left,int right){
            this.node=node;
            this.left=left;
            this.right=right;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        Deque<Pair> que = new ArrayDeque<>();
        int leftmost=0;
        int rightmost=0;
        que.addLast(new Pair(root,1,0));
        while(!que.isEmpty()){
            Pair cur = que.removeFirst();
            Node node = cur.node;
            int cleft = cur.left;
            int cright = cur.right;
            if(cleft<=leftmost){
                left.add(node.data);
                leftmost = cleft;
            }
            if(cright<=rightmost){
                right.add(node.data);
                rightmost = cright;
            }
            if(node.left!=null) que.addLast(new Pair(node.left,cleft+1,cright-1));
            if(node.right!=null) que.addLast(new Pair(node.right,cleft-1,cright+1));
        }
        Collections.reverse(left);
        left.addAll(right);
        return left;
    }
    
}