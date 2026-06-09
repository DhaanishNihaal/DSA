class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1;
        for(int i = n-1;i >= 1;i--){
            if(nums[i-1]<nums[i]){
                ind = i-1;
                break;
            }
        }
        if(ind == -1){
            reverse(nums,0,n-1);
            return;
        }
        for(int i = n-1;i >= 0;i--){
            if(nums[i]>nums[ind]){
                swap(nums,i,ind);
                break;
            }
        }
        reverse(nums,ind+1,n-1);
    }
    void reverse(int[] nums,int st,int ed){
        while(st<ed){
            swap(nums,st,ed);
            st++;
            ed--;
        }
    }
    void swap(int[]nums,int ind1,int ind2){
        int temp=nums[ind1];
        nums[ind1]=nums[ind2];
        nums[ind2]=temp;
    }
}