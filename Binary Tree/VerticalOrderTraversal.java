    class Solution {
        class Pair{
            int row;
            int val;
            Pair(int row,int val){
                this.row=row;
                this.val=val;
            }
        }

        int minc=0;
        int maxc=0;
        public void preorder(TreeNode root,int col,int row,HashMap<Integer,List<Pair>> mp){
            if(root!=null){
                mp.computeIfAbsent(col,k->new ArrayList<>()).add(new Pair(row,root.val));
                minc=Math.min(col,minc);
                maxc=Math.max(col,maxc);
                preorder(root.left,col-1,row+1,mp);
                preorder(root.right,col+1,row+1,mp);
            }
        }
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> out=new ArrayList<>();
            if(root==null){
                return out;
            }
            HashMap<Integer,List<Pair>> mp=new HashMap<>();
            preorder(root,0,0,mp);
            for(int i=minc;i<=maxc;i++){
                List<Pair> lis=mp.get(i);
                lis.sort((a,b)->{
                    if(a.row!=b.row){
                        return Integer.compare(a.row,b.row);
                    }
                    return Integer.compare(a.val,b.val);
                });
                List<Integer> cur=new ArrayList<>();
                for(Pair p:lis){
                    cur.add(p.val);
                }
                out.add(cur);
            }
            return out;
        }
    }