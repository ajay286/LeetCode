/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

public class SameTreeSolution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return this.traverse(p, q);
	}

	private boolean traverse(TreeNode p, TreeNode q) {
		boolean result = true;

		if ((p != null && q == null) || (p == null && q != null))
			return false;
		else if (p == null && q == null)
			return true;

		if (p != null && q != null && p.val == q.val) {
			result = this.traverse(p.left, q.left);
			if (result)
				result = this.traverse(p.right, q.right);
		} else {
			return false;
		}

		return result;
	}

	public static void main(String[] args) {

		SameTreeSolution solution = new SameTreeSolution();
		TreeNode treeOne = new TreeNode(1, new TreeNode(2, null, null), null);
		TreeNode treetwo = new TreeNode(1, null, new TreeNode(2, null, null));
		System.out.println(solution.isSameTree(treeOne, treetwo));

		treeOne = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
		treetwo = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
		System.out.println(solution.isSameTree(treeOne, treetwo));

	}
}
