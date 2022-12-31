class Solution {
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        return solve(k, n, 0);
    }
    
    List<List<Integer>> solve(int k, int n, int max){
        
        if(n <= max) return null;
        
        List<List<Integer>> list = new ArrayList<>();
        
        if(k == 1){
            
            if(n > 9) return null;
            List<Integer> l1 = new ArrayList<>();
            l1.add(n);
            list.add(l1);
            return list;
        }
        
        for(int i=max+1; i<Math.min(n,10); i++){
            
            List<List<Integer>> list1 = solve(k-1, n-i, i);
            if(list1 == null) continue;
            
            for(List<Integer> l: list1){
                
                if(!l.contains(i)){
                    
                    l.add(i);
                    list.add(l);
                }
            }
        }
        return list;
    }
}
