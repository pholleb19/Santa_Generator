public class ListNode2 {
    private String value;
    private ListNode2 nextNode;
    private String email;
    private String mySanta;


    public ListNode2(String v){
        value = v;
        nextNode = null;
        email = null;
    }
    public ListNode2(String v, String e, ListNode2 n){
        value = v;
        email = e;
        nextNode = n;

    }
    public String getValue(){
        return value;
    }
    public String getEmail() { return email; }
    public ListNode2 getNextNode(){
        return nextNode;
    }
    public void setValue(String c){
        value = c;
    }
    public void setNextNode(ListNode2 l){
        nextNode = l;
    }
    public void setEmail(String e){
        email = e;
    }
    public void setSanta(String s){
        mySanta = s;
    }
    public String getSanta(){
        return mySanta;
    }


}
