class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        helper(candidates,ans,temp,0,target,0);
        return ans;
    }
    private void helper(int[] arr,List<List<Integer>> ans,List<Integer> temp,int sum,int target,int ind){
        if(ind>=arr.length || sum>target){
            if(sum==target){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(arr[ind]);
        sum+=arr[ind];
        helper(arr,ans,temp,sum,target,ind);
        temp.remove(temp.size()-1);
        sum-=arr[ind];
        helper(arr,ans,temp,sum,target,ind+1);
    }
}