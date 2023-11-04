public class CircularLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

     Node head=null;

        // 1. Traversing the Circular Singly Linked List
        public void traverse() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            Node current = head;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);
            System.out.println();
        }

        // 2. Insertion of a Node at the Beginning of the List
        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                newNode.next = head;
            } else {
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                newNode.next = head;
                head = newNode;
                current.next = head;
            }
        }

        // 3. Insertion of a Node at the End of the List
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                newNode.next = head;
            } else {
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = newNode;
                newNode.next = head;
            }
        }

        // 4. Insertion of a New Node at the Given Position
        public void insertAtPosition(int data, int position) {
            if (position <= 0) {
                System.out.println("Invalid position.");
                return;
            }
            Node newNode = new Node(data);
            if (position == 1) {
                insertAtBeginning(data);
            } else {
                Node current = head;
                int count = 1;
                while (count < position - 1 && current.next != head) {
                    current = current.next;
                    count++;
                }
                if (count == position - 1) {
                    newNode.next = current.next;
                    current.next = newNode;
                } else {
                    System.out.println("Invalid position.");
                }
            }
        }

        // 5. Deletion of a Node from the Beginning of the List
        public void deleteFromBeginning() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            if (head.next == head) {
                head = null;
            } else {
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                head = head.next;
                current.next = head;
            }
        }

        // 6. Deletion of a Node from the End of the List
        public void deleteFromEnd() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            if (head.next == head) {
                head = null;
            } else {
                Node current = head;
                Node prev = null;
                while (current.next != head) {
                    prev = current;
                    current = current.next;
                }
                prev.next = head;
            }
        }

        // 7. Deletion of a Node from the Given Position
        public void deleteFromPosition(int position) {
            if (position <= 0) {
                System.out.println("Invalid position.");
                return;
            }

            if (position == 1) {
                deleteFromBeginning();
            } else {
                Node current = head;
                int count = 1;
                while (count < position - 1 && current.next != head) {
                    current = current.next;
                    count++;
                }
                if (count == position - 1 && current.next != head) {
                    current.next = current.next.next;
                } else {
                    System.out.println("Invalid position.");
                }
            }
        }

        // 8. Search a Node Data in the List
        public boolean search(int data) {
            if (head == null) {
                return false;
            }
            Node current = head;
            do {
                if (current.data == data) {
                    return true;
                }
                current = current.next;
            } while (current != head);
            return false;
        }

        // 9. Update a Node Data
        public void update(int oldData, int newData) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            Node current = head;
            do {
                if (current.data == oldData) {
                    current.data = newData;
                    return;
                }
                current = current.next;
            } while (current != head);
            System.out.println("Data not found.");
        }

    public static void main(String[] args) {
        CircularLL list = new CircularLL();

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);

        list.traverse();

        list.insertAtBeginning(0);
        list.traverse();

        list.insertAtPosition(5, 5);
        list.traverse();

        list.deleteFromBeginning();
        list.traverse();

        list.deleteFromEnd();
        list.traverse();

        list.deleteFromPosition(3);
        list.traverse();

        list.update(2, 6);
        list.traverse();
    }
}
