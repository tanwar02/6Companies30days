class Solution {
    
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        
        for(int i=0; i<nums1.length; i++){

            nums1[i] -= nums2[i];
        }
        List<Integer> list = new ArrayList<>();

        long pair = 0;

        for(int i=nums1.length-1; i>=0; i--){

            pair += findPairs(list, nums1[i]);
            int j = findIndex(list, nums1[i]+diff);
            list.add(j, nums1[i] + diff);
        }
        return pair;
    }
    private int findPairs(List<Integer> list, int a){

        int lo = 0, hi = list.size()-1, mid;

        while(lo <= hi){

            mid = lo + (hi - lo)/2;
            if(a <= list.get(mid)) hi = mid-1;
            else lo = mid+1;
        }
        return list.size() - hi - 1;
    }
    private int findIndex(List<Integer> list, int a){

        int lo = 0, hi = list.size()-1, mid;

        while(lo <= hi){

            mid = lo + (hi - lo)/2;
            if(a <= list.get(mid)) hi = mid-1;
            else lo = mid+1;
        }
        return lo;
    }
}
