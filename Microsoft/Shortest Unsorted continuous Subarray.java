class Solution {
    
    public int findUnsortedSubarray(int[] nums) {
        
        int[] arr = nums.clone();
        Arrays.sort(arr);
        
        int i=0;
        for(; i<nums.length; i++){
            
            if(nums[i] != arr[i]) break;
        }
        if(i == nums.length) return 0;
        
        int j = nums.length-1;
        for(; j>=0; j--){
            
            if(nums[j] != arr[j]) break;
        }
        
        return j-i+1;
    }
}

