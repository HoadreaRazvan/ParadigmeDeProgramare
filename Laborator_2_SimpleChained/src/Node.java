public class Node
{
private Integer value;
private Node next;

    public Node(Integer value)
    {
        this.value=value;
        this.next=null;
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
}
