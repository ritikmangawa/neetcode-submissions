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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculatelevel(root);
        return maxDiameter;
    }
    int calculatelevel(TreeNode root) {
        //base condition
        if(root == null) return 0;

        int leftlevel = calculatelevel(root.left);
        int rightlevel = calculatelevel(root.right);

        int currentDiameter = leftlevel + rightlevel;

        maxDiameter = Math.max(maxDiameter, currentDiameter);

        return  1 + Math.max(leftlevel, rightlevel);
    }
}
