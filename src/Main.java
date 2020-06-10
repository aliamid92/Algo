public class Main {

    public static void main(String[] args) {
	    Node node1 = new Node(1);
        Node node2 = new Node(6);
        Node node3 = new Node(5);
        Node node4 = new Node(8);
        Node node5 = new Node(0);
        Node node6 = new Node(9);
        Node node7 = new Node(2);
        Node node8 = new Node(3);
        Node node9 = new Node(10);

        BinaryTree binaryTree = new BinaryTree("binarytree");
        binaryTree.addNode(node2);
        binaryTree.addNode(node1);
        binaryTree.addNode(node3);
        binaryTree.addNode(node4);
        binaryTree.addNode(node5);
        binaryTree.addNode(node6);
        binaryTree.addNode(node7);
        binaryTree.addNode(node8);
        binaryTree.addNode(node9);

        binaryTree.Print(binaryTree.getRoot());
//
        System.out.println("=============================");

        binaryTree.deleteNode(node8);
        binaryTree.deleteNode(node5);
        binaryTree.deleteNode(node6);
        binaryTree.deleteNode(node4);
        binaryTree.deleteNode(node1);
        binaryTree.Print(binaryTree.getRoot());
        System.out.println("=====================");

        Node node12 = new Node(12);
        binaryTree.addNode(node12);
        binaryTree.Print(binaryTree.getRoot());




    }
}
