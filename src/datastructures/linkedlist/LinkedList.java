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

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
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

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            this.head = newNode;
            this.tail = newNode;
        }else{
            newNode.next= this.head;
            this.head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index){

        if(index < 0 || length <= index) return null;

        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value)  {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){

        if(index < 0 || index >= length) return null;

        //해당 인덱스 노드 찾기
        Node nodeTobeRemoved = get(index);

        //임시저장
        Node temp = nodeTobeRemoved;

        //앞 뒤 연결 끊기
        //처음꺼 삭제경우
        if(index-1 < 0){
            removeFirst();
        }else if(index == length-1){
            //마지막꺼 삭제경우
            removeLast();
        }else{
            //중간삭제경우
            get(index-1).next = nodeTobeRemoved.next;
            length--;
        }

        //삭제노드 연결 끊기
        nodeTobeRemoved.next=null;


        //임시저장 return
        return temp;

    }


}