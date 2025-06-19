package com.code.core.solution;

import com.code.core.Solution;
import com.code.core.model.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal implements Solution<List<List<Integer>>, TreeNode> {
    @Override
    public List<List<Integer>> solve(TreeNode root) {
        if(root == null){
            return List.of();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode node = deque.pollFirst();
                if(node.left != null){
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    deque.addLast(node.right);
                }
                levelList.add(node.val);
            }
            ans.add(levelList);
        }
        return ans;
    }

    @Override
    public TreeNode input() {
        TreeNode treeNode = new TreeNode(Arrays.asList(1,2,null,3,null,4,null,5));
        System.out.println(treeNode);
        return treeNode;
    }
}
