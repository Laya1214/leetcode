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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null)return null;
      List<Integer> list=new ArrayList<>();
      pre(root,list,low,high);
      if(list.isEmpty())return null;
      TreeNode root1=new TreeNode(list.get(0));
      for(int i=1;i<list.size();i++){
        insert(root1,list.get(i));
      }
      return root1;
    }
    public void pre(TreeNode root,List<Integer> list,int low,int high){
        if(root==null)return;
        if(root.val>=low  && root.val<=high){
            list.add(root.val);
        }
        pre(root.left,list,low,high);
        pre(root.right,list,low,high);
    }
    public TreeNode insert(TreeNode root,int val){
        if(root==null){ return new TreeNode(val);}
        if(root.val<val)root.right=insert(root.right,val);
        else root.left=insert(root.left,val);
        return root;
    }
}