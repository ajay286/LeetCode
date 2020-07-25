class AllPathsFromSourceTarget {
    List < List < Integer >> result = new LinkedList < List < Integer >> ();

    public List < List < Integer >> allPathsSourceTarget(int[][] graph) {
        int index = 0;
        for (int x: graph[index]) {
            List < Integer > record = new LinkedList < > ();
            record.add(0);
            record.add(x);
            dfs(graph, x, record);
        }
        return result;
    }


    public void dfs(int[][] graph, int index, List < Integer > record) {
        if (index == graph.length - 1) {
            result.add(record);
            return;
        }
        if (graph[index] == null) {
            return;
        }
        for (int x: graph[index]) {
            record.add(x);
            int size = record.size();
            dfs(graph, x, record);
            List < Integer > temp = new LinkedList < Integer > ();
            for (int i = 0; i < size - 1; i++) {
                temp.add(record.get(i));
            }
            record = temp;
        }
    }
}
