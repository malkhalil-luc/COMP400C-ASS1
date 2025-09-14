/*
 * COMP 272 — Programming Assignment 1 
 * Student: <Your Name>   Section: <Your Section>
 *
 * IMPORTANT:
 * - Implement the TODO methods. Keep the method signatures unchanged.
 * - Do NOT modify Main_v3.java (driver).
 * - You may add private helpers and fields if needed.
 */

import java.util.*;

public class HW1 {

    /* =========================
     * Part 1 — Linked List (SLL)
     * ========================= */
    public static class SinglyLinkedList {
        static class Node {
            int data;
            Node next;
            Node(int d){ data = d; }
        }

        private Node head;
        private int size = 0;

        // Utilities for testing/demo
        public void addLast(int x){
            Node nn = new Node(x);
            if(head == null){ head = nn; }
            else{
                Node cur = head;
                while(cur.next != null) cur = cur.next;
                cur.next = nn;
            }
            size++;
        }

        public int size() { return size; }

        @Override public String toString(){
            StringBuilder sb = new StringBuilder("[");
            Node cur = head;
            while(cur != null){
                sb.append(cur.data);
                cur = cur.next;
                if(cur != null) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
        /**
         * Remove all duplicate values, preserving the first occurrence.
         * Example: [3,1,3,2,1] -> [3,1,2]
         */
        public void removeDuplicates(){
            // TODO: implement using a HashSet or O(n^2) two-pointer approach
            
        }


        /**
         * Reverse the entire list by using a stack (java.util.Stack).
         * You must use a Stack in your solution (push values or nodes).
         * Example: [1,2,3,4] -> [4,3,2,1]
         * Time: O(n), Extra Space: O(n).
         */
        public void reverse(){
            // TODO: implement using java.util.Stack
            
        }

        /**
         * Return the value of the n-th node from the end (1-based).
         * Example: [10,20,30,40,50], n=2 -> 40.
         * Use a single pass (two pointers). Throw NoSuchElementException if invalid.
         */
        public int getNthFromEnd(int n){
            // TODO: implement two-pointer technique

            throw new NoSuchElementException("n out of range");
            
        
        }

    }

    /* =========================
     * Part 2 — Stack
     * ========================= */

    /**
     * STACK: Return true if input is a palindrome ignoring case and spaces.
     * Examples: "Race Car" -> true, "racecar" -> true, "ab ca" -> false.
     * Time: O(n), Extra Space: O(n).
     * Use java.util.Stack<Character>.
     */
    public static boolean isPalindrome(String input){
        Stack<Character> st = new Stack<>();
        String s = input.toLowerCase().replaceAll("\\s+", "");
        // TODO: implement method here
        return false;
        
    }

    /* =========================
     * Part 3 — Algorithm Analysis
     * ========================= */

    public static int algorithmAnalysis1(int n, int m) {
        int a = 0, b = 0;

        for (int i=0; i < n; i++) a++;   // simulate work
        for (int j=0; j < m; j++) b++;   // simulate work

        /*
         * Select the correct option listed below:
         *   1. O(N * M) time, O(1) space
         *   2. O(N + M) time, O(N + M) space
         *   3. O(N + M) time, O(1) space
         *   4. O(N * M) time, O(N + M) space
         *
         * TODO: return the answer (which option is correct), in the return statement
        */

        // RETURN THE CORRECT OPTION NUMBER LISTED ABOVE
        return -1;
    }


    public static int algorithmAnalysis2(int n) {
        int i, j, k = 0;
        for (i = n/2; i <= n; i++)
            for ( j = 2; j <= n; j = j*2 )
                k += n/2;

        /*
         * Select the correct option listed below:
         *   1. O(N) time
         *   2. O(N log N) time
         *   3. O(N^2) time
         *   4. O(N^2 log N) time
         *
         * TODO: return the answer (which option is correct), in the return statement
         */

        // RETURN THE CORRECT OPTION LISTED ABOVE
        return -1;
    }
}
