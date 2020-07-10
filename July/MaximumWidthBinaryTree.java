import java.util.Deque;
import java.util.LinkedList;
import javafx.util.Pair;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class MaximumWidthBinaryTree {
	private int width = 0;

	public int widthOfBinaryTree(TreeNode root) {

		if (root == null)
			return this.width;

		this.width = 1;

		Deque<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
		queue.add(new Pair<TreeNode, Integer>(root, 0));

		while (!queue.isEmpty()) {
			int size = queue.size();
			int start = queue.peek().getValue();
			int end = queue.peekLast().getValue();
			this.width = Math.max(this.width, end - start + 1);

			for (int i = 0; i < size; ++i) {
				Pair pair = queue.pollFirst();
				Integer index = (Integer) pair.getValue();
				TreeNode node = (TreeNode) pair.getKey();
				if (node.left != null) {
					queue.add(new Pair<TreeNode, Integer>(node.left, index * 2 + 1));
				}
				if (node.right != null) {
					queue.add(new Pair<TreeNode, Integer>(node.right, index * 2 + 2));
				}
			}
		}

		return this.width;
	}

	public static void main(String[] args) {

		/*
		 *            1
		 *          /   \
		 *         3     2
		 *        / \     \  
		 *       5   3     9 
		 * */


		TreeNode nine = new TreeNode(9, null, null);
		TreeNode two = new TreeNode(2, null, nine);
		TreeNode three = new TreeNode(3, null, null);
		TreeNode five = new TreeNode(5, null, null);
		TreeNode threeP = new TreeNode(3, five, three);
		TreeNode root = new TreeNode(1, threeP, two);

		MaximumWidthBinaryTree solBinaryTree = new MaximumWidthBinaryTree();
		System.out.println(solBinaryTree.widthOfBinaryTree(root));

	}

}
