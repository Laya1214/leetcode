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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return preOrder(root,0,targetSum);
    }
    private boolean preOrder(TreeNode root, int cur,int t){
        if(root==null)return false;
        cur+=root.val;
        if(root.left==null && root.right==null && cur==t)return true;
        
        return preOrder(root.left,cur,t) || preOrder(root.right,cur,t);
       
    }
}