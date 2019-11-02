//Dan Chovanes

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char choice = ' ';

        while (choice != 'e') {
            System.out.println("Enter a depth to be populated");
            int depth = scan.nextInt() - 1;

            BinaryTree tree = new BinaryTree();
            Node root = tree.root;

            tree.populateTree(3, 2, 1, tree.root, depth - 1);

            System.out.println("\n1.) Pre-order traversal: \n2.) In-order traversal: \n3.) Post-order traversal: \n");
            int traverseType = scan.nextInt();

            switch (traverseType) {
                case 1:
                    tree.preOrder(root);
                    break;
                case 2:
                    tree.inOrder(root);
                    break;
                case 3:
                    tree.postOrder(root);
                    break;
            }

            System.out.println();
            tree.printMissing(depth);

            System.out.println();
            System.out.println("\nEnter 'e' to exit, or any key to run again");
            choice = scan.next().charAt(0);
        }
    }
}
