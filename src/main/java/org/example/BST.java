package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public BST() {
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }
        return node;
    }

    public V get(K key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return node.val;
        }
        return null;
    }
    public void delete(K key){
        root = delete(root, key);
    }
    private Node delete(Node root, K key) {
        if (root == null) {
        }
        int cmp = key.compareTo(root.key);
        // If the key to be deleted is smaller than the root's key, then it lies in the left subtree
        if (cmp < 0) {
            root.left = delete(root.left, key);
        }
        // If the key to be deleted is greater than the root's key, then it lies in the right subtree
        else if (cmp > 0) {
            root.right = delete(root.right, key);
        }
        // If key is same as root's key, then this is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = delete(root.right, root.key);
        }

        return root;
    }
    K minValue(Node root) {
        K minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrder(root, keys);
        return keys;
    }

    private void inOrder(Node node, List<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }
}