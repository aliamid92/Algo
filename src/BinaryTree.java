public class BinaryTree {
    private String name;
    private Node root;

    public BinaryTree(String name) {
        this.name = name;
    }

    public Node getRoot() {
        return root;
    }


    //This method allows to add new Nodes to your BinaryTree
    // The first Node will be to the root
    public void addNode(Node node) {
        if (this.root == null) {
            this.root = node;
        } else {
            Node currentNode = root;
            Node parent;
            while (true) {
                parent = currentNode;
                if (node.key < currentNode.key) {

                    currentNode = currentNode.leftNode;
                    if (currentNode == null) {
                        parent.leftNode = node;
                        return;
                    }
                } else {
                    currentNode = currentNode.rightNode;
                    if (currentNode == null) {
                        parent.rightNode = node;
                        return;
                    }
                }
            }

        }
    }

    //This method will print the keys of nodes in your BinaryTree in ascending order on the terminal
    public void Print(Node node) {
        if (node != null) {

            Print(node.leftNode);
            System.out.println(node.key);
            Print(node.rightNode);

        }

    }

    //this method will find the Node the user is looking for and will return it
    //it also prints on the terminal whether it has been found

    public Node findNode(Node node) {
        Node currentNode = this.root;
        while (currentNode.key != node.key) {
            if (node.key < currentNode.key) {
                currentNode = currentNode.leftNode;
                if (currentNode == null) {
                    System.out.println("Node not found");
                    return null;
                }
            } else {
                currentNode = currentNode.rightNode;
                if (currentNode == null) {
                    System.out.println("Node not found");
                    return null;
                }
            }

        }
        System.out.println("Node found");
        return currentNode;
    }

    // this method will look for the node, and if it exists, it will be deleted
    // It will also return true or false

    public boolean deleteNode(Node node) {
        Node currentNode = this.root;
        Node parent = this.root;
        boolean IsItALeftNode = true;
        while (node.key != currentNode.key) {
            parent = currentNode;

            if (node.key < currentNode.key) {
                currentNode = currentNode.leftNode;
                IsItALeftNode = true;
            } else {
                currentNode = currentNode.rightNode;
                IsItALeftNode = false;

            }
            if (currentNode == null) {
                System.out.println("Node not found");
                return false;
            }
        }

        if (currentNode.leftNode == null && currentNode.rightNode == null) {
            if (currentNode == this.root) {
                this.root = null;
            } else if (IsItALeftNode) {
                parent.leftNode = null;
            } else {
                parent.rightNode = null;
            }
        } else if (currentNode.rightNode == null) {
            if (currentNode == this.root) {
                this.root = currentNode.leftNode;
            } else if (IsItALeftNode) {
                parent.leftNode = currentNode.leftNode;
            } else {
                parent.rightNode = currentNode.leftNode;
            }
        } else if (currentNode.leftNode == null) {
            if (currentNode == root) {
                this.root = currentNode.rightNode;
            } else if (IsItALeftNode) {
                parent.leftNode = currentNode.rightNode;
            } else {
                parent.rightNode = currentNode.rightNode;
            }
        } else {
            if (currentNode == this.root) {
                parent.leftNode = currentNode.rightNode;
            } else if (IsItALeftNode) {
                Node leftChild = currentNode.leftNode;
                parent.leftNode = currentNode.rightNode;
                parent.leftNode.leftNode = leftChild;
            } else {
                Node leftChild = currentNode.leftNode;
                parent.rightNode = currentNode.rightNode;
                parent.rightNode.leftNode = leftChild;
            }

        }
        return true;
    }

}

