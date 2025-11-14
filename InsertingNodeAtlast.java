class Node{
    int data;
    Node next;

    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
}

class LinkedListL{
    Node head;

    public void InsertNodeAtEnd(int data){
        Node newNode=new Node(data,null);

        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void printNode(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class InsertingNodeAtlast {
    public static void main(String[] args){
        LinkedListL ln = new LinkedListL();
        ln.InsertNodeAtEnd(10);
        ln.InsertNodeAtEnd(20);
        ln.InsertNodeAtEnd(30);
        ln.InsertNodeAtEnd(40);

        ln.printNode();
    }
}
