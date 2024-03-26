import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //d

        //1
        for(int i=0;i<5;i++)
            x.add((int)(Math.random()*10));

        for(int i=0;i<7;i++)
            y.add((int)(Math.random()*10));

        x.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2)
                    return 1;
                else
                    return -1;
            }
        });
        y.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2)
                    return 1;
                else
                    return -1;
            }
        });
        for(int i=0;i<5;i++)
            System.out.println(x.get(i));

        //a
        for(int i=0;i<5;i++)
            xPlusY.add(x.get(i));
        for(int i=0;i<7;i++)
            xPlusY.add(y.get(i));


        //b
        for(int i=0;i<5;i++)
        for(int j=0;j<7;j++)
        {
            if(x.get(i).equals(y.get(j))==true)
            {
                zSet.add(x.get(i));
            }
        }

        //c
        for(int i=0;i<5;i++)
            for(int j=0;j<7;j++)
            {
                if(x.get(i).equals(y.get(j))==false)
                {
                    xMinusY.add(x.get(i));
                }
            }

        //d
        for(int i=0;i<5;i++)
            if(x.get(i)<=p)
            xPlusY.add(x.get(i));
        for(int i=0;i<7;i++)
            if(y.get(i)<=p)
                xPlusY.add(y.get(i));


        //2
        List<Student> listaStudenti = new ArrayList<Student>();

        listaStudenti.add(new Student("Razvan",233,new ArrayList<Integer>(Arrays.asList((int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10)))));
        listaStudenti.add(new Student("Hoadrea",533,new ArrayList<Integer>(Arrays.asList((int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10)))));
        listaStudenti.add(new Student("Bucur",133,new ArrayList<Integer>(Arrays.asList((int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10)))));
        listaStudenti.add(new Student("Ana",223,new ArrayList<Integer>(Arrays.asList((int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10),(int)(Math.random()*10)))));

        for(Student s: listaStudenti)
            System.out.println(s.toString());
        System.out.println("\n\n");


        Collections.sort(listaStudenti, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getGrupa()>o2.getGrupa())
                    return 1;
                else
                    return -1;
            }
        });
        for(Student s: listaStudenti)
            if(s.media()>=5)
            System.out.println(s.toString());
        System.out.println("\n\n");

        for(Student s: listaStudenti)
            if(s.media()<5)
                System.out.println(s.toString());
        System.out.println("\n\n");

        //3
        List<Student> lista = new ArrayList<Student>();
        try {
            Scanner myReader = new Scanner(new File("fisier.txt"));
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                lista.add(new Student(data.split(" ")[0],Integer.parseInt(data.split(" ")[1]),new ArrayList<Integer>(Arrays.asList(Integer.parseInt(data.split(" ")[2]),Integer.parseInt(data.split(" ")[3]),Integer.parseInt(data.split(" ")[4]),Integer.parseInt(data.split(" ")[5]),Integer.parseInt(data.split(" ")[6])       ))));

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu exista.");
        }

        for(Student s: lista)
                System.out.println(s.toString());
        System.out.println("\n\n");

        Map<Student,Integer> mapStudent = new HashMap<Student,Integer>();
        for(Student s1: lista) {

            if (mapStudent.containsKey(s1)) {
                Integer currentValue = mapStudent.get(s1);
                mapStudent.put(s1, currentValue + 1);
            }
            else
                mapStudent.put(s1, 1);

        }

        for(Student key : mapStudent.keySet())
        {
            Integer value = mapStudent.get(key);
            System.out.println(key.toString()+"      "+value);
        }

    }
}