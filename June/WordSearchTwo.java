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

		for (char ch : word.toCharArray()) {
			int index = this.charIndex(ch);
			if (temp.list[index] == null)
				temp.list[index] = new Node();

			temp = temp.list[index];
		}
		temp.isLastNode = true;

	}

	public boolean search(String word) {
		Node temp = this.node;
		for (char ch : word.toCharArray()) {
			int index = this.charIndex(ch);
			if (temp.list[index] == null) {
				return false;
			}

			temp = temp.list[index];
		}

		return temp.isLastNode && temp != null;
	}

	public boolean startsWith(String prefix) {
		Node temp = node;
		for (char ch : prefix.toCharArray()) {
			int index = this.charIndex(ch);
			if (temp.list[index] != null) {
				temp = temp.list[index];
			} else {
				return false;
			}
		}
		return true;
	}

	private int charIndex(char ch) {
		return (int) ch - (int) 'a';
	}
}

public class WordSearchTwo {

	private Trie trie = new Trie();
	private Set<String> result = new HashSet<String>();

	public List<String> findWords(char[][] board, String[] words) {
		for (String word : words)
			trie.insert(word);

		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				this.dfs(board, i, j, "");
			}
		}

		return new ArrayList<String>(this.result);
	}

	private void dfs(char[][] board, int i, int j, String input) {
		char ch = board[i][j];
		if (ch == '~')
			return;

		board[i][j] = '~';
		String newStr = input + ch;

		if (this.trie.startsWith(newStr)) {
			if (this.trie.search(newStr)) {
				this.result.add(newStr);
			}

			if (i < board.length - 1)
				this.dfs(board, i + 1, j, newStr);
			if (j < board[0].length - 1)
				this.dfs(board, i, j + 1, newStr);
			if (i > 0)
				this.dfs(board, i - 1, j, newStr);
			if (j > 0)
				this.dfs(board, i, j - 1, newStr);
		}

		board[i][j] = ch;

	}

	public static void main(String[] args) {
		WordSearchTwo wordSearchTwo = new WordSearchTwo();
		String[] words = { "oath", "pea", "eat", "rain" };
		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		System.out.println(wordSearchTwo.findWords(board, words));
	}

}
