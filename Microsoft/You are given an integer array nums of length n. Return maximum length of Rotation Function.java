class Solution {

    public int maxRotateFunction(int[] nums) {
        
        int sum = 0, max = 0;

        for(int i=0; i<nums.length; i++){

            sum += nums[i];
            max += i * nums[i];
        }
        int last = max;

        for(int i=1; i<nums.length; i++){

            last -= (nums.length-1) * nums[nums.length-i];
            last += sum - nums[nums.length-i];

            max = Math.max(max, last);
        }
        return max;
    }
}
