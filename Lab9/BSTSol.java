public class BST {
    Node root;

    BST() {
        root = null;
    }
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    void insert(int data) {
        root = insertNode(root, data);
    }

    Node insertNode(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        }
        if (data < node.data)
            node.left = insertNode(node.left, data);
        else if (data > node.data)
            node.right = insertNode(node.right, data);
        return node;
    }

    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    //Método InOrden inverso
    void inOrderInverse(Node node) {
        if (node != null) {
            inOrderInverse(node.right);
            System.out.print(node.data + " ");
            inOrderInverse(node.left);
        }
    }

    //Imprimir la mitad izquierda del árbol
    void printLeftHalf(Node node) {
        if (node != null) {
            printLeftHalf(node.left);
            if(node != root){
                System.out.print(node.data + " ");
                printLeftHalf(node.right);
            }

        }
    }

    //Imprimir la mitad izquierda del árbol (opción 2)
    void printLeftHalf2() {
        if (root != null) {
            inOrder(root.left);
        }
    }


    //Imprimir solo los nodes con elemento impar
    void printOddNodes() {
        printOddNodesRecursive(root);
    }

    void printOddNodesRecursive(Node node) {
        if (node != null) {
            printOddNodesRecursive(node.left);
            if ((node.data % 2) != 0) {
                System.out.print(node.data + " ");
            }
            printOddNodesRecursive(node.right);
        }
    }



    //MAIN LISTO PARA EJECUTAR
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(61);
        tree.insert(85);
        tree.insert(5);
        tree.insert(7);
        tree.insert(90);

        System.out.println("Recorrido inorden del árbol binario:");
        tree.inOrder(tree.root);

        System.out.println("\n\nRecorrido preorden del árbol binario:");
        tree.preOrder(tree.root);

        System.out.println("\n\nRecorrido postorden del árbol binario:");
        tree.postOrder(tree.root);

        //TEST DE LOS MÉTODOS SOLICITADOS
        System.out.println("\n\nRecorrido inorden inverso del árbol binario:");
        tree.inOrderInverse(tree.root);

        System.out.println("\n\nMitad izquierda del árbol binario:");
        tree.printLeftHalf(tree.root);

        System.out.println("\n\nNodes impares del árbol binario:");
        tree.printOddNodes();

    }
}
