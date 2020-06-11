import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {


    public static void main(String[] args) {

	    //Create Nodes for our BinaryTree
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        //Create a new BinaryTree Object, and add any node from the above
        //The first Node you add to the BinaryTree will be the root

        BinaryTree binaryTree = new BinaryTree("binarytree");
        binaryTree.addNode(node5);
        binaryTree.addNode(node2);
        binaryTree.addNode(node7);
        binaryTree.addNode(node1);
        binaryTree.addNode(node3);
        binaryTree.addNode(node6);
//        binaryTree.addNode(node7);
        binaryTree.addNode(node8);
        binaryTree.addNode(node4);
        //Use Print() method of BinaryTree class to print the keys of nodes on the terminal in ascending order.
        binaryTree.Print(binaryTree.getRoot());
        System.out.println("=============================");
        // Use deleteNode() method of BinaryTree class to remove a Node from the tree

//        binaryTree.deleteNode(node3);
//        binaryTree.deleteNode(node7);
//        binaryTree.deleteNode(node6);
//        binaryTree.deleteNode(node4);
//        binaryTree.deleteNode(node1);
//        binaryTree.Print(binaryTree.getRoot());
//        System.out.println("=====================");
        //Use find() method of BinaryTree class to find a Node in the BinaryTree
//
//        Node node12 = new Node(12);
//        binaryTree.addNode(node12);
//        binaryTree.Print(binaryTree.getRoot());
        System.out.println("===============");
        printBST(binaryTree);





    }


    // this method will go through the BinaryTree and will create tree.gv file in the directory
    public static void printBST(BinaryTree tree){
        String BSTDescription = BSTtoString(tree);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("tree.gv"));
            writer.write(BSTDescription);
            writer.close();
            System.out.println("tree.gv file has been created");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private static String BSTtoString(BinaryTree tree){
        StringBuilder BSTStatement = new StringBuilder();
        BSTStatement.append("digraph G {\n");
        BSTStatement.append("graph [ dpi = 200 ]\n");
        BSTStatement.append("node [fontname=Arial ];\n");
        BSTStatement.append("node [shape=circle];\n");
        BSTStatement.append("edge [arrowsize=1];\n");

        StringBuilder treeContent = getTreeContent(new StringBuilder(), tree.getRoot(), 1);
        BSTStatement.append(treeContent);

        BSTStatement.append("}");
        String BSTStatementToString =BSTStatement.toString();

        return BSTStatementToString;
    }


    private static StringBuilder getTreeContent(StringBuilder BSTStatement, Node node, int nodeIdentifier){
        BSTStatement.append(String.format("node%d [label=\"%d\"];\n", nodeIdentifier, node.key));
        int rightNode = (2*nodeIdentifier) + 1;
        int leftNode = 2*nodeIdentifier;


        if(node.leftNode  != null){
            BSTStatement.append(String.format("node%d -> node%d;\n", nodeIdentifier, leftNode));
            getTreeContent(BSTStatement, node.leftNode, leftNode);
        }
        if(node.rightNode != null){
            BSTStatement.append(String.format("node%d -> node%d;\n", nodeIdentifier, rightNode));
            getTreeContent(BSTStatement, node.rightNode, rightNode);
        }
        return BSTStatement;
    }
}
