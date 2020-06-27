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
class SumRootToLeaf {
    private ArrayList<Integer> resultArray = new ArrayList<Integer>();
    private int result = 0;
    private boolean isRoot = true;
    
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return result;
        
        this.traverseTree(root,1);
        
        for(Integer element : resultArray)
            result += element;
        
        return this.result;
    }
    
    private void traverseTree(TreeNode root, int previous){
        if (root != null){
            
            if(isRoot){
                previous = root.val;
                isRoot = false;                
            }
            else
                previous = previous*10 + root.val;
                
                
            if(root.left == null &&  root.right == null){
                resultArray.add(previous);
                return;
            }
            this.traverseTree(root.left, previous);
            this.traverseTree(root.right, previous);
   
        }
    }
}
