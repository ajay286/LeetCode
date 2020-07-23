import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzag {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		this.traverse(root, true, 0);
		return result;
	}

	public void traverse(TreeNode root, boolean addLast, int level) {
		if (root != null) {

			if (level >= this.result.size()) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(root.val);
				this.result.add(list);

			} else {

				if (addLast)
					this.result.get(level).add(0, root.val);
				else
					this.result.get(level).add(root.val);
			}

			addLast = !addLast;

			if (root.right != null) {
				this.traverse(root.right, addLast, level + 1);
			}

			if (root.left != null) {
				this.traverse(root.left, addLast, level + 1);
			}

		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3, new TreeNode(9, null, null),
				new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
		BinaryTreeZigzag solBinaryTreeZigzag = new BinaryTreeZigzag();
		List<List<Integer>> result = solBinaryTreeZigzag.zigzagLevelOrder(root);
		for (List<Integer> list : result)
			System.out.println(list);

	}
}
