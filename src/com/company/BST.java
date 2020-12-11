package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    Node root;
    int size = 0;


    public void add(int value) {
        root = addNode(root, value);
    }

    private Node addNode(Node node, int i) {

        if (node == null) { //checks if tree is empty
            return new Node(i);
        }
        else if (i < node.getValue()) { //compares to see which side of the tree to go down
            if (node.getLeft() == null) {
                node.setLeft(new Node(i));
            }
            else {
                node.setLeft(addNode(node.getLeft(), i));
            }
        }
        else if (i > node.getValue()) {
            if (node.getRight() == null) {
                node.setRight(new Node(i));
            }
            else {
                node.setRight(addNode(node.getRight(), i));
            }
            size++; //adds 1 to the size to keep track of the size of the list for the size method
        }
        return node;
    }

    public Node returnRoot() {
        return root;
    }






    public void delete(int val) { deleteRecursively(root,val); }
    public Node deleteRecursively(Node root, int value) {

        if (root == null)
            return root;

        if (value < (int) root.getValue()) {
            root.left = deleteRecursively(root.left, value);
        } else if (value > (int) root.getValue()) {
            root.right = deleteRecursively(root.right, value);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null)
                return root.left;

            root.setValue(inOrderSuccessor(root.right));
            root.right = deleteRecursively(root.right, (int) root.getValue());
        }

        return root;

    }

    public int inOrderSuccessor(Node root) {
        int num = root.getValue();
        while (root.left != null) {
            num = root.left.getValue();
            root = root.left;
        }
        return num;
    }




    public void preOrderTraversal() { preOrderTraversalRecursion(root); }
    public void preOrderTraversalRecursion(Node node) {
        if (node == null)
            return;

        System.out.print(node.getValue() + " "); //N
        preOrderTraversalRecursion(node.left); //L
        preOrderTraversalRecursion(node.right); //R
    }

    public int find(int i) {
        return TraversalFind(root, i);
    }
    public int TraversalFind(Node node, int i) {
        if(node != null){
            if(node.getValue() == i){
                return i;
            } else {
                int foundVal = 0;
                foundVal = TraversalFind(node.left,i);
                if(foundVal == 0) {
                    foundVal = TraversalFind(node.right,i);
                }
                return foundVal;
            }
        } else {
            return 0;
        }
    }
  /*  Queue queue = new LinkedList();
            queue.add(root);
            while (!queue.isEmpty()) {
        Node node = (Node) queue.remove();
        System.out.print(node.getValue() + " ");
        if (node.left != null) {
            queue.add(node.left);
        }

        if (node.right != null) {
            queue.add(node.right);
        }
    }

   /* Queue q = new LinkedList();

        q.add(node); //N
    TraversalFind(node.left, i); //L
    TraversalFind(node.right, i); //R
        for(int x=0; x<q.size();x++) {
        if(node.getValue() != i)
            q.remove(q.peek());
        else if(node.getValue() == i)
            return node.getValue() + 100; */





    public void postOrderTraversal() { postOrderTraversalRecursion(root); }
    public void postOrderTraversalRecursion(Node node) {
        if (node == null)// checks if tree is empty
            return;
        postOrderTraversalRecursion(node.left); //L
        postOrderTraversalRecursion(node.right); //R
        System.out.print(node.getValue() + " "); //N
    }


    public void breadthFirstSearchRecursion() {
        if(root == null){
            System.out.println("(Tree is Empty)");
            return;
        }
        Queue queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = (Node) queue.remove();
            System.out.print(node.getValue() + " ");
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    public void clear() {
        root = null;
    } //clears the tree by setting the root to null

    public void inOrderTraversal() { inOrderTraversalRecursion(root); }
    public void inOrderTraversalRecursion(Node node) {
        if (node == null)
            return;
        inOrderTraversalRecursion(node.left); //L
        System.out.print(node.getValue() + " "); //N
        inOrderTraversalRecursion(node.right); //R
    }

    public int size() {
        return size;
    }



    class Node {
        int value;
        Node right = null;
        Node left = null;

        void setValue(int x){
            value = x;
        }
        void setRight(Node x){
            right = x;
        }
        void setLeft(Node x){
            left = x;
        }
        Node getRight(){
            return  right;
        }
        Node getLeft(){
            return  left;
        }
        int getValue(){
            return value;
        }
        Node(int data){
            value = data;
        }
    }
}


