//Dan Chovanes
//BinaryTree class from GeeksForGeeks


public class BinaryTree {

    int MAX = 900000;
    Node root = new Node(3);
    public int[] counter = new int[MAX];

    //----------------------------------------------------------------------------------

    BinaryTree() {

        counter[1] = 1;
        counter[2] = 1;
        counter[3] = 1;

        for (int i = 4; i<MAX; i++) {
            counter[i] = 0;
        } // set our first 3 values manually, then initialize the rest of the array to 0
    }
    //----------------------------------------------------------------------------------

    public void printMissing(int depth) {

        for (int i = 1; i < calcLargest(depth); i++) {
            if (counter[i] == 0)
                System.out.println("Missing " + i);
        }

        System.out.println();

        for (int i = 1; i < calcLargest(depth)+1; i++) {
            System.out.println(i + ": " + counter[i]);
        }
    }

    //----------------------------------------------------------------------------------

    public void populateTree(int curr, int prev, int grandPar, Node parent, int depth) {

        Node leftNode = new Node();
        leftNode.key = curr + grandPar;
        counter[leftNode.key]++;
        parent.left = leftNode;

        Node rightNode = new Node();
        rightNode.key = curr + prev;
        counter[rightNode.key]++;
        parent.right = rightNode;

        if (depth > 0) {
                populateTree(curr + grandPar, curr, prev, parent.left, depth - 1);
                populateTree(curr + prev, curr, prev, parent.right, depth - 1);
        }
    }

    //----------------------------------------------------------------------------------

    public int calcLargest(int depth) {

        int result=0, first=1, second=1;

        for (int i=0; i<=depth+1; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    //----------------------------------------------------------------------------------

    void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + " ");
    }
    //----------------------------------------------------------------------------------

    void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }
    //----------------------------------------------------------------------------------

    void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
