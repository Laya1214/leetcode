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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur=root;
        if(cur==null)return null;
        if(cur.val==val){
            return cur;
        }
        if(val>cur.val)return searchBST(cur.right,val);
        if(val<cur.val)return searchBST(cur.left,val);
        return null;
    }
} 
