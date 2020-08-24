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
class SumLeftLeavesSolution {
    private int result;
    public int sumOfLeftLeaves(TreeNode root) {
        this.result = 0;
        this.internalSumOfLeftLeaves(root);
        return this.result;
    }

    private void internalSumOfLeftLeaves(TreeNode root) {
        if (root != null) {

            if (root.left != null && root.left.left == null && root.left.right == null)
                result += root.left.val;

            this.internalSumOfLeftLeaves(root.left);
            this.internalSumOfLeftLeaves(root.right);
        }
    }
}
