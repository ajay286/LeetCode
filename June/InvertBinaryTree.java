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

public class InvertBinaryTree {

	public void traversal(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			this.traversal(root.left);
			this.traversal(root.right);
		}

	}

	public TreeNode invertTree(TreeNode root) {
		this.invertTreeInternal(root);
		return root;
	}

	private void invertTreeInternal(TreeNode root) {

		if (root != null) {
			TreeNode tempContainer = root.left;
			root.left = root.right;
			root.right = tempContainer;
			this.invertTreeInternal(root.left);
			this.invertTreeInternal(root.right);
		}

	}

	public static void main(String[] args) {

		InvertBinaryTree solution = new InvertBinaryTree();
		TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)),
				new TreeNode(7, new TreeNode(6, null, null), new TreeNode(9, null, null)));

		System.out.print("Original tree is [");
		solution.traversal(root);
		System.out.println("]");

		TreeNode revertedTree = solution.invertTree(root);
		System.out.print("\nReverted tree is [");
		solution.traversal(revertedTree);
		System.out.println("]");
	}

}
