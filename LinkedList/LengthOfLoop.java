// Given the head of a singly linked list, determine whether the linked list contains a loop (cycle). If a loop exists, 
// return the length of the loop (i.e., the number of nodes that form the cycle). If no loop is present, return 0.

// A loop occurs when the last node of the linked list points back to a previous node instead of pointing to null.

// Example 1
// Input
// 10 → 20 → 30 → 40 → 50
//            ↑         ↓
//            └─────────┘
// Output
// 3
// Explanation

// The loop consists of the nodes:

// 30 → 40 → 50 → 30

// Hence, the length of the loop is 3.

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {

    public int lengthOfLoop(Node head) {

        if (head == null) {
            return 0;
        }

        Node slow = head;
        Node fast = head;

        // Detect Loop using Floyd's Cycle Detection Algorithm
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // Loop found
            if (slow == fast) {

                int count = 1;
                Node temp = slow.next;

                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }

                return count;
            }
        }

        // No loop found
        return 0;
    }
}

public class Main {

    public static void main(String[] args) {

        // Create Nodes
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);

        // Connect Nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Create Loop
        // 50 -> 30
        fifth.next = third;

        Solution obj = new Solution();

        int length = obj.lengthOfLoop(head);

        System.out.println("Length of Loop = " + length);
    }
}
