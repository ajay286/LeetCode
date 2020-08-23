class RandomPointSolution {

    ArrayList < Integer > area = new ArrayList < Integer > ();
    int[][] rect;
    int sum;

    public RandomPointSolution(int[][] rects) {
        rect = rects;

        for (int i = 0; i < rects.length; i++) {
            int x1 = rects[i][0];
            int y1 = rects[i][1];
            int x2 = rects[i][2];
            int y2 = rects[i][3];
            int temp = (Math.abs(x2 - x1) + 1) * (Math.abs(y2 - y1) + 1);
            sum += temp;
            area.add(sum);
        }

    }

    public int[] pick() {

        int randArea = (int)(Math.random() * Integer.MAX_VALUE) % sum + 1;
        int i;
        for (i = 0; i < area.size(); i++) {
            if (randArea <= area.get(i))
                break;
        }

        int dist_x = (int)(Math.random() * Integer.MAX_VALUE) % (Math.abs(rect[i][0] - rect[i][2]) + 1);
        int dist_y = (int)(Math.random() * Integer.MAX_VALUE) % (Math.abs(rect[i][1] - rect[i][3]) + 1);

        return new int[] {
            dist_x + rect[i][0], dist_y + rect[i][1]
        };

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
