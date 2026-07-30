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
    public int maxPathSum(TreeNode root) {
        int sum[]={Integer.MIN_VALUE};
        post(root,sum);
        return sum[0];
    }
    public int post(TreeNode root,int[] sum){
        if(root==null)return 0;
        int left=Math.max(post(root.left,sum),0);
        int right=Math.max(post(root.right,sum),0);
        int cur=root.val+left+right;
        sum[0]=Math.max(sum[0],cur);
        return root.val+Math.max(left,right);
    } 
}