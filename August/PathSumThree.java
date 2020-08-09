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
class PathSumThree {
    private int result = 0;
    public int pathSum(TreeNode root, int sum) {

        if (root == null)
            return result;

        Queue < TreeNode > q = new LinkedList < TreeNode > ();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();

            this.traverseSum(currNode, sum, 0);

            if (currNode.left != null)
                q.add(currNode.left);

            if (currNode.right != null)
                q.add(currNode.right);

        }

        return result;

    }

    private void traverseSum(TreeNode root, int sum, int prevNodeSum) {

        if (root != null) {
            prevNodeSum += root.val;

            if (prevNodeSum == sum)
                ++result;

            this.traverseSum(root.left, sum, prevNodeSum);
            this.traverseSum(root.right, sum, prevNodeSum);

        }

    }
}
