class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i < n;i++){
            int rem = target-nums[i];
            boolean isPresent = mp.containsKey(rem);
            if(isPresent) return new int[]{i,mp.get(rem)};
            mp.put(nums[i],i);
        }
        return new int[]{};
    }
}