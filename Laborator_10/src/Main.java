import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("1.");
        List<Integer> lista1 = Arrays.asList(5,2,1,6,3,2,7,52,21321,54321,12345,23,12,16);
        System.out.println("a) "+suma(lista1));
        System.out.println("b) "+max(lista1));
        System.out.println("b) "+min(lista1));

        System.out.println("c)");
        List<Integer> lista2 = interval(lista1);
        for(Integer n:lista2) System.out.print(n+"\t");

        System.out.println("d)");
        List<Double> lista3 = convert(lista1);
        for(Double n:lista3) System.out.print(n+"\t");

        System.out.println("e)");
        if(verifica(lista1).size() == 1)
            System.out.println("Da");
        else
            System.out.println("Nu");


        System.out.println("2.");
        List<Integer> lista4 = Arrays.asList(9,10,3,4,7,3,4);
        List<Integer> lista5 = lista4.stream()
                .distinct()
                .map(n-> n*n)
                .collect(Collectors.toList());

        for(Integer n : lista5)
            System.out.print(n+" ");

        System.out.println("\n3.\na)");
        List<String> lista6 = Arrays.asList((new String("Acesta este un program scris cu java 8 si expresii lambda.")).split(" "));

                List<String> lista7 = lista6.stream()
                        .filter(n-> n.length()==5)
                        .collect(Collectors.toList());

                for(String n : lista7)
                    System.out.print(n+" ");
        System.out.println("\nDimensiune "+lista7.size());


        System.out.println("b)");
        List<String> lista8 = lista6.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.print(lista8);

        System.out.println("\nc)");
        List<String> lista9 = lista6.stream()
                .filter(n-> n.startsWith("p"))
                .collect(Collectors.toList());

        System.out.print(lista9);

    }


    public static Integer suma(List<? extends Integer> lista)
    {
        return lista.stream().mapToInt(Integer::intValue).sum();
    }
    public static Integer max(List<? extends Integer> lista)
    {
        return lista.stream().mapToInt(Integer::intValue).max().getAsInt();
    }
    public static Integer min(List<? extends Integer> lista)
    {
        return lista.stream().mapToInt(Integer::intValue).min().getAsInt();
    }

    public static List<Integer> interval(List<? extends Integer> lista)
    {
        return  lista.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
    }
    public static List<Double> convert(List<? extends Integer> lista)
    {
        return  lista.stream()
                .map(Integer::doubleValue)
                .collect(Collectors.toList());
    }

    public static List<Integer> verifica(List<? extends Integer> lista)
    {
          return lista.stream()
                  .map(Integer::intValue)
                  .filter(n->n == 12)
                  .collect(Collectors.toList());
    }



}