package com.company;



public class Main {

    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(20);
        bst.add(7);
        bst.add(2);
        bst.add(9);
        bst.add(3);
        bst.add(29);
        bst.add(21);
        System.out.print("Pre Order: ");
        bst.preOrderTraversal();
        System.out.println();
        System.out.print("Post Order: ");
        bst.postOrderTraversal();
        System.out.println();
        System.out.print("In Order: ");
        bst.inOrderTraversal();
        System.out.println();
        System.out.print("Breadth: ");
        bst.breadthFirstSearchRecursion();
        System.out.println();
        System.out.println("Find: " + bst.find(7));
        bst.delete(9);
        bst.breadthFirstSearchRecursion();
        System.out.println("");
        bst.clear();
        System.out.print("Breadth: ");
        bst.breadthFirstSearchRecursion();




    }
}


