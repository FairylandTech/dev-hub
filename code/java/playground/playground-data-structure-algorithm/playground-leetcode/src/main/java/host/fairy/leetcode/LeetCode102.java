/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-15 20:49:41 UTC+08:00
 ****************************************************/
package host.fairy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Leetcode 102
 * <p>给你二叉树的根节点 {@code root} ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。</p>
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">Leet Code Link</a>
 */
public class LeetCode102 {
    /**
     * Build a sample binary tree.
     *
     * @return Binary Tree Root Node
     */
    public static TreeNode buildTreeNode() {
        return new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );
    }
    
    /**
     * BFS loop binary tree.
     *
     * @param root Binary Tree Root Node
     * @return List of level order traversal
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outerList = new ArrayList<>();
        
        if (root == null) {
            return outerList;
        }
        
        LinkedTransferQueue<TreeNode> queue = new LinkedTransferQueue<>();
        
        queue.offer(buildTreeNode());
        
        int currentLevelSize = 1;
        while (!queue.isEmpty()) {
            int nextLevelSize = 0;
            List<Integer> innerList = new ArrayList<>();
            
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                if (currentNode == null) {
                    return outerList;
                }
                
                innerList.add(currentNode.val);
                
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                    nextLevelSize++;
                }
                
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                    nextLevelSize++;
                }
            }
            
            currentLevelSize = nextLevelSize;
            outerList.add(innerList);
        }
        return outerList;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> result = levelOrder(buildTreeNode());
        System.out.println("result = " + result);
    }
    
    /**
     * TreeNode of leetcode offers.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
        }
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
