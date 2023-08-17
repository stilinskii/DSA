package datastructures.tree;

public class BinarySearchTree {

    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    // WRITE CONTAINS METHOD HERE //
    //                            //
    public boolean contains(int value){
        if(root == null) return false;

        Node temp = root;
        while(temp != null){
            if(temp.value == value) return true;
            if(temp.value > value){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        return false;

    }
    //                            //
    //                            //
    //                            //
    ////////////////////////////////

}
