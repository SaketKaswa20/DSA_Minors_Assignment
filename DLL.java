public class DLL {
    class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data=data;
        }
    }

    Node head, tail= null;
    public void addNode(int data){
        Node newNode= new Node(data);

        if (head==null){
            head= tail= newNode;
            head.prev=null;
            tail.next=null;
        }
        else{
            tail.next= newNode;
            newNode.prev= tail;
            tail= newNode;
            tail.next=null;
        }
    }

    public void display(){
        Node current= head;

        if (current==null){
            System.out.println("List is Empty");
        }
        while (current!=null){
            System.out.print(current.data + " ");
            current=current.next;
        }
        System.out.println();
    }

    public int size(){
        int count=0;
        Node current= head;
        while (current != null){
            count++;
            current=current.next;
        }
        System.out.println(count);
        return count;
    }

    public int get(int index){
        int count = 0;
        Node current= head;
        while(count<index){
            count++;
            current=current.next;
        }
        if(count==index){
            System.out.println(current.data);
            return current.data;
        }
        return 0;
    }

    public void add(int index, int data){
        Node newNode= new Node(data);
        Node current= head;
        Node prev= null;
        while (index>0 && current!=null){
            prev=current;
            current=current.next;
            index--;
        }
        prev.next= newNode;
        newNode.next=current;
    }

    public void insertSorted(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else if (data < head.data) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node current = head;
            while (current != null && current.data < data) {
                current = current.next;
            }
            if (current == null) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                Node prev = current.prev;
                prev.next = newNode;
                newNode.prev = prev;
                newNode.next = current;
                current.prev = newNode;
            }
        }
    }

    public void InsertionSort() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            DLL sortedList = new DLL(); // Create a new list to store the sorted elements

            Node current = head;
            while (current != null) {
                Node next = current.next;

                // Insert the current node into the sorted list
                sortedList.insertSorted(current.data);

                current = next;
            }

            // Update the head and tail pointers of the current list
            head = sortedList.head;
            tail = sortedList.tail;
        }
    }

    public static void main(String[] args) {
        DLL list= new DLL();
        list.addNode(11);
        list.addNode(2);
        list.addNode(3);

        System.out.println("Original List: ");
        list.display();
        list.InsertionSort();
        System.out.println("After Insertion Sort :");
        list.display();

    }
}
