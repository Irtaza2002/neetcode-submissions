class Solution {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private Set<Integer> vis = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            graph.get(pre[0]).add(pre[1]);
        }
        for(int c=0;c<numCourses;c++){
            if(!dfs(c)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int curr){
        if(vis.contains(curr)){
            return false;
        }
        if(graph.get(curr).isEmpty()){
            return true;
        }
        vis.add(curr);
        for(int pre: graph.get(curr)){
            if(!dfs(pre)){
                return false;
            }
        }
        vis.remove(curr);
        graph.put(curr, new ArrayList<>());
        return true;
    }
}
