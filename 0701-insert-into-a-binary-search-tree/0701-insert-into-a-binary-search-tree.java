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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        // Base case:
        // If root is null → create new node and return
        if (root == null) {
            return new TreeNode(val);
        }

        // If value is smaller → go to left subtree
        if (val < root.val) {
            
            // Insert in left and attach returned node
            root.left = insertIntoBST(root.left, val);
        }
        
        // If value is greater → go to right subtree
        else {
            
            // Insert in right and attach returned node
            root.right = insertIntoBST(root.right, val);
        }

        // Return unchanged root
        return root;
    }
}