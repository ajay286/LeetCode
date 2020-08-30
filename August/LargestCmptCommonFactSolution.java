class LargestCmptCommonFactSolution {

    private int find(int[] root, int x) {
        return root[x] == x ? x : (root[x] = find(root, root[x]));
    }


    public int largestComponentSize(int[] A) {
        int n = 0, mx = 0, res = 0;
        HashMap < Integer, Integer > m = new HashMap < Integer, Integer > ();
        for (int num: A)
            mx = Math.max(mx, num);

        int[] root = new int[mx + 1];
        for (int i = 1; i <= mx; ++i)
            root[i] = i;

        for (int num: A) {
            for (int d = (int) Math.sqrt(num); d >= 2; --d) {
                if (num % d == 0) {
                    root[find(root, num)] = root[find(root, d)];
                    root[find(root, num)] = root[find(root, num / d)];

                }
            }

        }


        for (int num: A) {
            int index = find(root, num);
            if (!m.containsKey(index)) {
                Integer i = 1;
                m.put(index, i);
                res = Math.max(res, i);
            } else {
                Integer i = m.get(index);
                ++i;
                m.put(index, i);
                res = Math.max(res, i);
            }

        }
        return res;



    }

}
