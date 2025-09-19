/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-17 14:28:59 UTC+08:00
 ****************************************************/
package host.fairy.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

/**
 * LeetCode 103. Binary Tree Zigzag Level Order Traversal
 * <p>给你二叉树的根节点 {@code root} ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。</p>
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/">Leetcode link</a>
 */
public class LeetCode103 {
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
     * Zigzag loop binary tree.
     *
     * @param root Binary Tree Root Node
     * @return List of level order traversal
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> outerList = new ArrayList<>();
        
        if (root == null) {
            return outerList;
        }
        
        LinkedTransferQueue<TreeNode> queue = new LinkedTransferQueue<>();
        
        queue.offer(root);
        
        int currentLevelSize = 1;
        boolean oddLevel = true;  // Track whether the current level is odd or even
        while (!queue.isEmpty()) {
            int nextLevelSize = 0;
            ArrayDeque<Integer> innerDeque = new ArrayDeque<>();
            
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                if (currentNode == null) {
                    return outerList;
                }
                
                if (oddLevel) {
                    innerDeque.offerLast(currentNode.val);
                } else {
                    innerDeque.offerFirst(currentNode.val);
                }
                
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                    nextLevelSize++;
                }
                
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                    nextLevelSize++;
                }
            }
            
            outerList.add(new ArrayList<>(innerDeque));
            currentLevelSize = nextLevelSize;
            oddLevel = !oddLevel;  // Toggle the level flag
        }
        return outerList;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> result = zigzagLevelOrder(buildTreeNode());
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
