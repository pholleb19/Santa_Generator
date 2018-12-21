import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class DoublyLinkedList implements Iterable<String>{
    private ListNode2 head;
    private ListNode2 tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;

    }
    public DoublyLinkedList(Object[] values) {

        for(int i = 1; i<values.length; i++){

        }
        size = values.length;
    }
    public void add(ListNode2 value) { // adds to the end of the list
        if(head == null){
            head = value;
            return;
        }

        ListNode2 curr = head;
        for(int i = 0; i<size-1 ; i ++){
            curr = curr.getNextNode();
        }
        curr.setNextNode(value);
        tail = curr;
        size++;
    }
    public void add(Object value, int i) { // adds element at index i
        for(int j = 0; j<size; j++){
            if(j==i){

            }
        }
    }
    public void remove(ListNode2 re){
        if(re == head){
            head = head.getNextNode();
            return;
        }
        getPrevious(re).setNextNode(re.getNextNode());
        re.setNextNode(null);
    }
    public ListNode2 getPrevious(ListNode2 l){
        ListNode2 temp = head;
        if(l == head){
            return null;
        }
        while(temp.getNextNode() != l){
            temp = temp.getNextNode();
        }
        return l;
    }
    public ListNode2 getHead(){
        return head;
    }

    public void generateSantas() {
        try{
            ListNode2 curr = this.getHead();
            ArrayList<String> copy = new ArrayList<String>();
            for(String s: this){
                copy.add(s);
            }
            DoublyLinkedList copyl = new DoublyLinkedList();
            PrintWriter writer = new PrintWriter("santaPairings.txt", "UTF-8");
            while(!copy.isEmpty()){
                Random rand = new Random();
                int r = rand.nextInt(copy.size());
                ListNode2 temp = new ListNode2(copy.remove(r));
                copyl.add(temp);

                //writer.println(curr.getValue() + " gives to " + copy.remove(r));
            }
            ListNode2 ite = copyl.getHead();
            while(ite.getNextNode()!=null){
                writer.println(ite.getValue() + " gives to " + ite.getNextNode().getValue());
                ite =ite.getNextNode();
            }
            writer.println(ite.getValue() + " gives to " + copyl.getHead().getValue());
            writer.close();
        }
        catch(FileNotFoundException e){}
        catch(UnsupportedEncodingException p){}

    }
    public Iterator<String> iterator() {
        return new DoublyLinkedList.SLLIterator(head);
    }
    private class SLLIterator implements Iterator<String> {
        private ListNode2 nextNode;
        public SLLIterator(ListNode2 head){
            nextNode = head;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public String next() {
            if (nextNode == null)
                throw new NoSuchElementException();
            String value = nextNode.getValue();
            nextNode = nextNode.getNextNode();
            return value;
        }
    }
}
