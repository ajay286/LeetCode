import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node {
    public Node[] list = new Node[26];
    public boolean isLastNode;

    public Node() {
        for (int i = 0; i < 26; i++)
            list[i] = null;

        this.isLastNode = false;
    }

}

class Trie {
    public Node node;

    public Trie() {
        node = new Node();
    }

    public void insert(String word) {
        Node temp = node;

        for (char ch: word.toCharArray()) {
            int index = this.charIndex(ch);
            if (temp.list[index] == null)
                temp.list[index] = new Node();

            temp = temp.list[index];
        }
        temp.isLastNode = true;
    }

    public boolean search(String word) {
        Node curr = node;
        return check(curr, word, 0);

    }

    public boolean check(Node curr, String s, int idx) {
        if (idx == s.length()) return curr != null && curr.isLastNode;

        if (s.charAt(idx) == '.') {
            for (int i = 0; i < 26; i++) {
                int x = i;

                if (curr.list[x] == null)
                    continue;

                if (check(curr.list[x], s, idx + 1))
                    return true;
            }
        } else {
            int x = charIndex(s.charAt(idx));

            if (curr.list[x] == null)
                return false;

            if (check(curr.list[x], s, idx + 1))
                return true;
        }
        return false;
    }

    private int charIndex(char ch) {
        return (int) ch - (int)
        'a';
    }
}

class WordDictionary {
    Trie trie;
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
