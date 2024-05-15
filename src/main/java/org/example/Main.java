package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(1000),
                    random.nextInt(1000));
            table.put(key, "Value" + i);
        }
        int bucketCount = 0;
        for (MyHashTable.HashNode<MyTestingClass, String> node : table.getChainArray()) {
            int count = 0;
            MyHashTable.HashNode<MyTestingClass, String> currentNode = node;
            while (currentNode != null) {
                count++;
                currentNode = currentNode.next;
            }
            System.out.println("Bucket " + bucketCount + ": " + count + " elements");
            bucketCount++;
        }
        BST<Integer, Integer> bst = new BST<>();
        bst.put(3,1);
        bst.put(1,3);
        bst.put(4,4);
        bst.put(2,5);
        for (Integer key : bst.iterator()) {
            System.out.println("Key: " + key + ", Value: " + bst.get(key));
        }
        System.out.println("BST after remove: ");
        bst.delete(1);
        for (Integer key : bst.iterator()) {
            System.out.println("Key: " + key + ", Value: " + bst.get(key));
        }
    }
}