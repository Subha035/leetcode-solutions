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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i = 0 ;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(map,0,inorder.length-1,inorder,0,postorder.length-1,postorder);
    }
    public TreeNode buildTree(Map<Integer,Integer> map,int is,int ie,int[] inorder,int ps,int pe,int[] postorder){
        if(ps> pe || is>ie) return null;
        TreeNode root=new TreeNode(postorder[pe]);
        int inroot=map.get(postorder[pe]);
        int numsrem=inroot-is;
        root.left=buildTree(map,is,inroot-1,inorder,ps,ps+numsrem-1,postorder);
        root.right=buildTree(map,inroot+1,ie,inorder,ps+numsrem,pe-1,postorder);
        return root;
    }
}