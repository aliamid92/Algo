import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/** Note: In order to create .gv file, we followed the approach given by from Francesco Andreussi
 * in the Forum and the website https://rafal.io/posts/binary-trees.html#visualizing-a-tree-with-dotgraphviz
 * just to get an overall Idea on how to add new statements to the String variable.
 * the idea of creating a boolean value in delete() method in the BinaryTree to make the code shorter is derived from
 * Derek Banas YouTube channel.

*/

public class Main {


    // In this method, the user can manipulate the BinaryTree
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
        binaryTree.addNode(node8);
        binaryTree.addNode(node4);
        //Use Print() method of BinaryTree class to print the keys of nodes on the terminal in ascending order.
        binaryTree.Print(binaryTree.getRoot());
        System.out.println("=============================");
        // Use deleteNode() method of BinaryTree class to remove a Node from the tree

//        binaryTree.deleteNode(node3);

        //Use find() method of BinaryTree class to find a Node in the BinaryTree
//        binaryTree.findNode(node7);

        //Use printBST() method to go through the BinaryTree and to create tree.gv file in the directory
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


    // this method will write .dot language and describe the overall structure of .gv file
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


    // this method will go through the BinaryTree and add Nodes in .dot language to the.gv file
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
