class RottingOrangesSolution {
    private int result = 0;
    private int fresh = 0;
    private Queue < int[] > queue = new LinkedList < int[] > ();

    public int orangesRotting(int[][] grid) {

        result = 0;
        fresh = 0;
        queue.clear();

        if (grid.length == 0)
            return result;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {

                if (grid[i][j] == 2) {
                    queue.add(new int[] {
                        i,
                        j
                    });
                } else if (grid[i][j] == 1) {
                    ++fresh;
                }

            }
        }

        this.helper(grid);


        return fresh == 0 ? result : -1;
    }

    public void helper(int[][] grid) {

        while (!this.queue.isEmpty()) {
            int currRotten = queue.size();

            for (int iter = 0; iter < currRotten; ++iter) {
                int[] rotten = queue.poll();
                int i = rotten[0];
                int j = rotten[1];

                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    queue.add(new int[] {
                        i,
                        j - 1
                    });
                    --fresh;

                }

                if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    queue.add(new int[] {
                        i,
                        j + 1
                    });

                    --fresh;
                }

                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    queue.add(new int[] {
                        i - 1, j
                    });
                    --fresh;
                }


                if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                    queue.add(new int[] {
                        i + 1, j
                    });
                    grid[i + 1][j] = 2;
                    --fresh;
                }

            }

            if (!queue.isEmpty())
                ++result;
        }

    }
}
