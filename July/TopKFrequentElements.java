class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer> > queue =   new PriorityQueue<>( 
            (a, b) -> a.getValue().equals(b.getValue()) ?  
                      Integer.compare(b.getKey(), a.getKey()) :  
                      Integer.compare(b.getValue(), a.getValue())); 
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (int i = 0; i < nums.length; i++) { 
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); 
        } 
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
            queue.offer(entry);
        
        for (int i = 0; i < k; i++) { 
            result[i] =queue.poll().getKey(); 
        } 
        
        return result;
    }
}
