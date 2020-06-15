/*
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 * For example, 
 * Given the tree:
        4
       / \
      2   7
     / \
    1   3
    
    And the value to search: 2
 * */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class SearchBSTSolution {

	public TreeNode searchBST(TreeNode root, int val) {
		TreeNode result = null, iter = root;

		while (iter != null) {
			if (iter.val == val) {
				result = iter;
				break;
			}

			if (val < iter.val)
				iter = iter.left;
			else
				iter = iter.right;

		}

		return result;

	}

	public void traverse(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			this.traverse(root.left);
			this.traverse(root.right);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)),
				new TreeNode(7, null, null));

		SearchBSTSolution solution = new SearchBSTSolution();

		TreeNode found = solution.searchBST(root, 2);
		solution.traverse(found);
		System.out.println();
		found = solution.searchBST(root, 7);
		solution.traverse(found);
		found = solution.searchBST(root, 10);
		solution.traverse(found);
	}

}
