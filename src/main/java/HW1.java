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
// see generic methods of ADT. SEE BINARY TREES
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
        // tail node
        private Node tail;
        private int size = 0;

        // Utilities for testing/demo
        public void addLast(int x){
            Node newNode = new Node(x);
            if(head == null){ head = tail = newNode; }
            else{
                tail.next = newNode;
                tail = newNode;            }
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

            if(head == null || head.next == null) return;
            Set<Integer> tempSet = new HashSet<>();

            Node currentNode = head;
            Node trackNode=null;
            while(currentNode != null){
                if(!tempSet.contains(currentNode.data)){
                    tempSet.add(currentNode.data);
                    if(trackNode == null) trackNode = currentNode.next;
                    else trackNode.next = currentNode;
                    trackNode = currentNode;
                } else {
                    trackNode.next = currentNode.next;
                }
                currentNode = currentNode.next;
            }
        }





        /**
         * Reverse the entire list by using a stack (java.util.Stack).
         * You must use a Stack in your solution (push values or nodes).
         * Example: [1,2,3,4] -> [4,3,2,1]
         * Time: O(n), Extra Space: O(n).
         */
        public void reverse(){
            // TODO: implement using java.util.Stack
            Stack<Node> stack = new Stack<>();
            Node cur = head;
            while(cur != null){
                stack.push(cur);
                cur = cur.next;
            }
            head = stack.pop();
            cur = head;
            while(!stack.isEmpty()){
                cur.next = stack.pop();
                cur = cur.next;
            }
            tail = cur;
            tail.next = null;
        }
        /**
         * Return the value of the n-th node from the end (1-based).
         * Example: [10,20,30,40,50], n=2 -> 40.
         * Use a single pass (two pointers). Throw NoSuchElementException if invalid.
         */
        public int getNthFromEnd(int n){
            // TODO: implement two-pointer technique
            if (n <= 0 || n >  size) throw new NoSuchElementException("n out of range");
                //throw new IndexOutOfBoundsException();
            Node nodePtr1 = head;
            Node nodePtr2 = head;

            for (int i = 0; i < n; i++){
                nodePtr1 = nodePtr1.next;
            }
            while(nodePtr1 != null ){
                nodePtr1 = nodePtr1.next;
                nodePtr2 = nodePtr2.next;
                }

            return nodePtr2.data;
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

        for (int i = 0; i < s.length(); i++){
             st.push(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++){
            if (st.pop() != s.charAt(i)) return false;
        }
        return true;

        
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
        /*
        a++, b++ => O(1)
        for the first loop number of iterations n, second m.
        so:
            for (int i=0; i < n; i++) a++; =>> O(1) * n = O(n).
            for (int j=0; j < m; j++) b++; =>> O(1) * m = O(m)
            =>> time complexity: for the sequential statements we add both: O(n) + O(m)
            =>> space complexity:
                we have only variables: i,j,a & b: no objects or any data structures (linear/non linear),
                    =>> memory usage is the same all the time; Constant space for i,j,a & b == O(1)
         */

        // RETURN THE CORRECT OPTION NUMBER LISTED ABOVE
        return 3;
    }


    public static int algorithmAnalysis2(int n) {
        int i, j, k = 0;
        for (i = n/2; i <= n; i++)
            for ( j = 2; j <= n; j = j*2 )
                k += n/2; //(1)
        /*      outer loop: iterations/steps/number of integers(iterations) in a range (num2-num1)+1, +1 because of <=: last int included,
                therefor: total steps n-(n/2)+1, =>> O(n)

                Inner loop:  j grows exponentially to the power of 2,
                number of iterations:  J starts J=2. ( as J*2 each time) T iterations => 2^(T+1)., +1 because we are not starting from 0 j=2.
                the loop stops (max # iterations )when 2^(T+1) <= n; the loop condition j <= n;
                so the number of times we do that is logarithmic =>> O(log n)

         time complexity = T outer loop * T inner loop = O(n) * O(log n)

         */
        /*
         * Select the correct option listed below:
         *   1. O(N) time
         *   2. O(N log N) time
         *   3. O(N^2) time
         *   4. O(N^2 log N) time
         *
         * TODO: return the answer (which option is correct), in the return statement
         *
         */

        // RETURN THE CORRECT OPTION LISTED ABOVE
        return 2; //
    }
}
