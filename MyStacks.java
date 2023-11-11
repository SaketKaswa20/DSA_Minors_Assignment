//Creating Stacks using Arrays
public class MyStacks {
    private int[] items;
    private int top;
    private int size;

    public MyStacks(int size){
        this.size=size;
        this.items= new int[size];
        this.top=0;
    }

    public void push(int value){
        if (top==size-1){
            System.out.println("Stack is Full");
            return;
        }
        this.items[this.top]= value;
        this.top++;
    }

    public String toString(){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=size-1; i>=0; i--){
            stringBuilder.append(items[i]).append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyStacks stacks= new MyStacks(5);
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);

        System.out.println(stacks.toString());
    }
}
