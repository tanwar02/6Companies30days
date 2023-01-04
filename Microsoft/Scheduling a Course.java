class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] neighbors = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++) neighbors[i] = new ArrayList<>();

        for(int[] pre: prerequisites){

            neighbors[pre[0]].add(pre[1]);
        }
        
        for(int i=0; i<numCourses; i++){

            if(neighbors[i] == null) continue;
            if(isCycle(neighbors, i, new boolean[numCourses])) return false;
        }
        return true;
    }
    private boolean isCycle(List<Integer>[] neighbors, int i, boolean[] vis){

        if(vis[i]) return true;
        if(neighbors[i] == null) return false;
        vis[i] = true;

        for(int k: neighbors[i]){

            if(isCycle(neighbors, k, vis)) return true;
        }
        neighbors[i] = null;
        vis[i] = false;
        return false;
    }
}
