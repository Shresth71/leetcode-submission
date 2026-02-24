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

    public boolean findTarget(TreeNode root, int k) {
        
        // List to store inorder traversal (sorted values of BST)
        List<Integer> list = new ArrayList<>();
        
        // Step 1: Do inorder traversal
        // In BST, inorder gives values in sorted order
        inorder(root, list);
        
        // Step 2: Apply two-pointer on sorted list
        int i = 0;                     // left pointer (smallest value)
        int j = list.size() - 1;      // right pointer (largest value)
        
        while (i < j) {
            
            // Current sum of two numbers
            int sum = list.get(i) + list.get(j);
            
            // If sum equals target → pair found
            if (sum == k) 
                return true;
            
            // If sum smaller → move left pointer forward
            // to increase sum
            else if (sum < k) 
                i++;
            
            // If sum larger → move right pointer backward
            // to decrease sum
            else 
                j--;
        }
        
        // No pair found
        return false;
    }
    
    
    // Inorder traversal function
    private void inorder(TreeNode node, List<Integer> list) {
        
        // Base case: if node is null → return
        if (node == null) 
            return;
        
        // Visit left subtree
        inorder(node.left, list);
        
        // Add current node value to list
        list.add(node.val);
        
        // Visit right subtree
        inorder(node.right, list);
    }
}