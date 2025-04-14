package com.keyin.binarysearchtree.model;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    public BinaryNode root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private BinaryNode insertRec(BinaryNode node, int value) {
        if (node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            return newNode;
        }
        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    public void balance() {
        List<Integer> values = new ArrayList<>();
        inOrder(root, values);
        root = buildBalanced(values, 0, values.size() - 1);
    }

    private void inOrder(BinaryNode node, List<Integer> values) {
        if (node != null) {
            inOrder(node.left, values);
            values.add(node.value);
            inOrder(node.right, values);
        }
    }

    private BinaryNode buildBalanced(List<Integer> values, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        BinaryNode node = new BinaryNode();
        node.value = values.get(mid);
        node.left = buildBalanced(values, start, mid - 1);
        node.right = buildBalanced(values, mid + 1, end);
        return node;
    }
}