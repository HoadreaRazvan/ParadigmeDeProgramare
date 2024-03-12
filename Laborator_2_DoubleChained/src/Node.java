public class Node
{
    private Integer value;
    private Node next,prev;

    public Node(Integer value)
    {
        this.value=value;
        this.next=null;
        this.prev=null;
    }
    public Integer getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
