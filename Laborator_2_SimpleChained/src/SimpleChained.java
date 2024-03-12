public class SimpleChained
{
    private Node first;


    public SimpleChained()
    {
        this.first=null;
    }

    public void add(Integer value)
    {
        if(this.first==null)
        {
            this.first=new Node(value);
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
        index++;
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


    public void sort1(Node newFirst)
    {
        Node parcurgere1 = first;
        while(parcurgere1!=null)
        {
            Node parcurgere2 = parcurgere1.getNext();

            while(parcurgere2!=null)
            {
                if(parcurgere1.getValue()>parcurgere2.getValue())
                {
                    boolean ok=false;
                    if(parcurgere1==first)
                        ok=true;

                    Node n1 =parcurgere1.getNext();
                    Node n2 =parcurgere2.getNext();
                    Node n3 =parcurgere1;
                    Node n4 =parcurgere2;

                    Node prevN1=first,prevn2=first;
                    while(prevN1!=parcurgere1)
                        prevN1=prevN1.getNext();

                    parcurgere1.setNext(parcurgere2.getNext());
                    parcurgere2.setNext(n1);

                    //if(ok==true)
                    //    sort1(parcurgere2);
                    //else
                    //    sort1(first);

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
