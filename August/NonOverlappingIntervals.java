class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals.length <= 1){
            return 0;   
        }
        
        Arrays.sort(intervals, (a, b)->(a[0] - b[0]));
        
        int result = 0, lastIncluded = 0;
        
        for(int i = 1; i < intervals.length; ++i){
            if(intervals[i][0] < intervals[lastIncluded][1]){
                result++;
                if(intervals[i][1] < intervals[lastIncluded][1]) 
                    lastIncluded = i;
            } 
            else 
                lastIncluded = i;
        }
        return result;
    }
}
