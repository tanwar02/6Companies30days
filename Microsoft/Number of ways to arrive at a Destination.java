class Solution {
    
    public int countPaths(int n, int[][] roads) {

        int mod=(int)1e9+7;
        List<int[]>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++){

            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<roads.length; i++){

            graph[roads[i][0]].add(new int[]{roads[i][1], roads[i][2]});
            graph[roads[i][1]].add(new int[]{roads[i][0], roads[i][2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int[] count = new int[n];
        count[0] = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        pq.add(new int[]{0,0});

        while(!pq.isEmpty()){

            int[] arr = pq.poll();

            for(int[] ar : graph[arr[0]]){

                int time = arr[1] + ar[1];
                if(time < dist[ar[0]]){

                    dist[ar[0]] = time;
                    pq.add(new int[]{ar[0], time});
                    count[ar[0]] = count[arr[0]];
                }
                else if(time == dist[ar[0]]){

                    count[ar[0]] = (count[ar[0]] + count[arr[0]]) % mod;
                }
            }
        }
        return (int)count[n-1];
    }
}
