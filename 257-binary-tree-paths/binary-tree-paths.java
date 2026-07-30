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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        return pre(root,res,sb);
    }
    public List<String> pre(TreeNode root,List<String> res,StringBuilder sb){
         if(root==null)return res;
         int Ol=sb.length();
             if (Ol > 0) {
            sb.append("->");
            }
            sb.append(root.val);
            if(root.left==null && root.right==null ){
               res.add(sb.toString());
            }
            pre(root.left,res,sb);
            pre(root.right,res,sb);
            sb.setLength(Ol); 
            return res;
    }
}