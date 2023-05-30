public class AVLTree {
    private Node root;

    public static class Node{
        int key;
        int height;
        Node left;
        Node right;

        Node(int key){
            this.key = key;
        }
    }

    AVLTree(){}

    public Node getRoot(){return root;}

    void insert(int key){
        root = insertNode(root, key);
    }

    Node insertNode(Node node, int key){
        if(node == null){
            return new Node(key);
        }
        if( node.key > key )
            node.left = insertNode(node.left, key);
        else if (node.key < key) {
            node.right = insertNode(node.right,key);
        }
        else {
            throw new RuntimeException("Duplicate key!");
        }
        //incluya el balanceo del árbol
        return node;
    }

    Node balance(Node node){
        updateHeight(node);
        if (getBalance(node) < -1){
            if(height(node.left.left) < height(node.left.right)){
                System.out.printf(node.left.key + " is rotated left and ");
            }
            System.out.println(node.key + " is rotated right" );
        }
        else if(getBalance(node) > 1){
            if(height(node.right.right) < height(node.right.left)){
                System.out.print(node.right.key + " is rotated right and ");
            }
            System.out.println(node.key +" is rotated left");
        }
        return node;
    }


    Node rotateRight(Node n1) {
        //completar
        return n2;
    }

    Node rotateLeft(Node n1) {
        //completar
        return n2;
    }

    void deleteMin(){
        root = deleteMin(root);
    }
    Node deleteMin(Node node){
        if(node == null){
            return null;
        }
        //completar
        return balance(node);
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    private int getBalance(Node node){
        return (node == null) ? 0 :  height(node.right) - height(node.left);
    }


    static void preOrder(Node node) {
        if (node != null) {
            System.out.println("Key: " + node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        //initial tree
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(10);
        tree.insert(25);

        //LL
        tree.insert(5);

        //RL
        tree.insert(7);

        //RR
        tree.insert(60);
        tree.insert(70);

        //RL
        tree.insert(35);

        preOrder(tree.getRoot());

        tree.deleteMin(); //-5
        tree.deleteMin(); //-7
        System.out.println("After delete");
        preOrder(tree.getRoot());

    }
}
