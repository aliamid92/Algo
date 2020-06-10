import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static BinaryTree binaryTree;
    public static void main(String[] args) {
	    Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        binaryTree = new BinaryTree("binarytree");
        binaryTree.addNode(node5);
        binaryTree.addNode(node2);
        binaryTree.addNode(node7);
        binaryTree.addNode(node1);
        binaryTree.addNode(node3);
        binaryTree.addNode(node6);
//        binaryTree.addNode(node7);
        binaryTree.addNode(node8);
        binaryTree.addNode(node4);

        binaryTree.Print(binaryTree.getRoot());
//
        System.out.println("=============================");
        System.out.println(binaryTree.getRoot().leftNode.leftNode.key +" " + binaryTree.getRoot().leftNode.rightNode.key);

//        binaryTree.deleteNode(node3);
//        binaryTree.deleteNode(node7);
//        binaryTree.deleteNode(node6);
//        binaryTree.deleteNode(node4);
//        binaryTree.deleteNode(node1);
//        binaryTree.Print(binaryTree.getRoot());
//        System.out.println("=====================");
//
//        Node node12 = new Node(12);
//        binaryTree.addNode(node12);
//        binaryTree.Print(binaryTree.getRoot());
        System.out.println("===============");
        String data =getDotFile(binaryTree);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("tree.gv"));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    public static String getDotFile(BinaryTree t){
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {\n");
        sb.append("graph [ dpi = 150 ]\n");
        sb.append("nodesep=0.3;\n");
        sb.append("ranksep=0.2;\n");
        sb.append("margin=0.1;\n");
        sb.append("node [shape=circle];\n");
        sb.append("edge [arrowsize=0.8];\n");

        StringBuilder treeContent = getDotTreeContent(new StringBuilder(), binaryTree.getRoot(), 1);
        sb.append(treeContent);

        sb.append("}");

        return sb.toString();
    }

    // Pre: N is not null.
// This won't work for larger unbalanced trees (int overflow), but then again you probably
// wouldn't be displaying them anyway, so this is good enough for now.
    private static StringBuilder getDotTreeContent(StringBuilder sb, Node n, int i){
        sb.append(String.format("node%d [label=\"%d\"];\n", i, n.key));
        int lChild = 2*i;
        int rChild = 2*i + 1;

        if(n.leftNode  != null){
            sb.append(String.format("node%d -> node%d;\n", i, lChild));
            getDotTreeContent(sb, n.leftNode, lChild);
        }
        if(n.rightNode != null){
            sb.append(String.format("node%d -> node%d;\n", i, rChild));
            getDotTreeContent(sb, n.rightNode, rChild);
        }
        return sb;
    }
}
