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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        return preOrder(root,0,list,list2,targetSum);
    }
    public List<List<Integer>> preOrder(TreeNode root,int cur,List<List<Integer>> ar,List<Integer> list, int t){
            if(root==null)return ar;
            cur+=root.val;
            list.add(root.val);
            if(root.left==null && root.right==null){
               if(cur==t) ar.add(new ArrayList<>(list));
            }
            preOrder(root.left,cur,ar,list,t);
            preOrder(root.right,cur,ar,list,t);
            list.remove(list.size() - 1); 
            return ar;
    }
}