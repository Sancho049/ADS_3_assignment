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
    }
}