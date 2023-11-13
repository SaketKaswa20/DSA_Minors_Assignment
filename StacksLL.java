public class StacksLL {
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
        }
    }

    Node head= null;

    public void insert(int data){
        Node newNode= new Node(data);

        if (head==null){
            head=newNode;
        }else{
            newNode.next=head;
            head= newNode;
        }
    }

    public void display(){
        Node current= head;
        while (current!=null){
            System.out.println(current.data + " ");
            current=current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StacksLL stacks= new StacksLL();
        stacks.insert(1);
        stacks.insert(2);
        stacks.insert(3);
        stacks.insert(4);

        stacks.display();
    }
}
