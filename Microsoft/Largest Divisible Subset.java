class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        Arrays.sort(nums);
        List<Integer>[] dp = new ArrayList[nums.length];
        List<Integer> res = null;

        for(int i=0; i<nums.length; i++){

            dp[i] = new ArrayList<>();
            for(int j=0; j<i; j++){

                if(nums[i] % nums[j] == 0 && dp[i].size() < dp[j].size()){

                    dp[i] = dp[j];
                }
            }
            dp[i] = new ArrayList<>(dp[i]);
            dp[i].add(nums[i]);
            if(res == null || res.size() < dp[i].size()) res = dp[i];
        }
        return res;
    }
}
