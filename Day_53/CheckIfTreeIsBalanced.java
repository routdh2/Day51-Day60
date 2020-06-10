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
class Solution {
    public boolean isBalanced(TreeNode root) {
        return findHeight(root)!=-1;
    }
    public int findHeight(TreeNode curr) {
        if(curr==null)
            return 0;
        int leftHeight=findHeight(curr.left);
        if(leftHeight==-1)//left subtree is unbalanced
            return -1;
        int rightHeight=findHeight(curr.right);
        if(rightHeight==-1) //right subtree is unbalanced
            return -1;
        
        if(Math.abs(leftHeight-rightHeight)>1)
            return -1;
        return 1+Math.max(leftHeight,rightHeight);
    }
}
