public class DoubleChained
{
    private Node first;
    private Node last;

    public DoubleChained()
    {
        this.first=null;
        this.last = null;
    }

    public void add(Integer value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrev(last);
            last = newNode;
        }
    }


    public Integer getSize() {
        Integer count = 0;
        Node current = first;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void remove(Integer index) {
        if (index >= 0 && index < this.getSize()) {
            Node current = first;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            if (current == first) {
                first = first.getNext();
                if (first != null) {
                    first.setPrev(null);
                }
            } else if (current == last) {
                last = last.getPrev();
                if (last != null) {
                    last.setNext(null);
                }
            } else {
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
            }
        } else {
            System.out.println("Index out of bounds!");
        }
    }

    public void sort()
    {
        Node parcurgere1 = first;
        while(parcurgere1!=null)
        {
            Node parcurgere2 = parcurgere1.getNext();

            while(parcurgere2!=null)
            {
                if(parcurgere1.getValue()>parcurgere2.getValue())
                {
                    Integer aux=parcurgere1.getValue();
                    parcurgere1.setValue(parcurgere2.getValue());
                    parcurgere2.setValue(aux);
                }
                parcurgere2=parcurgere2.getNext();
            }
            parcurgere1=parcurgere1.getNext();
        }
    }


    public void show() {
        Node current = first;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }



    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }
}
