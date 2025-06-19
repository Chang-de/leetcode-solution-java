package com.code.core.model;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode(List<Integer> vals) {
        Deque<TreeNode> deque = new LinkedList<>();
        int size = vals.size();
        this.val = vals.get(0);
        deque.push(this);
        int index = 1;
        while (!deque.isEmpty() && index < size) {
            TreeNode node = deque.pollFirst();
            if(node == null) {
                continue;
            }
            TreeNode left = createTreeNodeByInteger(vals.get(index++));
            node.left = left;
            deque.addLast(left);
            if(index == size){break;}
            TreeNode right = createTreeNodeByInteger(vals.get(index++));
            node.right = right;
            deque.addLast(right);
        }
    }
    public String toString(){
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(this);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            if(node == null) {
                sb.append("null").append(",");
                continue;
            }
            sb.append(node.val).append(",");
            deque.addLast(node.left);
            deque.addLast(node.right);
        }
        int lastIndex = sb.lastIndexOf(",");
        if(lastIndex > 0){
            sb.deleteCharAt(lastIndex);
        }
        sb.append("]");
        return sb.toString();
    }
    public static TreeNode createTreeNodeByInteger(Integer val) {
        if(val == null) {
            return null;
        } else {
            return new TreeNode(val);
        }
    }
}
