class Solution {
    
    int[] bob_time;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int n = amount.length;
        List<Integer>[] neighbors = new ArrayList[n];
        for(int i=0; i<n; i++) neighbors[i] = new ArrayList<>();
        for(int[] edge: edges){
            
            neighbors[edge[0]].add(edge[1]);
            neighbors[edge[1]].add(edge[0]);
        }
        bob_time = new int[n];
        Arrays.fill(bob_time, 100000);
        traverseBob(bob, neighbors, 0);
        // for(int i=0; i<n; i++) System.out.print(bob_time[i]+" ");
        // System.out.println();
        return maxIncome(0, neighbors, 0, new boolean[n], amount);
    }
    private int maxIncome(int alice, List<Integer>[] neighbors, int time, boolean[] vis, int[] amount){
        
        vis[alice] = true;
        int income = 0;
        if(bob_time[alice] == -1) income = amount[alice];
        else if(bob_time[alice] == time) income = amount[alice]/2;
        else if(time < bob_time[alice]) income = amount[alice];
        Integer p = null;
        
        for(int k: neighbors[alice]){
            
            if(vis[k]) continue;
            if(p == null) p  = maxIncome(k, neighbors, time+1, vis, amount);
            else p = Math.max(p, maxIncome(k, neighbors, time+1, vis, amount));
        }
        if(p == null) return income;
        return income+p;
    }
    private boolean traverseBob(int bob, List<Integer>[] neighbors, int time){
        
        if(bob_time[bob] != 100000) return false;
        bob_time[bob] = time;
        if(bob == 0) return true;
        
        for(int k: neighbors[bob]){
            
            if(traverseBob(k, neighbors, time+1)) return true;
        }
        bob_time[bob] = 100000;
        return false;
    }
}
