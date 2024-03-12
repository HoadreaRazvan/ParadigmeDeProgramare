public class DoubleChained
{
    private Node first;


    public DoubleChained()
    {
        this.first=null;
    }

    public void add(Integer value)
    {
        if(this.first==null)
        {
            this.first=new Node(value);
            this.first.setNext(null);
        }
        else
        {
            Node newNode = new Node(value);
            Node parcurgere = first;
            while(parcurgere.getNext()!=null)
                parcurgere=parcurgere.getNext();
            parcurgere.setNext(newNode);
        }
    }

    public Integer getSize()
    {
        Integer ct=0;
        Node parcurgere = first;
        while(parcurgere!=null)
        {
            ct++;
            parcurgere=parcurgere.getNext();
        }
        return ct;
    }

    public void remove(Integer index)
    {
        if(index>=1 && index<=this.getSize()) {
            Node parcurgere = first;
            if (index == 1)
                this.first = first.getNext();
            else
            {
                Integer ct = 2;
                while (parcurgere != null && ct++ != index)
                    parcurgere = parcurgere.getNext();
                parcurgere.setNext(parcurgere.getNext().getNext());
            }
        }
        else
            System.out.println("Out of index!");

    }


    public void sort()
    {
        Node parcurgere1 = first;
        while(parcurgere1!=null)
        {
            Node parcurgere2 = first;

            while(parcurgere2!=null)
            {

                if(parcurgere2.getValue()>parcurgere1.getValue())
                {
                    Integer aux=parcurgere2.getValue();
                    parcurgere2.setValue(parcurgere1.getValue());
                    parcurgere1.setValue(aux);
                }
                parcurgere2=parcurgere2.getNext();
            }
            parcurgere1=parcurgere1.getNext();
        }
    }

    public void show()
    {
        Node parcurgere = first;
        while(parcurgere!=null)
        {
            System.out.printf(parcurgere.getValue()+" ");
            parcurgere=parcurgere.getNext();
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
