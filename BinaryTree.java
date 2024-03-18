public class BinaryTree<E extends Comparable<E>> {

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;

        Node(E element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }

    private Node<E> root;

    public BinaryTree() {
        root = null;
    }

    public void insert(E element) {
        root = insertRec(root, element);
    }

    private Node<E> insertRec(Node<E> root, E element) {
        if (root == null) {
            root = new Node<>(element);
            return root;
        }
        if (element.compareTo(root.element) < 0) {
            root.left = insertRec(root.left, element);
        } else if (element.compareTo(root.element) > 0) {
            root.right = insertRec(root.right, element);
        }
        return root;
    }

    public E find(E target) {
        return findRec(root, target);
    }

    private E findRec(Node<E> root, E target) {
        if (root == null) {
            return null;
        }
        if (target.compareTo(root.element) < 0) {
            return findRec(root.left, target);
        } else if (target.compareTo(root.element) > 0) {
            return findRec(root.right, target);
        } else {
            return root.element; // target found
        }
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node<E> root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.element);
            inOrderRec(root.right);
        }
    }
}