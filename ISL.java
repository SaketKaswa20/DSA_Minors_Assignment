public class ISL {
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
            head=tail=newNode;
            head.prev=null;
            tail.next=null;
        }
        else {
            tail.next=newNode;
            newNode.prev=tail;
            tail= newNode;
            tail.next=null;
        }
    }

    public void displayForward(){
        Node current= head;
        if (head==null){
            System.out.println("List is Empty");
        }
        while (current!=null){
            System.out.print(current.data+ " ");
            current=current.next;
        }
        System.out.println();
    }

    public void displayBackward(){
        Node current= tail;
        if (head==null){
            System.out.println("List is Empty");
        }
        while (current!=null){
            System.out.print(current.data+ " ");
            current=current.prev;
        }
        System.out.println();
    }

    public void InsertionSort(){
        if (head==null){
            System.out.println("List is Empty");
            return;
        }

        Node current= head;
        while (current!=null){
            int key= current.data;
            Node prev= current.prev;

            while (prev!=null && prev.data>key){
                prev.next.data=prev.data;
                prev=prev.prev;
            }

            if (prev==null){
                head.data=key;
            }
            else {
                prev.next.data= key;
            }

            current=current.next;
        }
    }

    public static void main(String[] args) {
        ISL list= new ISL();
        list.addNode(56);
        list.addNode(1);
        list.addNode(11);
        list.addNode(2);

        list.InsertionSort();
        list.displayForward();
        list.displayBackward();
    }

}
