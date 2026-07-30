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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        List<int[]> nodes=new ArrayList<>();
        traverse(root,0,0,nodes);
        nodes.sort((n1,n2)->{
            if (n1[0] != n2[0]) {
                return Integer.compare(n1[0], n2[0]); 
            }
            if (n1[1] != n2[1]) {
                return Integer.compare(n1[1], n2[1]); 
            }
            return Integer.compare(n1[2], n2[2]); 
        });
        int i=0;
        while(i<nodes.size()){
            List<Integer> colList=new ArrayList<>();
            int colid=nodes.get(i)[0];
             while (i < nodes.size() && nodes.get(i)[0] == colid) {
                colList.add(nodes.get(i)[2]);
                i++;
            }
            res.add(colList);
        }

        return res;
        }

    
    public void traverse(TreeNode root,int row,int col,List<int[]> nodes){
        if(root==null)return;
        nodes.add(new int[]{col,row,root.val});
        traverse(root.left,row+1,col-1,nodes);
        traverse(root.right,row+1,col+1,nodes);
    }
}