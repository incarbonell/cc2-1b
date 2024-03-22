import java.util.*;
import java.util.stream.IntStream;

public class Pepino {
    public static class Node {
        int data;
        int height;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.height = 1; // Height of a new node is initially 1
            this.left = null;
            this.right = null;
        }
    }

    public Node root;
    private Set<Integer> uniqueElements = new HashSet<>();

    public Pepino() {
        root = null;
    }

    // Utility function to get the height of a node
    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Utility function to calculate the balance factor of a node
    private int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Utility function to update the height of a node
    private void updateHeight(Node node) {
        if (node != null)
            node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // Right rotate subtree rooted with y
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        updateHeight(y);
        updateHeight(x);

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with x
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        updateHeight(x);
        updateHeight(y);

        // Return new root
        return y;
    }

    // Insert a new node with given data
    public void insertUnique(int data) {
        if (uniqueElements.contains(data)) {
            System.out.println("Duplicate value: " + data);
            return;
        }
        root = insertUniqueHelper(root, data);
    }

    private Node insertUniqueHelper(Node node, int data) {
        // Perform standard BST insertion
        if (node == null) {
            uniqueElements.add(data);
            return new Node(data);
        }

        if (data < node.data)
            node.left = insertUniqueHelper(node.left, data);
        else if (data > node.data)
            node.right = insertUniqueHelper(node.right, data);
        else // Duplicate data not allowed
            return node;

        // Update height of this ancestor node
        updateHeight(node);

        // Get the balance factor of this ancestor node
        int balance = getBalance(node);

        // If this node becomes unbalanced, there are four cases

        // Left Left Case
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // return the (unchanged) node pointer
        return node;
    }

    // Method to delete a node with given value
    public Node deleteNode(Node node, int value) {
        if (node == null) {
            return null;
        } else {
            if (value < node.data)
                node.left = deleteNode(node.left, value);
            else if (value > node.data)
                node.right = deleteNode(node.right, value);
            else {
                if (node.left == null && node.right == null)
                    node = null;
                else if (node.left == null) {
                    node = node.right;
                } else if (node.right == null) {
                    node = node.left;
                } else {
                    Node temp = minNode(node.right);
                    node.data = temp.data;
                    node.right = deleteNode(node.right, temp.data);
                }
            }
            return node;
        }
    }

    // Utility method to find the node with minimum value
    public Node minNode(Node root) {
        if (root.left != null)
            return minNode(root.left);
        else
            return root;
    }

    // Method to perform inorder traversal and print unique elements
    public void inorderTraversalUnique(Node node) {
        if (node != null) {
            inorderTraversalUnique(node.left);
            if (uniqueElements.contains(node.data)) {
                System.out.print(node.data + " ");
            }
            inorderTraversalUnique(node.right);
        }
    }

    // Method to perform preorder traversal and print unique elements
    public void printPreorderUnique(Node node) {
        if (node != null) {
            if (uniqueElements.contains(node.data)) {
                System.out.print(node.data + " ");
            }
            printPreorderUnique(node.left);
            printPreorderUnique(node.right);
        }
    }

    // Method to perform postorder traversal and print unique elements
    public void printPostorderUnique(Node node) {
        if (node != null) {
            printPostorderUnique(node.left);
            printPostorderUnique(node.right);
            if (uniqueElements.contains(node.data)) {
                System.out.print(node.data + " ");
            }
        }
    }

    // Method to convert tree to array
    public int[] toArray(Node node) {
        List<Integer> list = new ArrayList<>();
        toArrayHelper(node, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void toArrayHelper(Node node, List<Integer> list) {
        if (node != null) {
            toArrayHelper(node.left, list);
            if (uniqueElements.contains(node.data)) {
                list.add(node.data);
            }
            toArrayHelper(node.right, list);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            Pepino avlTree = new Pepino(); // Create a new AVL tree for each iteration
            System.out.println("==============================");
            System.out.println("Type [1] to Insert");
            System.out.println("Type [2] to Delete");
            System.out.println("Type [3] to End");
            System.out.print("Choice:\t");
            char choice = scan.next().charAt(0);
            if (choice == '1') {
                while (true) {
                    System.out.print("Enter a number to insert (or type 'X' to stop inserting, 'D' to delete):\t");
                    String input = scan.next();
                    if (input.equals("X")) {
                        System.out.println("\n==============================");
                        // Display 1-D array representation with index
                        int[] arrayRepresentation = avlTree.toArray(avlTree.root);
                        System.out.print("1-D Array Representation: ");
                        for (int i = 0; i < arrayRepresentation.length; i++) {
                            if (avlTree.uniqueElements.contains(arrayRepresentation[i])) {
                                System.out.print(arrayRepresentation[i] + "  ");
                            }
                        }
                        System.out.println();
                        System.out.println("\t\t\t\t  Index: " + Arrays.toString(IntStream.range(0, arrayRepresentation.length).toArray()));
                        System.out.println("\n==============================");

                        System.out.println("Inorder traversal:");
                        System.out.print("[");
                        avlTree.inorderTraversalUnique(avlTree.root);
                        System.out.println("]");
                        // Display Preorder traversal
                        System.out.println("Preorder traversal:");
                        System.out.print("[");
                        avlTree.printPreorderUnique(avlTree.root);
                        System.out.println("]");

                        // Display Postorder traversal
                        System.out.println("Postorder traversal:");
                        System.out.print("[");
                        avlTree.printPostorderUnique(avlTree.root);
                        System.out.println("]");

                        System.out.print("Do you want to try again? (Type 'Y' to continue, any other input to end):\t");
                        char tryAgain = scan.next().charAt(0);
                        if (tryAgain != 'Y') {
                            break; // Exit the loop if the user does not want to try again
                        }
                    } else if (input.equals("D")) {
                        System.out.print("Enter the number to delete: ");
                        int numToDelete = scan.nextInt();
                        avlTree.root = avlTree.deleteNode(avlTree.root, numToDelete);
                    } else {
                        try {
                            int num = Integer.parseInt(input);
                            avlTree.insertUnique(num);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter an integer or 'X' to stop inserting, 'D' to delete.");
                        }
                    }
                }
            } else if (choice == '2') {
                System.out.print("Enter the number to delete: ");
                int numToDelete = scan.nextInt();
                avlTree.root = avlTree.deleteNode(avlTree.root, numToDelete);
            } else if (choice == '3') {
                break; // Exit the loop if the user chooses to end
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        System.out.println("Program ended.");
        scan.close(); // Close the scanner
    }
}