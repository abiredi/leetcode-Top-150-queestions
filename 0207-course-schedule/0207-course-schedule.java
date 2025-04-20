class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int totalCourses=0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            totalCourses++;
        

            for(int node : adjList.get(course))
            {
                indegree[node]--;
                if(indegree[node] == 0) queue.add(node);
            }

        }
    return totalCourses == numCourses;     
    }
}