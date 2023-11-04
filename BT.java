import java.util.LinkedList;
import java.util.Queue;
public class BT {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
        Node root=null;

        // 1. Insertion in a Binary Tree in level order
        public void insert(int key) {
            Node newNode = new Node(key);

            if (root == null) {
                root = newNode;
                return;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                if (current.left == null) {
                    current.left = newNode;
                    return;
                } else {
                    queue.add(current.left);
                }

                if (current.right == null) {
                    current.right = newNode;
                    return;
                } else {
                    queue.add(current.right);
                }
            }
        }

        // 2. Deletion in a Binary Tree (Shrinking from the Bottom)
        public void delete(int key) {
            if (root == null) {
                return;
            }

            Node deepest = null;
            Node keyNode = null;
            Node parentOfDeepest = null;
            Node parentOfKey = null;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                deepest = queue.poll();

                if (deepest.left != null) {
                    parentOfDeepest = deepest;
                    queue.add(deepest.left);
                }

                if (deepest.right != null) {
                    parentOfDeepest = deepest;
                    queue.add(deepest.right);
                }

                if (deepest.data == key) {
                    keyNode = deepest;
                    parentOfKey = parentOfDeepest;
                }
            }

            if (keyNode != null) {
                int temp = deepest.data;
                deleteDeepest(deepest, parentOfDeepest);
                keyNode.data = temp;
            }
        }

        private void deleteDeepest(Node deleteNode, Node parentOfDeleteNode) {
            if (deleteNode == root) {
                root = null;
                return;
            }

            if (parentOfDeleteNode.left == deleteNode) {
                parentOfDeleteNode.left = null;
            } else {
                parentOfDeleteNode.right = null;
            }
        }

        public void inorderTraversal(Node node) {
            if (node == null) {
                return;
            }

            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }

        public static void main(String[] args) {
            BT tree = new BT();

            tree.insert(1);
            tree.insert(2);
            tree.insert(3);
            tree.insert(4);
            tree.insert(5);

            System.out.println("Inorder Traversal before deletion:");
            tree.inorderTraversal(tree.root);

            int keyToDelete = 3;
            tree.delete(keyToDelete);

            System.out.println("\nInorder Traversal after deletion of node with data " + keyToDelete + ":");
            tree.inorderTraversal(tree.root);
        }
}
