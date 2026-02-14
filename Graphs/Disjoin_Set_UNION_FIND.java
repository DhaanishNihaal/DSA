// User function Template for Java

class Solution {
    
    // Function to merge two nodes a and b.
    public int find_par(int par[],int v){
        if(par[v]==v) return v;
        int node=find_par(par,par[v]);
        par[v]=node;
        return node;
    }
    public void union_(int a, int b, int par[], int rank[]) {
        // add your code here
        int upa=find_par(par,a);
        int upb=find_par(par,b);
        if(rank[upa]>rank[upb]){
            par[upb]=upa;
        }
        else if(rank[upb]>rank[upa]){
            par[upa]=upb;
        }
        else{
            par[upb]=upa;
            rank[upa]+=1;
        }
    }

    // Function to check whether 2 nodes are connected or not.
    public Boolean isConnected(int a, int b, int par[], int rank[]) {
        // add your code here
        return find_par(par,a)==find_par(par,b);
    }
}