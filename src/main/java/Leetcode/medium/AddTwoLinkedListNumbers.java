package Leetcode.medium;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoLinkedListNumbers {
    public static void main(String[] args) {
        ListNode l1= new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2= new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(5);
        l2.next.next.next = new ListNode(6);
        l2.next.next.next.next = new ListNode(6);
        l2.next.next.next.next.next = new ListNode(6);
        l2.next.next.next.next.next.next = new ListNode(6);
        l2.next.next.next.next.next.next.next = new ListNode(6);
        l2.next.next.next.next.next.next.next.next = new ListNode(6);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(6);

        AddTwoLinkedListNumbers a = new AddTwoLinkedListNumbers();
        ListNode ln = a.addTwoNumbers(l1, l2);
        System.out.println("");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = getInteger(l1);
        BigInteger num2 = getInteger(l2);

        BigInteger sum = num1.add(num2);
        StringBuilder sb = new StringBuilder(String.valueOf(sum));
        return getNewNode(sb.reverse().toString());
    }

    private BigInteger getInteger(ListNode l) {
        StringBuilder sb = new StringBuilder();
        while (l !=null) {
            sb.insert(0, l.val);
            l = l.next;
        }

        return new BigInteger(sb.toString());
    }

    private ListNode getNewNode(String s) {
        char[] data = s.toCharArray();
        ListNode l = null, tail = null;
        for(char c : data) {
            ListNode ln = new ListNode(Integer.parseInt(String.valueOf(c)));
            if(l == null) {
                l = ln;
                tail = l;
            } else {
                tail.next = ln;
                tail = tail.next;
            }
        }

        return l;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}