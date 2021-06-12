package Recurssion;


import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

class MyLinkedList{

    int size;
    ListNode head;
    MyLinkedList(){
        this.size = 0;
        head = null;
    }

    public void addNode(int data) {
        if (this.head == null) {
            head = new ListNode(data);
        } else {
            ListNode k = new ListNode(data);
            k.next = head;
            head = k;
        }
    }
}

public class LinkedListReversal {

     //Definition for singly-linked list.



        public ListNode reverseList(ListNode head) {
            if(head == null ||head.next == null){
                return head;
            }
            ListNode k = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return k;
        }


}
