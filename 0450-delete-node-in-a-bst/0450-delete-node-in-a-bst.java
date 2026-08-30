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

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) {
            return null;
        }

        // Key chhota hai
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Key bada hai
        else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Node mil gaya
        else {

            // Case 1: No left child
            if(root.left == null) {
                return root.right;
            }

            // Case 2: No right child
            if(root.right == null) {
                return root.left;
            }

            // Case 3: Both children exist

            TreeNode successor = findMin(root.right);

            root.val = successor.val;

            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode root) {

        while(root.left != null) {
            root = root.left;
        }

        return root;
    }
}