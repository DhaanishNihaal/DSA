class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int psum = 0;
        int ans = 0;
        for(int i = 0;i < n;i ++){
            psum += nums[i];
            ans += map.getOrDefault(psum-k,0);
            map.put(psum,map.getOrDefault(psum,0)+1);
        }
        return ans;
    }
}