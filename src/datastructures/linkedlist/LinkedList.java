package datastructures.linkedlist;

public class LinkedList {

    // CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE //
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }
    //                                                        //
    //                                                          //
    //                                                          //
    //                                                          //
    //////////////////////////////////////////////////////////////


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public Node removeLast(){

        Node temp = head;
        Node pre = head;
        if(this.length > 0){

            while(temp.next != null){
                pre = temp;
                temp = temp.next;
            }

            this.tail = pre;
            tail.next = null;

            //length 가 0이 되었는데
            //head와 tail은 아직 전의 노드를 가리키고있을때 방지.
            length--;
            if(length == 0){
                this.head=null;
                this.tail=null;
            }

        }

        return temp;
    }

}