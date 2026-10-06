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
    public boolean isCompleteTree(TreeNode root) {
        ArrayList<TreeNode> bfs=new ArrayList<>();
                if(root==null) return true;
                Queue<TreeNode> q=new LinkedList<>();
                q.offer(root);
                while(!q.isEmpty()){
                    int n=q.size();
                    for(int i=0;i<n;i++){
                        TreeNode current = q.poll(); 
                        bfs.add(current);
                        if(current!=null){
                        q.offer(current.left);
                        q.offer(current.right);
                        }
                        
                    }
                }
                boolean isNull=false;
                for(int i=0;i<bfs.size();i++){
                    if(bfs.get(i)==null){
                        isNull=true;
                    }
                    else{
                        if(isNull){
                            return false;
                        }
                    }
                }
                return true;
    }
}