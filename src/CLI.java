import java.util.Scanner;

public class CLI {
    public static void main(String[] args){
        String name = " ";
        String email = " ";

        int n = 0;
        DoublyLinkedList l = new DoublyLinkedList();
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a name hit enter then enter their email. Enter s to create pairings");
        while(true){
            System.out.println("enter name or s to create pairing");
            name = console.nextLine();
            if(name.equals("s")){
                l.generateSantas();
                break;
            }
            System.out.println("enter email");
            email = console.nextLine();
            ListNode2 next = new ListNode2(name, email, null);
            l.add(next);
        }
    }
}
