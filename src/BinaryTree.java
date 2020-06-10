public class BinaryTree {
    private String name;
    private Node root;

    public BinaryTree(String name) {
        this.name = name;
    }

    public Node getRoot() {
        return root;
    }

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

    public void Print(Node node) {
        if (node != null) {

            Print(node.leftNode);
            System.out.println(node.key);
            Print(node.rightNode);

        }

    }

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

    public boolean deleteNode(Node node) {
        Node currentNode = this.root;
        Node parent = this.root;
        boolean IsItALeftChild = true;
        while (node.key != currentNode.key) {
            parent = currentNode;

            if (node.key < currentNode.key) {
                currentNode = currentNode.leftNode;
                IsItALeftChild = true;
            } else {
                currentNode = currentNode.rightNode;
                IsItALeftChild = false;

            }
            if (currentNode == null) {
                System.out.println("Node not found");
                return false;
            }
        }

        if (currentNode.leftNode == null && currentNode.rightNode == null) {
            if (currentNode == this.root) {
                this.root = null;
            } else if (IsItALeftChild) {
                parent.leftNode = null;
            } else {
                parent.rightNode = null;
            }
        } else if (currentNode.rightNode == null) {
            if (currentNode == this.root) {
                this.root = currentNode.leftNode;
            } else if (IsItALeftChild) {
                parent.leftNode = currentNode.leftNode;
            } else {
                parent.rightNode = currentNode.leftNode;
            }
        } else if (currentNode.leftNode == null) {
            if (currentNode == root) {
                this.root = currentNode.rightNode;
            } else if (IsItALeftChild) {
                parent.leftNode = currentNode.rightNode;
            } else {
                parent.rightNode = currentNode.rightNode;
            }
        } else {
            if (currentNode == this.root) {
                parent.leftNode = currentNode.rightNode;
            } else if (IsItALeftChild) {
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


//        Node currentNode = root;
//        Node parent;
//        while (true){
//            parent = currentNode;
//            if(node.key<currentNode.key){
//                currentNode=currentNode.leftNode;
//                if (currentNode.key==node.key){
//                    if ((currentNode.leftNode!=null) && (currentNode.rightNode!=null)){
//                        parent.leftNode=currentNode.rightNode;
//                        currentNode.rightNode.leftNode = currentNode.leftNode;
//                        return true;
//                    }else if ((currentNode.leftNode==null) && (currentNode.rightNode==null)){
//                        parent.leftNode = null;
//                        return true;
//                    }else if((currentNode.leftNode==null) && (currentNode.rightNode!=null)){
//                        parent.leftNode = currentNode.rightNode;
//                        return true;
//                    }else{
//                        parent.leftNode =currentNode.leftNode;
//                        return true;
//                    }
//                }
//            }else{
//                currentNode=currentNode.rightNode;
//                if (currentNode.key==node.key){
//                    if ((currentNode.leftNode!=null) && (currentNode.rightNode!=null)){
//                        parent.leftNode=currentNode.rightNode;
//                        currentNode.rightNode.leftNode = currentNode.leftNode;
//                        return true;
//                    }else if ((currentNode.leftNode==null) && (currentNode.rightNode==null)){
//
//                        parent.rightNode = null;
//                        return true;
//                    }else if((currentNode.leftNode==null) && (currentNode.rightNode!=null)){
//                        parent.leftNode = currentNode.rightNode;
//                        return true;
//                    }else{
//                        parent.leftNode =currentNode.leftNode;
//                        return true;
//                    }
//                }
//
//            }
//        }
}

