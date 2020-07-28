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

class MyIndex {
    int index;
}

class BTreeFromInAndPostorder {
    

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        MyIndex mIndex = new MyIndex();
        mIndex.index = inorder.length - 1;

        return this.buildTreeInternal(inorder, postorder, 0, inorder.length - 1, mIndex);

    }

    private TreeNode buildTreeInternal(int inorder[], int[] postorder, int lb, int ub, MyIndex idx) {
        
        if (lb > ub)
            return null;

        TreeNode node = new TreeNode(postorder[idx.index]);
        --(idx.index);
       

        if (lb == ub)
            return node;

        int index = find(inorder, lb, ub, node.val);

        node.right = buildTreeInternal(inorder, postorder, index + 1, ub, idx);
        node.left = buildTreeInternal(inorder, postorder, lb, index - 1,idx );
        
        return node;

    }

    int find(int arr[], int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        
        return i;
    }

}
