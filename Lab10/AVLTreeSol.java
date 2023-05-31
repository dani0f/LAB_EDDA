public class AVLTreeSol {
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

    AVLTreeSol(){}

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
        return balance(node);
    }

    Node balance(Node node){
        updateHeight(node);
        if (getBalance(node) < -1){
            if(height(node.left.left) < height(node.left.right)){
                System.out.printf(node.left.key + " is rotated left and ");
                node.left = rotateLeft(node.left);

            }
            System.out.println(node.key + " is rotated right" );
            node = rotateRight(node);
        }
        else if(getBalance(node) > 1){
            if(height(node.right.right) < height(node.right.left)){
                System.out.print(node.right.key + " is rotated right and ");
                node.right = rotateRight(node.right);
            }
            System.out.println(node.key +" is rotated left");
            node = rotateLeft(node);
        }
        return node;
    }


    Node rotateRight(Node n1) {
        Node n2 = n1.left;
        Node n3 = n2.right;
        n2.right = n1;
        n1.left = n3;
        updateHeight(n1);
        updateHeight(n2);
        return n2;
    }

    Node rotateLeft(Node n1) {
        Node n2 = n1.right;
        Node n3 = n2.left;
        n2.left = n1;
        n1.right = n3;
        updateHeight(n1);
        updateHeight(n2);
        return n2;
    }

    void deleteMin(){
        root = deleteMin(root);
    }
    Node deleteMin(Node node){
        if(node == null){
            return null;
        }
        if(node.left == null){
            return node.right;
        }
        node.left = deleteMin(node.left);
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
        AVLTreeSol tree = new AVLTreeSol();


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

        tree.deleteMin(); //5
        tree.deleteMin(); //7
        System.out.println("After delete");
        preOrder(tree.getRoot());

    }
}
