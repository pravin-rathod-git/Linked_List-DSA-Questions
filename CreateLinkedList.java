class Node{
    int data;
    Node next;
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }

}

 class LinkedList{
    Node head;
    public void IsertingNodeAtBeginning(int data){
        Node newNode=new Node(data,null);
        newNode.next=head;
        head=newNode;
    }

    public void printLinkedList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data +"->");
            temp=temp.next;
        }
        System.out.println("null");
    
    }
}

public class CreateLinkedList{
    public static void main(String[] args){
        LinkedList ln=new LinkedList();
        ln.IsertingNodeAtBeginning(10);
        ln.IsertingNodeAtBeginning(20);
        ln.IsertingNodeAtBeginning(30);
        ln.IsertingNodeAtBeginning(40);


        ln.printLinkedList();
    }
}