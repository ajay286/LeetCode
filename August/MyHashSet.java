class MyHashSet {
    private final int MAX_LEN = 100000;
    private List < Integer > [] set;

    /** Returns the corresponding bucket index. */
    private int getIndex(int key) {
        return key % MAX_LEN;
    }

    /** Search the key in a specific bucket. Returns -1 if the key does not existed. */
    private int getPos(int key, int index) {

        List < Integer > temp = set[index];
        if (temp == null) {
            return -1;
        }
        for (int i = 0; i < temp.size(); ++i) {
            if (temp.get(i) == key) {
                return i;
            }
        }
        return -1;
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        set = (List < Integer > []) new ArrayList[MAX_LEN];
    }

    public void add(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos < 0) {
            if (set[index] == null) {
                set[index] = new ArrayList < Integer > ();
            }
            set[index].add(key);
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos >= 0) {
            set[index].remove(pos);
        }
    }

    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        return pos >= 0;
    }
}
